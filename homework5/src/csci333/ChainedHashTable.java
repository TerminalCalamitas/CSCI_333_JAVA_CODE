package csci333;
/*
 * Caleb Knapp 11/05 CSCI-333 Homework 5
 * This code implements a chained hash table
 */

import java.util.LinkedList;

/**
 * The ChainedHashTable Class implements a Chained Hash Table using the
 * multiplication method to hash elements. This implementation works on generic
 * types.
 * 
 * @param <T> Generic type of the elements to allow for multiple variable types
 */
public class ChainedHashTable<T> {
	private LinkedList<T>[] hashTable;
	private int powerOf2;
	private final double A;

	/**
	 * Constructs a ChainedHashTable instance using an array of linked lists. The
	 * length of the array of Linked Lists is the smallest power of 2 larger than
	 * the number of elements.
	 * 
	 * @param numInputs The number of elements that will be inserted into the hash
	 *                  table
	 */
	public ChainedHashTable(int numInputs) {
		A = 0.6180339887;

		powerOf2 = 1;
		while (powerOf2 <= numInputs) {
			powerOf2 *= 2;
		}

		hashTable = new LinkedList[powerOf2];
		for (int i = 0; i < powerOf2; i++) {
			hashTable[i] = new LinkedList<>(); // initialize each index with an empty LinkedList
		}
	}

	/**
	 * Inserts an element into the hash table based on it's hash value.
	 * 
	 * @param value The generic type element to insert into the hash table.
	 */
	public void insert(T value) {
		int index = hash(value.hashCode());
		hashTable[index].add(value);
	}

	/**
	 * Deletes an element from the hash table based on it's hash value.
	 * 
	 * @param value The generic type element to remove from the hash table.
	 */
	public void delete(T value) {
		int index = hash(value.hashCode());
		hashTable[index].remove(value);
	}

	/**
	 * Uses an element's hash value to find an element in the hash table and returns
	 * an appropriate value.
	 * 
	 * @param value The generic type element to find in the hash table.
	 * @return The found element's handle or null if the element isn't in the hash
	 *         table.
	 */
	public T search(T value) {
		int index = hash(value.hashCode());
		for (T entry : hashTable[index]) {
			if (entry.equals(value)) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * Generates a hash value of an input key using the multiplication method.
	 * 
	 * @param key integer representation of an element
	 * @return returns the hash of the input using the multiplication method.
	 */
	private int hash(int key) {
		return (int) (powerOf2 * Math.abs((key * A) % 1));
	}

	/**
	 * Returns a string by concatenating all the linked lists in the hash table
	 * 
	 * @return a string of the concatenated LinkedLists
	 */
	public String toString() {
		String stringValue = hashTable[0].toString();
		for (int i = 1; i < powerOf2; i++) {
			stringValue += ", " + hashTable[i].toString();
		}
		return stringValue;
	}
}
