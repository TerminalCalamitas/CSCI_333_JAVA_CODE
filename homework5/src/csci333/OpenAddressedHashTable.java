/*
 * Caleb Knapp 11/05 CSCI-333 Homework 5
 * This code implements an open addressed hash table
 */
package csci333;

import java.util.Arrays;

/**
 * The OpenAddressedHashTable Class implements a Chained Hash Table using the
 * multiplication method to hash elements. This implementation works on generic
 * types.
 * 
 * @param <T> Generic type of the elements to allow for multiple variable types
 */
public class OpenAddressedHashTable<T> {
	private T[] hashTable;
	private final double A;
	private static final int DELETED = Integer.MIN_VALUE;

	/**
	 * Constructs a OpenAddressedHashTable instance using a generic type array. The
	 * length of the array of Linked Lists is the number of elements to be inserted.
	 * 
	 * @param numInputs The number of elements that will be inserted into the hash
	 *                  table
	 */
	public OpenAddressedHashTable(int numInputs) {
		A = 0.6180339887;
		hashTable = (T[]) new Object[numInputs];

	}

	/**
	 * Inserts a value into the hash table using open addressing. If the slot is
	 * empty or marked as deleted, the value is inserted.
	 * 
	 * @param value The value to be inserted
	 * @return The index where the value was inserted
	 * @throws Exception if the hash table is full (hash table overflow)
	 */
	public int insert(T value) throws Exception {
		int key = hash(value.hashCode());
		for (int i = 0; i < hashTable.length; i++) {
			int j = hash(key, i);
			if (hashTable[j] == null || hashTable[j].equals((T) Integer.valueOf(DELETED))) { // Empty or deleted slot
				hashTable[j] = value;
				return j;
			}
		}
		throw new Exception("Hash table overflow");
	}

	/**
	 * Deletes a specified key from the hash table by marking its slot as deleted.
	 * 
	 * @param key The key to delete
	 * @return The index where the key was found and deleted
	 * @throws Exception if the key is not found in the hash table
	 */
	public int delete(T key) throws Exception {
		for (int i = 0; i < hashTable.length; i++) {
			int j = hash(key.hashCode(), i);
			if (hashTable[j].equals(key)) {
				hashTable[j] = (T) Integer.valueOf(DELETED);
				return j; // Key found
			}
		}
		throw new Exception("Element not found"); // Key not found after probing

	}

	/**
	 * Searches for a specified key in the hash table using open addressing.
	 * 
	 * @param key The key to search for
	 * @return The key if found, or null if the key is not in the table
	 */
	public T search(T key) {
		for (int i = 0; i < hashTable.length; i++) {
			int j = hash(key.hashCode(), i);
			if (hashTable[j] == null) {
				return null; // Key not found
			}
			if (hashTable[j].equals(key)) {
				return hashTable[j]; // Key found
			}
		}
		return null; // Key not found after probing

	}

	/**
	 * Computes the primary hash of a given key using multiplication method same as
	 * the {@link ChainedHashTable} implementation.
	 * 
	 * @param key The key to hash
	 * @return The hash index
	 */
	private int hash(int key) {
		return (int) (hashTable.length * Math.abs((key * A) % 1));
	}

	/**
	 * Computes the hash with linear probing, incorporating the probe count.
	 * 
	 * @param key The key to hash
	 * @param i   The probe count
	 * @return The hash index
	 */
	private int hash(int key, int i) {
		return (hash(key) + i) % hashTable.length;
	}

	/**
	 * Returns a string representation of the hash table.
	 * 
	 * @return A string representing the contents of the hash table
	 */
	public String toString() {
		return Arrays.toString(hashTable);
	}
}
