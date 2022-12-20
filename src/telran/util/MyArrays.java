package telran.util;

import java.util.Comparator;

public class MyArrays {
	public static <T> void sort(T[] objects, Comparator<T> comparator) {
		int length = objects.length;
		do {
			length--;
		} while (moveMaxAtEnd(objects, length, comparator));
	}
	
	public static <T> int binarySearch(T[] array, T searchedNumber, Comparator<T> comparator) {
		int left = 0;
		int right = array.length - 1;
		int middle = array.length / 2;
		while(left <= right && comparator.compare(array[left], searchedNumber) != 0) {
			if (comparator.compare(searchedNumber, array[middle]) <= 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left < array.length && comparator.compare(array[left], searchedNumber) == 0 ? left : -left - 1;
	}

	private static <T> boolean moveMaxAtEnd(T[] objects, int length, Comparator<T> comparator) {
		boolean result = false;
		for (int i = 0; i < length; i++) {
			if (comparator.compare(objects[i], objects[i + 1]) > 0) {
				swap(objects, i, i + 1);
				result = true;
			}
		}
		
		return result;
	}

	private static <T> void swap(T[] objects, int i, int j) {
		T tmp = objects[i];
		objects[i] = objects[j];
		objects[j] = tmp;
	}
}