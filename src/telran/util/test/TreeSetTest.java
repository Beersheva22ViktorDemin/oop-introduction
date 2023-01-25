package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.TreeSet;

public class TreeSetTest extends SortedTest {
	TreeSet<Integer> tree;
	
	@BeforeEach
	@Override
	void setUp() throws Exception {
		collection = new TreeSet<Integer>();
		super.setUp();
		tree = (TreeSet<Integer>) collection;
	}

	@Test
	void myTestIterator() {
		for (int i = 0; i < N_RUNS; i++) {
			TreeSet set = new TreeSet();
			Integer[] bigArray = getRandomArray();
			fillSet(set, bigArray);

			int size = set.size();
			int count = 0;
			Integer prevValue = Integer.MIN_VALUE;
			Iterator it = set.iterator();
			while (it.hasNext()) {
				var value = it.next();
				assertEquals(1, Integer.compare((int) value, prevValue));
				count++;
			}
			assertEquals(size, count);
		}
	}
	
	@Test
	void displayRotatatedTest() {
		tree.displayTreeRotated();
	}
	@Test
	void heightTreeTest() {
		assertEquals(4, tree.height());
	}
	@Test
	void widthTreeTest() {
		assertEquals(4, tree.width());
	}
	@Test
	void inversionTest() {
		//{10, 100, -5, 134, 280, 120, 15};
		tree.inversion();
		Integer expected[] = {280, 134, 120, 100, 15, 10, -5};
		Integer actual[] = new Integer[expected.length];
		int index = 0;
		for(Integer num: tree) {
			actual[index++] = num;
		}
		assertArrayEquals(expected, actual);
		assertTrue(tree.contains(280));
	}
}
