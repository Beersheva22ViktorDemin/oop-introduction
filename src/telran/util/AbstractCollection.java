package telran.util;

import java.util.Iterator;

public abstract class AbstractCollection<T> implements Collection<T> {
	protected int size;

	protected boolean isEqual(T element, T pattern) {

		return element == null ? element == pattern : element.equals(pattern);
	}

	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		stream().forEach(element -> {
			result.append(element.toString());
			result.append(" ");
		});	
		result.append("]");
		return result.toString();
	}

}
