package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
