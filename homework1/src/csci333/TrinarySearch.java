package csci333;

import java.util.Arrays;
import java.util.Random;

/**
 * Caleb Knapp 08-28 CSCI-333 Homework 1
 * This is a simple trinary search implementation
 */

public class TrinarySearch {

	public static void main(String[] args) {
		Random random = new Random();

        for (int i = 0; i < 5; i++) {
            // Generate random array size between 10 and 30
            int arraySize = random.nextInt(21) + 10;

            // Create a random sorted array
            int[] searchArray = new int[arraySize];
            searchArray[0] = random.nextInt(100);
            for (int j = 1; j < arraySize; j++) {
                searchArray[j] = searchArray[j - 1] + random.nextInt(10) + 1;
            }

            // Generate a random search term within the array's range
            int searchTerm = random.nextInt(searchArray[searchArray.length - 1]);

            // Run the trinary search and print the result
            int returned = trinarySearch(searchTerm, searchArray, 0, searchArray.length - 1);
        	System.out.println("Searching for " + searchTerm + " in " + Arrays.toString(searchArray));
        	
            if (returned < 0) {
                System.out.println("Search term " + searchTerm + " not found in array.");
            } else {
                System.out.println("Found " + searchTerm + " at index " + returned + " searchArray[" + returned + "] = " + searchArray[returned]);
            }
        }
	}
	
	/**
	 * A method for searching an array by splitting it into three segments and recursing on the third of best fit
	 * @param target The number to look for
	 * @param array The array to look through
	 * @param start The index to start looking from
	 * @param end The index to stop looking at
	 * @return An integer index representing the target integer's location. -1 means it was not found.
	 */
	public static int trinarySearch(int target, int[] array, int start, int end) {
		// Calculating the length of the array to search
		int length = (end - start) + 1;
		// If array is less than 3 indexes long, check the beginning and end indexes (could be the same)
		if (length < 3) {
			if (array[start] == target) {
				return start;
			}
			if ( end != -1 && array[end] == target) {
				return end;
			}
			return -1;
		}
		
		// calculating length of a third of the array
		int third = length / 3;
		// Calculating the first index
		int index1 = start + third - 1;
		// Calculating the second index
		int index2 = index1 + third;
		// setting default return index.
		int rtrnindex = -1;
		
		// If the target is less than the first index it's in the first third
		if (target < array[index1]) {
			rtrnindex = trinarySearch(target, array, start, index1 - 1);
		// If less than the second index it's in the second third
		} else if (target < array[index2]) {
			rtrnindex = trinarySearch(target, array, index1, index2 - 1);
		// If it's not in the first or second third, it's in the last third
		} else {
			rtrnindex = trinarySearch(target, array, index2, end);
		}
		
		// Returns index of found item or -1 if not found
		return rtrnindex;
	}

}
