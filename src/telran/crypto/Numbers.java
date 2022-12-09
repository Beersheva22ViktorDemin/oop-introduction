package telran.crypto;

public class Numbers {
	public static int countDigits(long number, int base) {
		int res = 0;
		do {
			number /= base;
			res++;
		} while (number != 0);
		return res;
	}
	
	public static int[] getDigits(int number, int base) {
		int res[] = new int[countDigits(number, base)];
		for(int i = res.length - 1; i >= 0; i--) {
			res[i] = number % base;
			number /= base;
		}
		return res;
	}
	
	public static int getNumberFromDigits(int[] digits, int base) {
		int res = 0;
		for(int i = 0; i < digits.length; i++) {
			res = res * base + digits[i];
		}
		return res;
	}
	
	public static long getRandomNumber(long min, long max) {
		return (long) (min + Math.random() * (max - min + 1));
	}
}