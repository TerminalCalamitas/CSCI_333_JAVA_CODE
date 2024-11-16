package csci333;

import java.util.Arrays;

/**
 * The Main class contains the entry point for the application and a static
 * implementation of the Counting Sort and quick select algorithms.
 */
public class Main {

	/**
	 * The main method demonstrates sorting an array of integers using Counting Sort
	 * and Quickselect.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		// Array 1
		int[] numbers = {56, 13, 85, 47, 91, 32, 68, 4, 19, 72, 29, 95, 43, 88, 6, 34, 77, 23, 50, 11};

		// Array 2
		int[] numbers2 = {27, 73, 8, 59, 41, 90, 16, 66, 2, 53, 79, 35, 6, 97, 24, 61, 46, 85, 12, 38};

		// Array 3
		int[] numbers3 = {48, 5, 92, 33, 17, 60, 81, 3, 69, 25, 58, 87, 10, 42, 80, 22, 35, 64, 99, 30};

		// Array 1
		System.out.println("Array 1 Before sort: " + Arrays.toString(numbers));
		numbers = countingSort(numbers);
		System.out.println("Array 1 After sort: " + Arrays.toString(numbers) + "\n");
		

		// Array 2
		System.out.println("Array 2 Before sort: " + Arrays.toString(numbers2));
		numbers2 = countingSort(numbers2);
		System.out.println("Array 2 After sort: " + Arrays.toString(numbers2) + "\n");

		// Array 3
		System.out.println("Array 3 Before sort: " + Arrays.toString(numbers3));
		numbers3 = countingSort(numbers3);
		System.out.println("Array 3 After sort: " + Arrays.toString(numbers3) + "\n");
		
		// Sorted array of comparable ints
		Integer[] selectArray = {1, 9, 12, 14, 20, 26, 31, 37, 40, 45, 55, 63, 67, 74, 78, 82, 84, 89, 93, 98};
		Quickselect select = new Quickselect(selectArray);
		
		System.out.println("Quickselect array: " + Arrays.toString(selectArray));
		System.out.println("Smallest element: " + select.randomizedQuickSelect(1));
		System.out.println("Largest element: " + select.randomizedQuickSelect(selectArray.length));
		System.out.println("3rd smallest element: " + select.randomizedQuickSelect(3));
		System.out.println("10th smallest element: " + select.randomizedQuickSelect(10));

	}

	/**
	 * Sorts the specified array of integers in ascending order using the Counting
	 * Sort algorithm.
	 *
	 * @param array the array of integers to be sorted
	 * @return a new array containing the elements of the input array, sorted in
	 *         ascending order
	 */
	public static int[] countingSort(int[] array) {
		int[] sortedArray = new int[array.length];
		int largestValue = array[0];

		// Find largest element
		for (int i = 1; i < array.length; i++) {
			if (array[i] > largestValue) {
				largestValue = array[i];
			}
		}

		countingSort(array, sortedArray, largestValue);
		return sortedArray;

	}

	/**
	 * Internal helper method that performs the Counting Sort algorithm on the
	 * specified arrays. This method populates the sorted values in the output array
	 * B based on the input array A.
	 *
	 * @param A the input array containing the elements to be sorted
	 * @param B the output array where sorted elements will be stored
	 * @param k the maximum value in the array A, used to determine the size of the
	 *          count array
	 */
	private static void countingSort(int[] A, int[] B, int k) {
		// Declare array C to hold numbers of maximum size k
		int[] C = new int[k + 1];

		// Count occurrences of each element in A
		for (int i = 0; i < A.length; i++) {
			C[A[i]]++;
		}

		// Make C hold Cumulative counts
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}

		// Place values from A into B using C
		for (int i = A.length - 1; i >= 0; i--) {
			B[C[A[i]] - 1] = A[i];
			C[A[i]]--;
		}
	}
}
