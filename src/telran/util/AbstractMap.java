package telran.util;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    protected Set<Entry<K, V>> set;
    @Override
	public V put(K key, V value) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
			entry.setValue(value);
		} else {
			set.add(new Entry<>(key, value));
		}
		return res;
	}

	@Override
	public V putIfAbsent(K key, V value) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
		} else {
			set.add(new Entry<>(key, value));
		}
		return res;
	}

	@Override
	public V get(K key) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
		}
		return res;
	}

	@Override
	public V getOrDefault(K key, V value) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
		} else {
			res = value;
		}
		return res;
	}

	@Override
	public boolean containsKey(K key) {
		boolean res = false;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean containsValue(V value) {
		return set.stream().anyMatch(n -> isEqual(n.getValue(), value));
	}

	@Override
	public Collection<V> values() {
		try {
			@SuppressWarnings("unchecked")
			Collection<V> res = new ArrayList<V>();
			for (Entry<K, V> entry: set) {
				res.add(entry.getValue());
			}
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public Set<K> keySet() {
		try {
			@SuppressWarnings("unchecked")
			Set<K> res = set.getClass().getConstructor().newInstance();
			for (Entry<K, V> entry: set) {
				res.add(entry.getKey());
			}
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		} 

	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		try {
			@SuppressWarnings("unchecked")
			Set<Entry<K, V>> res = set.getClass().getConstructor().newInstance();
			for (Entry<K, V> entry: set) {
				res.add(entry);
			}
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		} 
	}

	@Override
	public V remove(K key) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
			set.remove(entry);
		}
		return res;
	}
	
	private boolean isEqual(V element, V pattern) {

		return element == null ? element == pattern : element.equals(pattern);
	}

}
