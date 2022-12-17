package telran.memory;

public class MemoryOperations {
	public static int getMaxAvaibleMemory() {
		int result = Integer.MAX_VALUE;
		boolean running = true;
		byte ar[] = null;
		while (running) {
			try {
				ar = new byte[result];
				running = false;

			} catch (Throwable e) {
				result /= 2;

			}
		}
		return result;
	}
}