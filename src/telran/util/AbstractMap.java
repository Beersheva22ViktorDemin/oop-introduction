package telran.util;



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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<K> keySet() {
		try {
			@SuppressWarnings("unchecked")
			Set<K> res = set.getClass().getConstructor().newInstance();
			//TODO complete code
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
			//TODO complete code
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		} 
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
