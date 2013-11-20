package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	
	private int size = 0;
	private final double loadFactor;
	
	private final Entry<K,V>[] table;
	private final int capacity;
	
	/**
	 * Constructs an empty hashmap with the default initial capacity (16) and the default load factor (0.75)
	 */
	public SimpleHashMap() {
		this(16);
	}
	
	/**
	 * Constructs an empty hashmap with the specified capacity and the default load factor (0.75)
	 * @param capacity
	 */
	public SimpleHashMap(int capacity) {
		this(capacity, 0.75);
	}
	
	/**
	 * Constructs an empty hashmap.
	 * @param capacity
	 * @param loadFactor
	 */
	public SimpleHashMap(int capacity, double loadFactor) {
		table = (Entry<K,V>[]) new Entry[capacity];
		this.loadFactor = loadFactor;
		this.capacity = capacity;
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < table.length; i++) {
			sb.append(i + "\t" + show(table[i]) + "\n");
		}
		
		return sb.toString();
	}
	
	private String show(Entry<K,V> e) {
		if(e == null) {
			return "";
		}
		
		return e.toString() + " " + show(e.next);
	}
	
	@Override
	public V get(Object o) {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public V put(K key, V value) {
		return null;
	}

	@Override
	public V remove(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	private int index(K key) {
		return key.hashCode() % capacity;
	}
		
	private Entry<K,V> find(int index, K key) {
		return find(table[index], key);
	}
	
	private Entry<K,V> find(Entry<K,V> e, K k) {
		if(e == null) {
			return null;
		}
		
		return e.getKey().equals(k) ? e : find(e.next, k);
	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
   
		private K key;
		private V value;
		private Entry<K,V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldVal = this.getValue();
			this.value = value;
			return oldVal;
		}
		
		public String toString() {
			return this.key + "=" + this.value;
		}
	}
	
}