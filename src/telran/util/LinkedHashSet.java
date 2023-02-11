package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedHashSet<T> extends HashSet<T> implements Set<T> {
	private HashMap<Integer, T> map;
	private HashMap<T, Integer> map2;
	Integer lastIndex = 0;
	
	public LinkedHashSet() {
		super();
		map = new HashMap<Integer, T>();
		map2 = new HashMap<T, Integer>();
	}
	
	private class LinkedHashSetIterator implements Iterator<T> {
		int current = 0;
		T currentElement = null;
		boolean flNext = false;
		int oldSIze = getOldIndex();
		@Override
		public boolean hasNext() {
			return current < oldSIze;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			while (current < oldSIze && !map.containsKey(current)) {
				current++;
			}
			currentElement = map.get(current);
			current++;
			while (current < oldSIze && !map.containsKey(current)) {
				current++;
			}
			flNext = true;
			return currentElement;
		}

		@Override
		public void remove() {
			if (!flNext) {
				throw new IllegalStateException();
			}
			LinkedHashSet.this.remove(currentElement);
			flNext = false;
		}
		
		private int getOldIndex() {
			return lastIndex;
		}
	}

	@Override
	public boolean add(T element) {
		map.put(lastIndex, element);
		map2.put(element, lastIndex);
		lastIndex++;
		return super.add(element);
	}

	@Override
	public boolean remove(T pattern) {
		Integer index = map2.get(pattern);
		map.remove(index);
		map2.remove(pattern);
		return super.remove(pattern);
	}

	@Override
	public boolean contains(T pattern) {
		return super.contains(pattern);
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedHashSetIterator();
	}

	@Override
	public T get(T pattern) {
		return super.get(pattern);
	}

}