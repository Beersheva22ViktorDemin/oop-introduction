package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Sorted;

public class SortedTest extends SetTest{
	Sorted<Integer> sorted;
	@Override
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		 sorted = (Sorted<Integer>)collection;
	}

	@Override
	@Test
	void testIterator() {
		Integer expected [] = Arrays.copyOf(numbers, numbers.length);
		Arrays.sort(expected);
		Integer actual[] = new Integer[expected.length];
		int index = 0;
		for(Integer num: sorted) {
			actual[index++] = num;
		}
		assertArrayEquals(expected, actual);
		
	}
	//{-5, 10, 15, 100, 120, 134, 280  };
	@Test
	void floorTest() {
		assertEquals((Integer)100, sorted.floor(100));
		assertNull(sorted.floor(-10));
		assertEquals((Integer)15, sorted.floor(20));
		assertEquals((Integer)280, sorted.floor(300));
		assertEquals((Integer)100, sorted.floor(115));
	}
	@Test
	void ceilingTest() {
		assertEquals((Integer)100, sorted.ceiling(100));
		assertNull(sorted.ceiling(281));
		assertEquals((Integer)15, sorted.ceiling(13));
		assertEquals((Integer)10, sorted.ceiling(0));
		assertEquals((Integer)(-5), sorted.ceiling(-10));
		assertEquals((Integer)280, sorted.ceiling(150));
	}
	@Test
	void firstTest() {
		assertEquals((Integer)(-5),sorted.first());
	}
	@Test
	void lastTest() {
		assertEquals((Integer)280,sorted.last());
	}

}