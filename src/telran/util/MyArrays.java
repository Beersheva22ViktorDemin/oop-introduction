package telran.util;

import java.util.Comparator;

public class MyArrays {
	public static <T> void sort(T[] objects, Comparator<T> comparator) {
		int length = objects.length;
		do {
			length--;
		} while (moveMaxAtEnd(objects, length, comparator));
	}
	
	public static <T> int binarySearch(T[] arraySorted, T key, Comparator<T> comp) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while(left <= right && !arraySorted[middle].equals(key)) {
			if (comp.compare(key,arraySorted[middle]) < 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left > right ? -left - 1 : middle;
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