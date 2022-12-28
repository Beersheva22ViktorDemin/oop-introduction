package telran.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;

	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean add(T element) {
		if (size == array.length) {
			reallocate();
		}
		array[size++] = element;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public boolean remove(T pattern) {
		int index = 0;
		boolean result = false;
		while (index < size & !result) {
			if (isEqual(array[index], pattern)) {
				remove(index);
				result = true;
			}
			index++;
		}
		return result;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		int index = 0;
		boolean result = false;
		while (index < size) {
			if (predicate.test(array[index])) {				
				remove(index);
				result = true;
			} else {
				index++;	
			}
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean contains(T pattern) {
		return indexOf(pattern) > -1;
	}
	
	private static boolean isEqual(Object element, Object pattern) {
		return element == null ? element == pattern : element.equals(pattern);
	}

	@Override
	public T[] toArray(T[] ar) {
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		System.arraycopy(array, 0, ar, 0, size);
		Arrays.fill(ar, size, ar.length, null);
		return ar;
	}

	@Override
	public void add(int index, T element) {
		checkIndex(index);
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = element;
		size++;
	}

	@Override
	public T remove(int index) {
		T result = get(index);
		System.arraycopy(array, index + 1, array, index, size - index);
		size--;
		
		return result;
	}

	@Override
	public int indexOf(T pattern) {
		int index = 0;
		while (index < size && !isEqual(array[index], pattern)) {
			index++;
		}

		return index < size ? index : -1;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int result = -1;
		for (int i = 0; i < size; i++) {
			if (isEqual(array[i], pattern)) {
				result = i;
			}
		}

		return result;
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return array[index];
	}

	@Override
	public void set(int index, T element) {
		checkIndex(index);
		array[index] = element;
	}
	
	private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
	}

}