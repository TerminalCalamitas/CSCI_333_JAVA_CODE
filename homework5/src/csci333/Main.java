package csci333;
/*
 * Caleb Knapp 11/05 CSCI-333 Homework 5
 * This code implements tests for a chained hash table and a open address hash table
 */

/**
 * 
 */
public class Main {
	/**
	 * 
	 * @param args command-line arguments (not used)
	 * @throws Exception Throws an exception if thrown by the hash tables
	 */
	public static void main(String[] args) throws Exception {
		// Elements to be inserted into the hash tables
		int[] elementsToInsert = { 21, 45, 177, 78, 31, 49, 74, 46, 195, 16, 150, 165, 147, 42, 163, 18, 160, 148, 188,
				122 };

		int[] elementsToSearch = { elementsToInsert[9], elementsToInsert[17], elementsToInsert[4], elementsToInsert[12],
				elementsToInsert[7] }; // Elements that exist in the tables
		int[] elementsNotInTable = { 5, 114, 67, 90, 193 }; // Elements that do not exist in the tables

		System.out.println("=============== Testing ChainedHashTable ===============");

		// Initialize ChainedHashTable with capacity of 20
		ChainedHashTable chainedTable = new ChainedHashTable(20);

		// Step 1: Insert elements
		System.out.println("\n--- Insert 20 elements ---");
		for (int element : elementsToInsert) {
			chainedTable.insert(element);
		}
		System.out.println("Chained Hash Table after initial insertions:\n" + chainedTable);

		// Step 2: Remove a few elements
		System.out.println("\n--- Remove a few elements ---");
		chainedTable.delete(elementsToInsert[19]);
		chainedTable.delete(elementsToInsert[0]);
		chainedTable.delete(elementsToInsert[10]);
		System.out.println("Chained Hash Table after deletions:\n" + chainedTable);

		// Step 3: Search for existing and non-existing elements
		System.out.println("\n--- Search for elements ---");
		System.out.println("Searching for existing elements:");
		for (int element : elementsToSearch) {
			System.out.println("Element " + element + " found: " + (chainedTable.search(element) != null));
		}

		System.out.println("\nSearching for non-existent elements:");
		for (int element : elementsNotInTable) {
			System.out.println("Element " + element + " found: " + (chainedTable.search(element) != null));
		}

		System.out.println("\nFinal state of Chained Hash Table:\n" + chainedTable);

		System.out.println("\n=============== Testing OpenAddressedHashTable ===============");

		// Initialize OpenAddressedHashTable with capacity of 20
		OpenAddressedHashTable openAddressTable = new OpenAddressedHashTable(20);

		// Step 1: Insert elements
		System.out.println("\n--- Insert 20 elements ---");
		for (int element : elementsToInsert) {
			openAddressTable.insert(element);
		}
		System.out.println("Open Addressed Hash Table after initial insertions:\n" + openAddressTable);

		// Step 2: Remove a few elements
		System.out.println("\n--- Remove a few elements ---");
		openAddressTable.delete(elementsToInsert[19]);
		openAddressTable.delete(elementsToInsert[0]);
		openAddressTable.delete(elementsToInsert[10]);
		System.out.println("Open Addressed Hash Table after deletions:\n" + openAddressTable);

		// Step 3: Search for existing and non-existing elements
		System.out.println("\n--- Search for elements ---");
		System.out.println("Searching for existing elements:");
		for (int element : elementsToSearch) {
			System.out.println("Element " + element + " found: " + (openAddressTable.search(element) != null));
		}

		System.out.println("\nSearching for non-existent elements:");
		for (int element : elementsNotInTable) {
			System.out.println("Element " + element + " found: " + (openAddressTable.search(element) != null));
		}

		System.out.println("\nFinal state of Open Addressed Hash Table:\n" + openAddressTable);
	}
}
