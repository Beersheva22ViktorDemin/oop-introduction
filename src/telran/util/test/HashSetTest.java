package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

public class HashSetTest extends SetTest {

	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new HashSet<>(4, 0.75f);
		super.setUp();
	}

	@Override
	@Test
	void testIterator() {
		Predicate<Integer> allPredicate = n -> true;
		HashSet<Integer> set = new HashSet<>();
		fillSet(set, new Integer[] {0, 16, 32, 48, 512, 128});
		set.removeIf(allPredicate);
		assertTrue(set.isEmpty());
		for (int i = 0; i < N_RUNS; i++) {
			Integer[] bigArray = getRandomArray();
			fillSet(set, bigArray);
			set.removeIf(allPredicate);
			assertTrue(set.isEmpty());
			
		}
		
	}

}