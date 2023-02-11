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
	public V get(K key) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
		}
		return res;
	}

	@Override
	public boolean containsKey(K key) {
		return set.contains(new Entry<>(key, null));
	}

	@Override
	public boolean containsValue(V value) {
		return set.stream().anyMatch(n -> isEqual(n.getValue(), value));
	}

	@Override
	public Collection<V> values() {
		List<V> res = new ArrayList<>();
		set.forEach(e -> res.add(e.getValue()));
		return res;
	}

	@Override
	public Set<K> keySet() {
		try {
			@SuppressWarnings("unchecked")
			Set<K> res = set.getClass().getConstructor().newInstance();
			set.forEach(e -> res.add(e.getKey()));
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
			set.forEach(res::add);
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		} 
	}

	@Override
	public V remove(K key) {
		V res = get(key);
		if (res != null) {
			set.remove(new Entry<>(key, null));
		}
		return res;
	}
	
	private boolean isEqual(V element, V pattern) {

		return element == null ? element == pattern : element.equals(pattern);
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		set.forEach(element -> {
			result.append(element.toString());
			result.append(" ");
		});	
		result.append("]");
		return result.toString();
	}

}
