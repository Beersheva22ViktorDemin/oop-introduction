package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {

	@Test
	void sortTest() {
		String[] strings = { "abcd", "lmn", "zz" };
		String[] expected = { "zz", "lmn", "abcd" };
		Integer[] array = { 3, 2, 1 };

		MyArrays.sort(strings, new StringLengthComparator());
		assertArrayEquals(expected, strings);
		MyArrays.sort(array, (a, b) -> a - b);

	}
	
	@Test
	@Disabled
	void evenOddTest() {
		Integer numbers[] = {13, 2, -8, 47, 100, 10, 7};
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7};
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
	}
	
	@Test
	void binarySearchTest() {
		Comparator<Integer> comparator = new IntegerComparator();
		
		assertEquals(-1, MyArrays.binarySearch(new Integer[] { 1, 2 }, 0, comparator));
		assertEquals(-2, MyArrays.binarySearch(new Integer[] { 1, 3 }, 2, comparator));
		assertEquals(1, MyArrays.binarySearch(new Integer[] { 1, 2, 3 }, 2, comparator));
		assertEquals(1, MyArrays.binarySearch(new Integer[] { 1, 2, 2, 3 }, 2, comparator));
		assertEquals(1, MyArrays.binarySearch(new Integer[] { 1, 2, 2, 2, 3 }, 2, comparator));
		
		Integer array[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 20, 40 };
		assertEquals(-14, MyArrays.binarySearch(array, 3, comparator));
		assertEquals(3, MyArrays.binarySearch(array, 2, comparator));
		assertEquals(-1, MyArrays.binarySearch(array, 0, comparator));
		assertEquals(13, MyArrays.binarySearch(array, 4, comparator));
		assertEquals(0, MyArrays.binarySearch(array, 1, comparator));
		assertEquals(-16, MyArrays.binarySearch(array, 25, comparator));
		assertEquals(-17, MyArrays.binarySearch(array, 45, comparator));
	}
}