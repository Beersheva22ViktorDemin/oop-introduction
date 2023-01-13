package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

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

}
