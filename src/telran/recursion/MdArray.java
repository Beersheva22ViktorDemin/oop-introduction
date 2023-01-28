
package telran.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MdArray<T> {
	public MdArray<T>[] array;
	public T value;

	public MdArray(int dimensions[], T value) {
		this(dimensions, 0, value);
	}

	@SuppressWarnings("unchecked")
	public MdArray(int[] dimensions, int firstDim, T value) {
		if (firstDim == dimensions.length) {
			this.value = value;
			array = null;
		} else {
			this.value = null;
			array = new MdArray[dimensions[firstDim]];
			for (int i = 0; i < array.length; i++) {
				array[i] = new MdArray<>(dimensions, firstDim + 1, value);
			}
		}
	}

	public void forEach(Consumer<T> consumer) {
		if (value != null) {
			consumer.accept(value);
		} else {
			for (var element : array) {
				element.forEach(consumer);
			}
		}
	}

	public T[] toArray(T[] ar) {
		ArrayList<T> resultList = new ArrayList<T>();
		if (value != null) {
			resultList.add(value);
		} else {
			for (MdArray<T> mdElement : array) {
				T[] array = mdElement.toArray(ar);
				for (T elememnt : array) {
					resultList.add(elememnt);
				}
			}
		}

		return resultList.toArray(ar);
	}

	public T getValue(int dimensions[]) {
		MdArray<T> mdArray = getMdArray(dimensions, value);
		return mdArray.value;
	}

	public void setValue(int dimensions[], T value) {
		MdArray<T> mdArray = getMdArray(dimensions, value);
		mdArray.value = value;
	}

	private MdArray<T> getMdArray(int dimensions[], T value) {
		MdArray<T>[] pointer = array;
		for (int i = 0; i < dimensions.length - 1; i++) {
			int dimension = dimensions[i];
			if (dimension < pointer.length) {
				pointer = pointer[dimension].array;
				if (pointer == null) {
					throw new NoSuchElementException();
				}
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}

		MdArray<T> result;
		int dimension = dimensions[dimensions.length - 1];
		if (dimension < pointer.length) {
			if (pointer[dimension].array != null) {
				throw new IllegalStateException();
			}
			result = pointer[dimension];
			if (result.value == null) {
				throw new NoSuchElementException();
			}
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
		return result;
	}
}