package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (isEven(o1) && isEven(o2)) {
			return Integer.compare(o1, o2);
		} else if (!isEven(o1) && !isEven(o2)) {
			return -Integer.compare(o1, o2);
		} else if (isEven(o1) && !isEven(o2)) {
			return -1;
		} else if (!isEven(o1) && isEven(o2)) {
			return 1;
		}
		
		throw new RuntimeException();
	}
	
	private boolean isEven(Integer number) {
		return number % 2 == 0;
	}

}
