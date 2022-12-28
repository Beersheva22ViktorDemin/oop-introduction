package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {
	static final int N_NUMBERS = 10000;
	static final int N_RUNS = 1000;
	

	Integer numbers[] = { 13, 2, -8, 47, 100, 10, -7, 7 };
	String strings[] = { "ab", "abm", "abmb", "abmbc" };
	Comparator<Integer> evenOddComparator = this::evenOddCompare;

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
	void evenOddTest() {
		Comparator<Integer> comparator = new EvenOddComparator();
		Integer numbers[] = { 1, 2 };
		Integer expected[] = { 2, 1 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { 1, 3 };
		expected = new Integer[] { 3, 1 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { -1, 3 };
		expected = new Integer[] { 3, -1 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { 2, 3 };
		expected = new Integer[] { 2, 3 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { -2, 3 };
		expected = new Integer[] { -2, 3 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { 3, 2 };
		expected = new Integer[] { 2, 3 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { -1, -2 };
		expected = new Integer[] { -2, -1 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { -1, -3 };
		expected = new Integer[] { -1, -3 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);

		numbers = new Integer[] { 13, 2, -8, 47, 100, 10, 7 };
		expected = new Integer[] { -8, 2, 10, 100, 47, 13, 7 };
		MyArrays.sort(numbers, comparator);
		assertArrayEquals(expected, numbers);
	}

	@Test
	void binarySearchTest() {
		Comparator<Integer> comparator = new IntegerComparator();

		assertEquals(-1, MyArrays.binarySearch(new Integer[] { 1, 2 }, 0, comparator));
		assertEquals(-2, MyArrays.binarySearch(new Integer[] { 1, 3 }, 2, comparator));
		assertEquals(1, MyArrays.binarySearch(new Integer[] { 1, 2, 3 }, 2, comparator));
		assertEquals(1, MyArrays.binarySearch(new Integer[] { 1, 2, 2, 3 }, 2, comparator));
//		assertEquals(1, MyArrays.binarySearch(new Integer[] { 1, 2, 2, 2, 3 }, 2, comparator));

//		Integer array[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 20, 40 };
//		assertEquals(-14, MyArrays.binarySearch(array, 3, comparator));
//		assertEquals(3, MyArrays.binarySearch(array, 2, comparator));
//		assertEquals(-1, MyArrays.binarySearch(array, 0, comparator));
//		assertEquals(13, MyArrays.binarySearch(array, 4, comparator));
//		assertEquals(0, MyArrays.binarySearch(array, 1, comparator));
//		assertEquals(-16, MyArrays.binarySearch(array, 25, comparator));
//		assertEquals(-17, MyArrays.binarySearch(array, 45, comparator));

		String strings[] = { "ab", "abm", "abmb", "abmbc" };
		Comparator<String> comp = new StringsComparator();
		assertEquals(0, MyArrays.binarySearch(strings, "ab", comp));
		assertEquals(2, MyArrays.binarySearch(strings, "abmb", comp));
		assertEquals(3, MyArrays.binarySearch(strings, "abmbc", comp));
		assertEquals(-1, MyArrays.binarySearch(strings, "a", comp));
		assertEquals(-3, MyArrays.binarySearch(strings, "abma", comp));
		assertEquals(-5, MyArrays.binarySearch(strings, "lmn", comp));
	}

	@Test
	void filterTest() {
		int dividor = 2;
		String subStr = "m";
		Predicate<Integer> predEven = t -> t % dividor == 0;
		Predicate<String> predSubstr = s -> s.contains(subStr);
		String expectedStr[] = { "abm", "abmb", "abmbc" };
		Integer expectedNumbers[] = { 2, -8, 100, 10 };
		assertArrayEquals(expectedStr, MyArrays.filter(strings, predSubstr));
		assertArrayEquals(expectedNumbers, MyArrays.filter(numbers, predEven));

	}

	int evenOddCompare(Integer o1, Integer o2) {
		int remainder = Math.abs(o1) % 2;
		int res = remainder - Math.abs(o2) % 2;
		if (res == 0) {
			res = remainder != 0 ? Integer.compare(o2, o1) : Integer.compare(o1, o2);
		}
		return res;
	}

	@Test
	void removeIfTest() {
		int dividor = 2;
		String subStr = "m";
		Predicate<Integer> predEven = t -> t % dividor == 0;
		Predicate<String> predSubstr = s -> s.contains(subStr);
		String expectedStr[] = { "ab", };
		Integer expectedNumbers[] = { 13, 47, -7, 7 };
		assertArrayEquals(expectedStr, MyArrays.removeIf(strings, predSubstr));
		assertArrayEquals(expectedNumbers, MyArrays.removeIf(numbers, predEven));
		
		Integer expected[] = { 2, -8, 100, 10 };
		assertArrayEquals(expected, MyArrays.removeIf(numbers, n -> n % 2 != 0));
	}

	@Test
	void removeRepeatedTest() {
		Integer input[] = { 100, 10, 18, 10, 20, 18 };
		Integer expected[] = { 100, 10, 18, 20 };
		assertArrayEquals(expected, MyArrays.removeRepeated(input));
	}

	@Test
	void containsTest() {
		assertTrue(MyArrays.contains(numbers, 13));
		assertFalse(MyArrays.contains(numbers, -40));

		assertTrue(MyArrays.contains(strings, "abm"));
		assertFalse(MyArrays.contains(strings, "abml"));
	}

	@Test
	void removeRepeated() {
		Integer expected[] = { 13, 2, -8, 47, 100, 10, -7, 7 };
		assertArrayEquals(expected, MyArrays.removeRepeated(numbers));
		String strings[] = { "aaa", "cccc", "aaa", "aaa" };
		assertArrayEquals(new String[] { "aaa", "cccc" }, MyArrays.removeRepeated(strings));
		Integer[] numbersRepeatedValues = { 13, 13, 2, -8, -8, 47, 100, 100, 100, 10, 7, 7, 13 };
		Integer expected2[] = { 13, 2, -8, 47, 100, 10, 7 };
		assertArrayEquals(expected2, MyArrays.removeRepeated(numbersRepeatedValues));
	}

	@Test
	void joinFunctionalTest() {
		String expected = "13,2,-8,47,100,10,-7,7,13,47,7,-7";
		Integer numbers[] = {13, 2, -8, 47, 100, 10, -7, 7, 13, 47, 7, -7};
		assertEquals(expected, MyArrays.join(numbers, ","));
	}

	@Test
	void joinPerformanceTest() {
		Integer largeArray[] = getLargeNumbersArray();
		for (int i = 0; i < N_RUNS; i++) {
			MyArrays.join(largeArray, ",");
		}
	}

	Integer[] getLargeNumbersArray() {
		Integer[] res = new Integer[N_NUMBERS];
		Arrays.fill(res, 1000);
		return res;
	}

}