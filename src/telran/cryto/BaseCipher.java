package telran.cryto;

public class BaseCipher {
	public static final Integer MIN_LENGTH = 2;
	public static final Integer MAX_LENGTH = 93;
	private static final char MIN_CHAR = 33;
	private static final char MAX_CHAR = 126;
	private String key;
	private char[] buffer = new char[MAX_CHAR + 1];

	public BaseCipher(Integer length) {
		key = generateKey(length);
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String cipher(Integer number) {
		int base = key.length();
		int[] digits = Numbers.getDigits(number, base);
		char[] result = new char[digits.length];
		for (int i = 0; i < digits.length; i++) {
			result[i] = getCharFromKey(digits[i]);
		}
		return new String(result);
	}

	public Integer decipher(String cipher) {
		int length = cipher.length();
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = getDigitFromKey(cipher.charAt(i));
		}
		
		return Numbers.getNumberFromDigits(result, key.length());
	}
	
	private String generateKey(Integer length) {
		if (length < MIN_LENGTH) {
			length = MIN_LENGTH;
		}
		
		if (length > MAX_LENGTH) {
			length = MAX_LENGTH;
		}
		
		char[] result = new char[length];
		
		for (int i = 0; i < length; i++) {
			result[i] = generateUniqueNumber(MIN_CHAR, MAX_CHAR);
		}
		
		return new String(result);
	}

	private char generateUniqueNumber(char minChar, char maxChar) {
		char result;
		do {
			result = getRandomChar(minChar, maxChar);
		} while (buffer[result] > 0);
		buffer[result] = 1;
		return result;
	}
	
	private static char getRandomChar(char min, char max) {
		return (char) Numbers.getRandomNumber(min, max);
	}
	
	private char getCharFromKey(int i) {
		return key.charAt(i);
	}

	private int getDigitFromKey(char charAt) {
		int length = key.length();
		for (int i = 0; i < length; i++) {
			if (key.charAt(i) == charAt) {
				return i;
			}
		}

		throw new RuntimeException(String.format("Invalid char '%s'", "world", charAt));
	}

}
