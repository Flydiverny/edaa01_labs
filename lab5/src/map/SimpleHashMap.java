package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	
	private int size = 0;
	private final double loadFactor;
	
	private Entry<K,V>[] table;
	private int capacity;
	
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

	/**
	 * Builds a string containing all the key value pairs.
	 * @return
	 */
	public String show() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < table.length; i++) {
			sb.append(i + "\t" + show(table[i]) + "\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Iterates thru a list of Entries returning a string containing their key value pairs.
	 * @param e - Entry to start iterating from
	 * @return string
	 */
	private String show(Entry<K,V> e) {
		if(e == null) {
			return "";
		}
		
		return e.toString() + " " + show(e.next);
	}
	
	@Override
	/**
	 * Gets the value assigned to the specified key
	 * @param o - key
	 * @return V Value
	 */
	public V get(Object o) {
		K k = (K)o;
		
		if(k == null) {
			return null;
		}
		
		int idx = index(k);
		
		return get(table[idx], k);
	}
	
	/**
	 * Iterates thru Entries trying to find a match to the specified key.
	 * @param e - entry to start iterating from
	 * @param key - key to match
	 * @return
	 */
	private V get(Entry<K,V> e, K key) {
		if(e == null) {
			return null;
		}
		
		if(e.getKey().equals(key)) {
			return e.getValue();
		}
		
		return get(e.next, key);
	}

	@Override
	/**
	 * Checks if size() == 0
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	/**
	 * Adds an entry to the hashmap with the specified key value pair.
	 * Will return the old value if an entry with the same key already existed.
	 * @param key
	 * @param value
	 * @return oldValue, null if no entry before
	 */
	public V put(K key, V value) {
		int index = index(key);

		rehash();
		
		if(table[index] == null) {
			table[index] = new Entry<K,V>(key, value);
			size++;
			
			return null;
		}
		
		return put(table[index], key, value);
	}
	
	/**
	 * Iterates thru Entries starting at specified Entry, checking if theres an entry matching the key.
	 * If match exists it will replace the value at the entry.
	 * @param e
	 * @param key
	 * @param value
	 * @return
	 */
	private V put(Entry<K,V> e, K key, V value) {
		if(e.getKey().equals(key)) {
			return e.setValue(value);
		}
		
		if(e.next == null) {
			e.next = new Entry<K,V>(key, value);
			size++;
			return null;
		}
		
		return put(e.next, key, value);
	}
	
	/**
	 * Rehashes the HashMap by doubling the capacity and recreating all entries.
	 */
	private void rehash() {
		if((double)size < ((double)capacity * loadFactor)) {
			return;
		}
		
		size = 0;
		capacity = capacity * 2;
		
		Entry<K,V>[] oldTable = table;
		table = (Entry<K,V>[]) new Entry[capacity];
		
		for(int i = 0; i < oldTable.length; i++) {
			rehashPut(oldTable[i]);
		}
	}
	
	private void rehashPut(Entry<K,V> e) {
		if(e == null) {
			return;
		}
		
		put(e.key, e.value);
		
		rehashPut(e.next);
	}

	@Override
	public V remove(Object o) {
		K k = (K)o;
		
		if(k == null)
			return null;
		
		int idx = index(k);
		
		if(table[idx] == null) {
			return null;
		}
		
		if(table[idx].getKey().equals(k)) {
			Entry<K,V> e = table[idx];
			table[idx] = e.next;
			size--;
			return e.getValue();
		}
		
		return remove(table[idx], k);
	}

	private V remove(Entry<K,V> e, K k) {
		if(e.next == null) {
			return null;
		}
		
		if(e.next.getKey().equals(k)) {
			Entry<K,V> elemToRemove = e.next;
			e.next = elemToRemove.next;
			size--;
			return elemToRemove.getValue();
		}
		
		return remove(e.next, k);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % capacity);
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
