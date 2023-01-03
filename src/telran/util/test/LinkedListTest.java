package telran.util.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

class LinkedListTest extends ListTest{
	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}

	@Test
	void removeTest() {
		LinkedList <Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.remove(0);
		assertEquals(0, list.size());
	}
}
