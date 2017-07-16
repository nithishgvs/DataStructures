package org.nithish.hashmap;

public class HashMapCustom {

	public static final int TABLE_SIZE = 100;

	public Record[] table = new Record[TABLE_SIZE];

	/**
	 * 
	 * @param hashCode
	 * @param step
	 * @return
	 */
	private int hash(int hashCode, int step) {
		if (step == 0) {
			return hashCode % TABLE_SIZE;
		}
		return (hashCode % TABLE_SIZE + step * step) % TABLE_SIZE;

	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean keyExists(Object key) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (table[slot] != null && !table[slot].getKey().equals(key)) {
			hash(keyCode, ++step);
		}
		if (table[slot] != null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (!isEmpty(slot)) {
			slot = hash(keyCode, ++step);
		}

		Record record = new Record(key, value);
		table[slot] = record;
	}

	public Object get(Object key) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (table[slot] != null && !table[slot].getKey().equals(key)) {
			slot = hash(keyCode, ++step);
		}
		if (table[slot] != null) {
			return table[slot].getValue();
		}
		return null;
	}

	/**
	 * Check if slot is empty in hash_Array
	 * 
	 * @param slot
	 * @return
	 */
	public boolean isEmpty(int slot) {
		if (table[slot] == null) {
			return true;
		}
		return false;
	}

	/**
	 * Record=>Key,Value pair
	 * 
	 * @author nithishgvs
	 *
	 */
	private static class Record {
		Object key;
		Object value;

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public Record(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		HashMapCustom hashMap=new HashMapCustom();
		hashMap.put(1, "Sai");
		hashMap.put(2, "Pavan");
		System.out.println(hashMap.keyExists(1));
		System.out.println(hashMap.keyExists(2));
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(2));

	}

}
