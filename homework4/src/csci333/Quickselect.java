package csci333;

import java.util.Arrays;
import java.util.Random;

/**
 * The Quickselect class provides a randomized implementation of the Quickselect
 * algorithm to find the i-th smallest element in an array. This implementation
 * works on generic types that are comparable.
 *
 * @param <T> the type of elements in the array, which must implement the
 *            Comparable interface
 */
public class Quickselect<T extends Comparable<T>> {
	private T[] array;

	/**
	 * Constructs a Quickselect instance with the specified array.
	 *
	 * @param array the array to perform Quickselect operations on
	 */
	public Quickselect(T[] array) {
		this.array = array;
	}

	/**
	 * Finds the i-th smallest element in the array using the randomized Quickselect
	 * algorithm. The input array is copied to avoid modifying the original array.
	 *
	 * @param i the 1-based index of the desired smallest element
	 * @return the i-th smallest element in the array
	 */
	public T randomizedQuickSelect(int i) {
		T[] arrayCopy = Arrays.copyOf(array, array.length);
		return randomizedQuickselect(arrayCopy, 0, array.length - 1, i);
	}

	/**
	 * Recursively selects the i-th smallest element in a subarray by partitioning
	 * around a random pivot element.
	 *
	 * @param array      the array to perform Quickselect on
	 * @param lowerBound the lower bound of the current subarray
	 * @param upperBound the upper bound of the current subarray
	 * @param i          the 1-based index of the desired smallest element
	 * @return the i-th smallest element in the subarray
	 */
	private T randomizedQuickselect(T[] array, int lowerBound, int upperBound, int i) {
		Random rand = new Random();
		// Base case is a 1 length sub array
		if (upperBound == lowerBound) {
			return array[lowerBound];
		}

		// Random pivot is chosen
		int pivot = rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
		swap(pivot, upperBound);

		// Partition to find new pivot
		int newPivot = partition(lowerBound, upperBound);
		// Calculate local order statistic of pivot
		int orderStat = newPivot - lowerBound + 1;

		// If equal we're done
		if (i == orderStat) {
			return array[newPivot];
		} else if (i < orderStat) { // If lower check before the pivot
			return randomizedQuickselect(array, lowerBound, newPivot - 1, i);
		} else { // If lower check after the pivot
			return randomizedQuickselect(array, newPivot + 1, upperBound, i);
		}

	}

	/**
	 * Partitions the array into two subarrays around a pivot element. The left
	 * subarray is all the elements less than the pivot and the right subarray is
	 * all elements greater than the pivot.
	 *
	 * @param start The starting index of the subarray to partition.
	 * @param end   The ending index of the subarray to partition.
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
	 * Swaps the elements at the given indices in the array.
	 *
	 * @param first  The index of the first element to swap.
	 * @param second The index of the second element to swap.
	 */
	private void swap(int first, int second) {
		T temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
