package telran.recursion.tests;

import static org.junit.jupiter.api.Assertions.*;
import static telran.recursion.LinearRecursion.*;

import org.junit.jupiter.api.Test;

public class LinearRecursionTest {
	@Test
	void fTest() {
		f(6);
	}

	void f(int a) {
		if (a > 5) {
			f(a - 1);
		}
	}

	@Test
	void factorialTest() {
		assertEquals(24, factorial(4));
		assertEquals(24 * 5 * 6, factorial(6));
		assertEquals(24, factorial(-4));
	}
	
	@Test
	void multiplyTest() {
		assertEquals(0, multiply(1, 0));
		assertEquals(1, multiply(1, 1));
		assertEquals(2, multiply(1, 2));
		assertEquals(2, multiply(2, 1));
		assertEquals(10, multiply(5, 2));
		assertEquals(-10, multiply(-5, 2));
		assertEquals(-10, multiply(5, -2));
	}

	@Test
	void powerTest() {
		assertEquals(1, power(1000, 0));
		assertThrowsExactly(IllegalArgumentException.class, () -> power(1000, -1));
		assertEquals(1000, power(10, 3));
		assertEquals(-1000, power(-10, 3));
	}

	@Test
	void sumTest() {
		int ar[] = { 1, 2, 3, 4, 5, 6 };
		assertEquals(21, sum(ar));
		assertEquals(0, sum(new int[0]));
	}

	@Test
	void reverseTest() {
		int ar[] = { 1, 2, 3, 4, 5, 6 };
		int expected[] = { 6, 5, 4, 3, 2, 1 };
		int ar1[] = { 1, 2, 3, 4, 5, 6, 7 };
		int expected1[] = { 7, 6, 5, 4, 3, 2, 1 };
		reverse(ar);
		reverse(ar1);
		assertArrayEquals(expected, ar);
		assertArrayEquals(expected1, ar1);

	}
	
	@Test
	void squareTest() {
		assertEquals(0, square(0));
		assertEquals(1, square(-1));
		assertEquals(1, square(1));
		assertEquals(4, square(2));
		assertEquals(9, square(3));
		assertEquals(25, square(5));
		assertEquals(18225, square(135));
		assertEquals(935 * 935, square(935));
	}
	
	@Test
	void isSameStringTest() {
		assertTrue(isSameString("", ""));
		assertFalse(isSameString("", " "));
		assertFalse(isSameString(" ", ""));
		assertTrue(isSameString("qwerty", "qwerty"));
		assertFalse(isSameString("qwerty", "asdfgh"));
	}
	
	@Test
	void isSubstringTest() {
		assertTrue(isSubstring("qwerty", "qwerty"));
		assertTrue(isSubstring("aqwerty", "qwerty"));
		assertFalse(isSubstring("werty", "qwerty"));
		assertTrue(isSubstring("aqwerty", "qwe"));
		assertTrue(isSubstring("aqwerty", "q"));
	}
}