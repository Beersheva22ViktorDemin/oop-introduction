package telran.recursion;

public class LinearRecursion {
	static public long factorial(int n) {
		long res = 0;
		if (n < 0) {
			res = factorial(-n);
		} else if (n < 2) {
			res = 1;
		} else {
			res = n * factorial(n - 1);
		}
		return res;
	}

	static public int power(int a, int b) {
		// your code cannot use cycles and *, / operators
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int result = 1;

		if (b > 0) {
			result = multiply(a, power(a, b - 1));
		}

		return result;
	}

	public static int multiply(int a, int b) {
		int result = 0;

		if (b < 0) {
			a = -a;
			b = -b;
		}

		if (b > 0) {
			result = a + multiply(a, b - 1);
		}

		return result;
	}

	static public long sum(int ar[]) {

		return sum(0, ar);
	}

	private static long sum(int firstIndex, int[] ar) {
		long res = 0;
		if (firstIndex < ar.length) {
			res = ar[firstIndex] + sum(firstIndex + 1, ar);
		}
		return res;
	}

	public static long square(int x) {
		// no cycles
		// no * , / operators
		// no additional functions
		// no static fields
		// returns x ^ 2

//		x = 0; 0;
//		x = 1; 0 + 1 = 1;
//		x = 2; 1 + 3 = 4;
//		x = 3; 4 + 5 = 9;
//		x = 4; 9 + 7 = 16;
//		x = 5; 16 + 9 = 25;
//		x = 6; 25 + 11 = 36;
		long result = 0;
		if (x < 0) {
			x = -x;
		}
		if (x > 0) {
			result = square(x - 1) + (x - 1) + (x);
		}

		return result;
	}

	public static boolean isSubstring(String string, String substr) {
		// TODO write function
		// returns true if a given 'substr' is indeed the
		// substring of a given`string`
		/*
		 * Challenges: 1. To apply only following methods of the class String: 
		 * charAt(int ind);
		 * String substring( int ind );
		 * int length();
		 * 2. No cycles;
		 */
		return false;
	}

	public static void reverse(int ar[]) {
		// no cycles
		// no static fields
		reverse(0, ar.length - 1, ar);
	}

	private static void reverse(int firstIndex, int lastIndex, int[] ar) {
		if (firstIndex < lastIndex) {
			swap(ar, firstIndex, lastIndex);
			reverse(firstIndex + 1, lastIndex - 1, ar);
		}

	}

	private static void swap(int[] ar, int firstIndex, int lastIndex) {
		int tmp = ar[firstIndex];
		ar[firstIndex] = ar[lastIndex];
		ar[lastIndex] = tmp;

	}
}