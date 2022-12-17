package telran.memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemoryOperationsTest {
	byte[] array;

	@Test
	void maxMemoryTest() {
		int maxMemory = MemoryOperations.getMaxAvaibleMemory();
		
		array = new byte[maxMemory];
		array = null;
		boolean flagException = false;
		try {
			array = new byte[maxMemory + 1];

		} catch (Throwable e) {
			flagException = true;
		}
		assertTrue(flagException);
	}

}