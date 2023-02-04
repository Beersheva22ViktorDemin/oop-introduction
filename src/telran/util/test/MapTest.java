package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Collection;
import telran.util.Map;

abstract class MapTest {
Map<Integer, String> map;
	@BeforeEach
	void setUp() throws Exception {
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
	}

	@Test
	void getOrDefaultTest() {
		assertEquals("One", map.getOrDefault(1, "Default"));
		assertEquals("Default", map.getOrDefault(1000, "Default"));
	}
	
	@Test
	void getTest() {
		assertEquals("One", map.get(1));
		assertNull(map.get(1000));
	}
	
	@Test
	void putTest( ) {
		assertEquals("One", map.put(1, "àçã"));
		assertEquals("àçã", map.get(1));
		assertNull(map.put(4, "Four"));
		assertEquals("Four", map.get(4));
	}
	
	@Test
	void putIfAbsentTest() {
		assertEquals("One", map.putIfAbsent(1, "àçã"));
		assertEquals("One", map.get(1));
		assertNull(map.putIfAbsent(4, "Four"));
		assertEquals("Four", map.get(4));
	}
	
	@Test
	void containsKeyTest() {
		assertTrue(map.containsKey(1));
		map.put(1, null);
		assertTrue(map.containsKey(1));
		assertFalse(map.containsKey(1000));
	}
	
	@Test
	void valuesTest() {
		Collection<String> values = map.values();
		assertEquals(3, values.size());
		assertTrue(values.contains("One"));
		assertTrue(values.contains("Two"));
		assertTrue(values.contains("Three"));
		assertFalse(values.contains("Four"));
	}
	
	@Test
	void containsValueTest() {
		assertTrue(map.containsValue("One"));
		assertTrue(map.containsValue("Two"));
		assertTrue(map.containsValue("Three"));
		assertFalse(map.containsValue("Four"));
	}
	
	@Test
	void removeTest() {
		assertTrue(map.containsKey(1));
		assertEquals("One", map.remove(1));
		assertFalse(map.containsKey(1));
		assertFalse(map.containsKey(1000));
		assertNull(map.remove(1000));
	}
	
	@Test
	void keySetTest() {
		Integer expected [] = {1, 2, 3};
		Arrays.sort(expected);
		
		Integer actual[] = {};
		actual = map.keySet().toArray(actual);
		Arrays.sort(actual);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void entrySetTest() {
		assertEquals(3, map.entrySet().size());
	}




}
