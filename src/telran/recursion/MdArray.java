
package telran.recursion;

import java.util.Arrays;
import java.util.Iterator;
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
		consumer.accept(value);
		
		/*
		 * If value does not equal null the method calls consumer.accept(value) non-
recursion exit from the method, otherwise the “this” object has array of
MdArray objects of on one dimension less (field array) and the method runs
cycle passing over all MdArray objects and for each such object the method
forEach is called
		 */
	}
	
	public T[] toArray(T[] ar) {
//		int size = size();
//		if (ar.length < size) {
//			ar = Arrays.copyOf(ar, size);
//		}
//		int i = 0;
//		Iterator<T> iterator = iterator();
//		while(iterator.hasNext()) {
//			ar[i++] = iterator.next();
//		}
//		Arrays.fill(ar, size, ar.length, null);
		return ar;	
	}

	public T getValue(int dimensions[]) {
		return null;
	}
	
	public void setValue(int dimensions[], T value) {
	}
}