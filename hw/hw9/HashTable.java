// Simple HashTable class.
// Dounglan Cheung

public class HashTable<K, V> {
	//Item class is a simple wrapper for key/value pairs.
	class Item<K, V> { // leave this non-private for testing.
		private K key;
		private V value;
		private boolean tombstone;

		//Create an Item object.
		public Item(K key, V value) {
			this.key = key;
			this.value = value;
			this.tombstone = false;
		}
	}
	public static final int INITIAL_CAPACITY = 16; // must be a power of 2.
	public static final double MAX_LOAD = .5;

	Item<K, V>[] table; // (Leave this non-private for testing.)
	private int size;

	// HashTable constructor.
	@SuppressWarnings("unchecked")
	public HashTable() {
		table = (Item[]) new Item[INITIAL_CAPACITY];
		size = 0;
	}

	//Store the provided key/value pair.
	public void put(K key, V value) {
		int index = findKey(key);
		table[index] = new Item<K, V>(key,value);
		size++;
	}

	//Return the value associated with the provided key, or null if no such value exists.
	public V get(K key) {
		int indx = findKey(key);
		if(indx != -1) {
			return table[indx].value;
		}
		else {
			return null;
		}
	}

	//Remove the provided key from the hash table and return the associated value. Returns null if the key is not stored in the table.
	public V remove(K key) {
		int idx = findKey(key); //creates a new index with a key
		if (idx != -1) { //if it isn't -1, then it will remove the value and shrink the list
			table[idx].tombstone = true;
			size--;
			return table[idx].value;
		}
		else {
			return null;
		}

	}

	//Return the number of items stored in the table.
	public int size() {
		return size;
	}

	// PRIVATE HELPER METHODS BELOW THIS POINT----------

	//Double the size of the hash table and rehash all existing items.
	private void rehash() {
		Item<K, V>[] nhtab = table; //new hashtable
		Item<K, V>[] table = (Item[]) new Item[nhtab.length * 2]; //doubles hashtable size
		size = 0;

		for(int i = 0; i < table.length; i++) { //rehashes all items
			if(nhtab[i] != null) {
				put(nhtab[i].key, nhtab[i].value); //as long as it's not null, puts the key and value back
			}
		}
	}


	/* Find the index of a key or return -1 if it can't be found. If removal is
	 * implemented, this will skip over tombstone positions during the search.
	 */
	private int findKey(K key) {
		int ind = indexFor(key.hashCode(), table.length);

		while((table[ind].key != key) || (table[ind].tombstone))  {
			ind++;
		}

		if(table[ind] != null) {
			return ind;
		}
		else {
			return -1;
		}
	}

	// Returns index for hash code h.
	private int indexFor(int h, int length) {
		return hash(h) & (length - 1);
	}

	/* Applies a supplemental hash function to a given hashCode, which defends
	 * against poor quality hash functions. This is critical because HashMap uses
	 * power-of-two length hash tables, that otherwise encounter collisions for
	 * hashCodes that do not differ in lower bits */
	private int hash(int h) {
		/* This function ensures that hashCodes that differ only by
		 * constant multiples at each bit position have a bounded
		 * number of collisions (approximately 8 at default load factor) */
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
}
// The hash and indexFor methods are taken directly from the Java HashMap