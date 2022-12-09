package telran.crypto.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.cryto.BaseCipher;

class BaseCipherTest {

	@Test
	void BaseCipherBase2ManualTest() {
		BaseCipher object = new BaseCipher(BaseCipher.MIN_LENGTH);		
		object.setKey("01");
		Integer number = 10;
		String cipher = object.cipher(number);
		assertEquals("1010", cipher);
		assertEquals(number, object.decipher(cipher));
	}
	
	@Test
	void BaseCipherBase10Test() {
		BaseCipher object = new BaseCipher(10);
		object.setKey("0123456789");
		Integer number = 10;
		String cipher = object.cipher(number);
		assertEquals("10", cipher);
		assertEquals(number, object.decipher(cipher));
	}
	
	@Test
	void BaseCipherBase2LettersTest() {
		BaseCipher object = new BaseCipher(2);
		object.setKey("ab");
		Integer number = 0;
		String cipher = object.cipher(number);
		assertEquals("a", cipher);
		assertEquals(number, object.decipher(cipher));
		
		number = 1;
		cipher = object.cipher(number);
		assertEquals("b", cipher);
		assertEquals(number, object.decipher(cipher));
		
		number = 2;
		cipher = object.cipher(number);
		assertEquals("ba", cipher);
		assertEquals(number, object.decipher(cipher));
		
		number = 3;
		cipher = object.cipher(number);
		assertEquals("bb", cipher);
		assertEquals(number, object.decipher(cipher));
		
		number = 4;
		cipher = object.cipher(number);
		assertEquals("baa", cipher);
		assertEquals(number, object.decipher(cipher));
	}
	
	@Test
	void BaseCipherAutoTest() {
		Integer[] numbers = new Integer[] { 0, 2, 4, 10, 100, 500, 9999, Integer.MAX_VALUE };
		Integer[] bases = new Integer[] { 0, 2, 4, 10, 100, 500, 9999, Integer.MAX_VALUE };
		for (int number: numbers) {
			for (int base: bases) {
				BaseCipher object = new BaseCipher(base);
				String cipher = object.cipher(number);
				assertEquals(number, object.decipher(cipher));
			}
		}
	}

}
