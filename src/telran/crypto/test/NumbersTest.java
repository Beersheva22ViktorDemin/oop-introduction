package telran.crypto.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.cryto.*;

class NumbersTest {

	@Test
	void countDigitsTest() {
		assertEquals(1, Numbers.countDigits(0, 2));
		assertEquals(1, Numbers.countDigits(1, 2));
		assertEquals(2, Numbers.countDigits(2, 2));
		assertEquals(2, Numbers.countDigits(3, 2));
		assertEquals(3, Numbers.countDigits(6, 2));
		
		assertEquals(1, Numbers.countDigits(0, 3));
		assertEquals(1, Numbers.countDigits(1, 3));
		assertEquals(1, Numbers.countDigits(2, 3));
		assertEquals(2, Numbers.countDigits(3, 3));
		assertEquals(2, Numbers.countDigits(6, 3));
	}
	
	@Test
	void getDigitsTest() {
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, Numbers.getDigits(1234, 10));
		
		assertArrayEquals(new int[] { 1, 0 }, Numbers.getDigits(2, 2));
		assertArrayEquals(new int[] { 1, 1 }, Numbers.getDigits(3, 2));
		assertArrayEquals(new int[] { 1, 1, 0 }, Numbers.getDigits(6, 2));
		
		assertArrayEquals(new int[] { 2 }, Numbers.getDigits(2, 3));
		assertArrayEquals(new int[] { 1, 0 }, Numbers.getDigits(3, 3));
		assertArrayEquals(new int[] { 1, 1 }, Numbers.getDigits(4, 3));
		assertArrayEquals(new int[] { 1, 2 }, Numbers.getDigits(5, 3));
		assertArrayEquals(new int[] { 2, 0 }, Numbers.getDigits(6, 3));
	}
	
	@Test
	void getNumberFromDigitsTest() {
		assertEquals(1234, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }, 10));
		assertEquals(10, Numbers.getNumberFromDigits(new int[] { 1, 0 }, 10));
		
		assertEquals(2, Numbers.getNumberFromDigits(new int[] { 1, 0 }, 2));
		assertEquals(3, Numbers.getNumberFromDigits(new int[] { 1, 1 }, 2));
		assertEquals(4, Numbers.getNumberFromDigits(new int[] { 1, 0, 0 }, 2));
		assertEquals(5, Numbers.getNumberFromDigits(new int[] { 1, 0, 1 }, 2));
		
		assertEquals(6, Numbers.getNumberFromDigits(new int[] { 2, 0 }, 3));
	}

}
