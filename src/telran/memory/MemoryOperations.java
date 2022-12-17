package telran.memory;

public class MemoryOperations {
	public static int getMaxAvaibleMemory() {
		int result = Integer.MAX_VALUE;
		boolean running = true;
		byte[] array = null;
		while (running) {
			try {
				array = new byte[result];
				running = false;

			} catch (Throwable e) {
				result /= 2;
			}
		}
		return result;
	}
}