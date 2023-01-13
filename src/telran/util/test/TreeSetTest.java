package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

public class TreeSetTest extends SetTest {
	
	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new TreeSet<>();
		super.setUp();
	}
	
	@Override
	@Test
	void testIterator() {
		for (int i = 0; i < N_RUNS; i++) {
			TreeSet set = new TreeSet();
			Integer[] bigArray = getRandomArray();
			fillSet(set, bigArray);
			
			int size = set.size();
			int count = 0;
			Iterator it = set.iterator();
			while (it.hasNext()) {
				it.next();
				count++;
			}
			assertEquals(size, count);
		}
	}

}
