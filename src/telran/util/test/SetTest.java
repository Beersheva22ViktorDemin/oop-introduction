package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

abstract class SetTest extends CollectionTest {
	Random random = new Random();
	protected static final int N_RUNS = 10;
	protected static final int N_NUMBERS = 100000;
	
	Set<Integer> set ;
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		set = (Set<Integer>) collection;
	}

	@Override
	@Test
	void testAdd() {
		assertTrue(set.add(Integer.MAX_VALUE));
		assertFalse(set.add(Integer.MAX_VALUE));

	}

	@Test
	void testIteratorExtra() {
		int size = set.size();
		int count = 0;
		Iterator it = set.iterator();
		while (it.hasNext()) {
			it.next();
			count++;
		}
		assertEquals(size, count);
//		
//		it.remove();
//		assertEquals(--size, set.size());
//		assertFalse(it.hasNext());
//
//		it = set.iterator();
//		while (it.hasNext()) {
//			it.next();
//			it.remove();
//		}
//		assertEquals(0, set.size());
	}
	
	protected Integer[] getRandomArray() {
		Integer result[] = new Integer[N_NUMBERS];
		for(int i = 0; i < N_NUMBERS; i++) {
			result[i] = random.nextInt();
		}
		return result;
	}

	protected void fillSet(Set<Integer> set, Integer[] numbers) {
		for(Integer num: numbers) {
			set.add(num);
		}
		
	}

}