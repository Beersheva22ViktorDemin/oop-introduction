package telran.recursion.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.recursion.MdArray;

public class MdArrayTests {

	@Test
	@Disabled
	void constructorTest() {
		MdArray<Integer> array = new MdArray<Integer>(new int[] { 10, 5, 7 }, 50);
		MdArray<String> strings = new MdArray<>(new int[] { 3, 15, 7, 2, 10 }, "hello");
	}

	@Test
	void forEachTest() {
		MdArray<Integer> array = new MdArray<Integer>(new int[] { 10, 5, 7 }, 50);
		Integer[] sum = { 0 };
		array.forEach(num -> sum[0] += num);
		assertEquals(17500, sum[0]);

		MdArray<String> strings = new MdArray<>(new int[] { 3, 15, 7, 2, 10 }, "hello");
		Integer[] length = { 0 };
		strings.forEach(str -> length[0] += str.length());
		assertEquals(31500, length[0]);
	}

	@Test
	void toArrayTest() {
		MdArray<Integer> array = new MdArray<Integer>(new int[] { 10, 5, 7 }, 50);
		Integer[] numbers = array.toArray(new Integer[0]);
		assertEquals(350, numbers.length);
		for (var element : numbers) {
			assertEquals(50, element);
		}

		MdArray<String> strings = new MdArray<>(new int[] { 3, 15, 7, 2, 10 }, "hello");
		String[] stringsArray = strings.toArray(new String[0]);
		assertEquals(6300, stringsArray.length);
		for (var element : stringsArray) {
			assertEquals("hello", element);
		}
	}

	@Test
	void getValueTest() {
		MdArray<Integer> array = new MdArray<Integer>(new int[] { 10, 5, 7 }, 50);
		assertEquals(50, array.getValue(new int[] { 3, 4, 6 }));
		assertThrowsExactly(IllegalStateException.class, () -> array.getValue(new int[] { 3, 4 }));
		assertThrowsExactly(NoSuchElementException.class, () -> array.getValue(new int[] { 3, 4, 6, 0 }));
		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> array.getValue(new int[] { 3, 4, 7 }));
	}

	@Test
	void setValueTest() {
		MdArray<Integer> array = new MdArray<Integer>(new int[] { 10, 5, 7 }, 50);
		array.setValue(new int[] { 3, 4, 6 }, 100);
		assertEquals(100, array.getValue(new int[] { 3, 4, 6 }));
		assertThrowsExactly(IllegalStateException.class, () -> array.setValue(new int[] { 3, 4 }, 100));
		assertThrowsExactly(NoSuchElementException.class, () -> array.setValue(new int[] { 3, 4, 6, 0 }, 100));
		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> array.setValue(new int[] { 3, 4, 7 }, 100));
	}

}
