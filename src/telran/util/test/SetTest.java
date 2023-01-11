package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

abstract class SetTest extends CollectionTest {
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

	@Override
	@Test
	void testIterator() {
		int size = set.size();
		int count = 0;
		Iterator it = set.iterator();
		while (it.hasNext()) {
			it.next();
			count++;
		}
		assertEquals(size, count);
		
		it.remove();
		assertEquals(--size, set.size());
		assertFalse(it.hasNext());

		it = set.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		assertEquals(0, set.size());
	}

}