package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.*;

class ArrayListTest {
	
	@Test
	void removeTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(3);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(5);
		
		Integer pattern = 5;
		assertTrue(arrayList.contains(pattern));
		assertTrue(arrayList.remove(pattern));
		assertFalse(arrayList.contains(pattern));
		assertFalse(arrayList.remove(pattern));
		
		pattern = 2;
		arrayList.add(5);
		assertTrue(arrayList.contains(2));
		assertTrue(arrayList.contains(5));
		assertTrue(arrayList.remove(pattern));
		assertFalse(arrayList.contains(2));
		assertTrue(arrayList.contains(5));
		assertFalse(arrayList.remove(pattern));
	}
	
	@Test
	void removeIfTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(3);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(5);
		
		Predicate<Integer> predicate = Predicate.isEqual(5);
		assertTrue(arrayList.contains(5));
		assertTrue(arrayList.removeIf(predicate));
		assertFalse(arrayList.contains(5));
		assertFalse(arrayList.removeIf(predicate));
		
		predicate = Predicate.isEqual(2);
		arrayList.add(5);
		assertTrue(arrayList.contains(2));
		assertTrue(arrayList.contains(5));
		assertTrue(arrayList.removeIf(predicate));
		assertFalse(arrayList.contains(2));
		assertTrue(arrayList.contains(5));
		assertFalse(arrayList.removeIf(predicate));
	}
	
	@Test
	void isEmptyTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(3);

		Integer element = 1;
		assertTrue(arrayList.isEmpty());
		arrayList.add(element);
		assertFalse(arrayList.isEmpty());
		arrayList.add(element);
		assertFalse(arrayList.isEmpty());
		arrayList.remove(element);
		assertFalse(arrayList.isEmpty());
		arrayList.remove(element);
		assertTrue(arrayList.isEmpty());
	}
	
	@Test
	void containsTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(3);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(5);
		
		assertTrue(arrayList.contains(1));
		assertTrue(arrayList.contains(2));
		assertTrue(arrayList.contains(5));
		assertFalse(arrayList.contains(-1));
	}
	
	@Test
	void toArrayTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(null);
		
		Integer[] expected = {1, 1, 1, 2, 5, null};
		Integer[] input = new Integer[3];
		assertArrayEquals(expected, arrayList.toArray(input));
		
		input = new Integer[] {1, 1, 1, 2, 5, null, 0, 0, 25};
		expected = new Integer[] {1, 1, 1, 2, 5, null, null, null, null};
		assertArrayEquals(expected, arrayList.toArray(input));
	}
	
	@Test
	void getAndSetTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(5);
		assertEquals(1, arrayList.get(0));
		assertEquals(5, arrayList.get(1));
		
		arrayList.set(0, -10);
		assertEquals(-10, arrayList.get(0));
		assertEquals(5, arrayList.get(1));
		
		arrayList.set(1, -10);
		assertEquals(-10, arrayList.get(0));
		assertEquals(-10, arrayList.get(1));
	}
	
	@Test
	void addTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(0, 4);
		arrayList.add(0, 3);
		arrayList.add(0, 2);
		arrayList.add(0, 1);
		
		assertEquals(1, arrayList.get(0));
		assertEquals(2, arrayList.get(1));
		assertEquals(3, arrayList.get(2));
		assertEquals(4, arrayList.get(3));
		assertEquals(5, arrayList.get(4));
		
		arrayList.add(4, 10);
		assertEquals(10, arrayList.get(4));
	}
	
	@Test
	void indexTest() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(5);
		
		assertEquals(-1, arrayList.indexOf(0));
		assertEquals(0, arrayList.indexOf(1));
		assertEquals(2, arrayList.lastIndexOf(1));
		assertEquals(4, arrayList.lastIndexOf(5));
	}

}