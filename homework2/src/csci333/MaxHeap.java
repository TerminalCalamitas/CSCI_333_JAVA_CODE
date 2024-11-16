package csci333;

import java.util.Arrays;

/*
 * Caleb Knapp 9/08/2024
 * CSCI-333 Homework 2
 * Implementation of a max heap
 */
public class MaxHeap<T extends Comparable<T>> {
	private T[] array;
	private int heapsize;
	
	// Copies the array into a max heap and
	public MaxHeap (T[] array) {
		this.array = Arrays.copyOfRange(array, 0, array.length);
		heapsize = array.length;
		buildMaxHeap();
	}
	
	private int leftChildOf (int index) {
		// Left child = index * 2 + 1
		int parentIndex = index - 1 / 2;
		if (parentIndex >= 0) {
			return parentIndex;
		// If parent is less than 0 it doesn't exist
		} else {
			return -1;
		}
	}
	
	private int rightChildOf (int index) {
		// Left child = index * 2 + 2
		int parentIndex = index - 2 / 2;
		if (parentIndex >= 0) {
			return parentIndex;

		// If parent is less than 0 it doesn't exist
		} else {
			return -1;
		}
	}
	
	public void printMaxHeap () {
		//printing heapsize
		System.out.println("heapsize: " + heapsize);
		// printing the heap as an array
		System.out.print("[" + array[0]);
		for (int i = 1; i < heapsize; i++) {
			System.out.print(", " + array[i]);
		}
		System.out.print("]\n");
	}
	
	private void maxHeapify (int index) {
		int leftChild = index * 2 + 1;
		int rightChild = index * 2 + 2;
		 //Set largest to the starting index
		int largest = index;
		// If left is larger update largest
		if (leftChild < heapsize && array[leftChild].compareTo(array[largest]) > 0) {
			largest = leftChild;
		}
		// If right is bigger update largest
		if (rightChild < heapsize && array[rightChild].compareTo(array[largest]) > 0) {
			largest = rightChild;
		}
		
		// If the original item isn't the biggest swap them and calling heapify on the new index
		if (largest != index) {
			swap(index, largest);
			maxHeapify(largest);
		}
	}
	
	private void buildMaxHeap () {
		// Start from middle of heap going to the beginning and running heapify
		for (int i = heapsize / 2; i > 0; i--) {
			maxHeapify(i);
		}
	}
	
	public void heapsort() {
		//running maxheap to make sure heap is valid
		buildMaxHeap();
		int heapsize_backup = heapsize;
		
		// Brings every element to top of heap and heapifies it into the correct place.
		for (int i = heapsize - 1; i > 0; i--) {
			swap(0, i);
			heapsize--;
			maxHeapify(0);
		}
		
		//restoring the heapsize variable
		heapsize = heapsize_backup;
		
	}

	// Simple array index swap function
	private void swap(int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
