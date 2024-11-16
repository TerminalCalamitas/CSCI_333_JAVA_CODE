package csci333;

import java.util.Arrays;
import java.util.Random;

/**
 * Implements various quicksort algorithms for arrays of comparable elements.
 *
 * @param <T> The type of elements in the array, which must implement the `Comparable` interface.
 */
public class Quicksort<T extends Comparable<T>> {
	private T[] array;

	/**
     * Constructs a new Quicksort object for sorting the given array.
     *
     * @param array The array to be sorted.
     */
	public Quicksort(T[] array) {
		this.array = array;
	}

	/**
     * Partitions the array into two subarrays around a pivot element. The left subarray is all the elements less than the pivot and the right subarray is all elements greater than the pivot.
     *
     * @param start The starting index of the subarray to partition.
     * @param end The ending index of the subarray to partition.
     * @return The index of the pivot element in the partitioned array.
     */
	private int partition(int start, int end) {
		T pivot_value = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot_value) <= 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, end);
		return i + 1;
	}

	/**
     * Sorts the array using the naive quicksort algorithm.
     *
     * @param start The starting index of the subarray to sort.
     * @param end The ending index of the subarray to sort.
     */
	private void quicksortNaive(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);
			quicksortNaive(start, pivot - 1);
			quicksortNaive(pivot + 1, end);
		}
	}

	 /**
     * Sorts sorting the array using the naive quicksort algorithm.
     */
	public void quicksortNaive() {
		quicksortNaive(0, array.length - 1);
	}

	/**
     * Sorts the array using a quicksort algorithm that chooses the median of the starting, middle, and ending indexes as the pivot.
     *
     * @param start The starting index of the subarray to sort.
     * @param end The ending index of the subarray to sort.
     */
	private void quicksortBestOfThree(int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int pivot = 0;
			// PIVOT SHOULD BE MEDIAN
			if (array[start].compareTo(array[middle]) <= 0) {
				if (array[middle].compareTo(array[end]) <= 0) {
					pivot = middle; // Start <= middle <= end
				} else {
					pivot = end; // Start <= end <= middle
				}
			} else {
				if (array[start].compareTo(array[end]) <= 0) {
					pivot = start; // middle <= start <= end
				} else {
					pivot = middle; // end <= middle <= start
				}
			}

			// move pivot to end
			swap(pivot, end);
			// perform quicksort on the array
			pivot = partition(start, end);
			quicksortBestOfThree(start, pivot - 1);
			quicksortBestOfThree(pivot + 1, end);
		}
	}

	/**
     * Sorts the array using a quicksort algorithm that chooses the median of the starting, middle, and ending indexes as the pivot.
     */
	public void quicksortBestOfThree() {
		quicksortBestOfThree(0, array.length - 1);

	}

	 /**
     * Sorts the array using a quicksort algorithm with a randomly chosen pivot.
     *
     * @param start The starting index of the subarray to sort.
     * @param end The ending index of the subarray to sort.
     */
	private void quicksortRandomized(int start, int end) {
		Random rand = new Random();
		if (start < end) {
			int pivot = rand.nextInt((end - start) + 1) + start; // generates number between start and end
			swap(pivot, end);
			pivot = partition(start, end);
			quicksortRandomized(start, pivot - 1);
			quicksortRandomized(pivot + 1, end);
		}
	}

	/**
	 * Sorts the array using a quicksort algorithm with a randomly chosen pivot.
	 */
	public void quicksortRandomized() {
		quicksortRandomized(0, array.length - 1);

	}

	 /**
     * Swaps the elements at the given indices in the array.
     *
     * @param first The index of the first element to swap.
     * @param second The index of the second element to swap.
     */
	private void swap(int first, int second) {
		T temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	/**
     * Returns a string representation of the array.
     *
     * @return A string representation of the array.
     */
	public String toString() {
		return Arrays.toString(array);

	}
}
