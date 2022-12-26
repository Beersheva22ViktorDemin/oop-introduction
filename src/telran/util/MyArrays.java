package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

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
	
	public static<T> T[] filter(T[] array, Predicate<T> predicate) {
		int countPredicate = getCountPredicate(array, predicate);
		
		T[] res = Arrays.copyOf(array, countPredicate);
		int index = 0;
		for(T element: array) {
			if(predicate.test(element)) {
				res[index++] = element;
			}
		}
		
		return res;
	}

	private static <T> int getCountPredicate(T[] array, Predicate<T> predicate) {
		int res = 0;
		
		for(T element: array) {
			if(predicate.test(element)) {
				res++;
			}
		}
		
		return res;
	}
	
	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		//one code line with no additional methods
		return filter(array, predicate.negate());
	}
	
	public static <T> T[] removeRepeated(T[] array) {
		//try to write this method based on removeIf
		T[] result = array.clone();
		Arrays.fill(result, null);
		int index = 0;
		while (array.length > 0) {
			result[index++] = array[0];
			array = removeIf(array, t -> contains(result, t));
		}
		return Arrays.copyOf(result, index);
	}
	
	public static <T> boolean contains(T[] array, T pattern) {
		for(T element: array) {
			if (element != null && element.equals(pattern)) {
				return true;
			} else if (element == null && pattern == null) {
				return true;
			}
		}
		
		return false;
	}
}