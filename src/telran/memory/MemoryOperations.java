package telran.memory;

public class MemoryOperations {
	public static int getMaxAvaibleMemory() {
		int result = Integer.MAX_VALUE;
		byte[] array = null;
		int left = 0;
		int right = result; //max
		while (left < right) {			
			try {
				array = null; //It's important to clear memory
				array = new byte[result];
				//too small
				left = result + 1;

			} catch (Throwable e) {
				//too big
				right = result - 1;
			}
			result = ((right - left) / 2) + left;
		}
		return result;
	}
}