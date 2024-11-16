package csci333;
import java.util.Arrays;

import csci333.MaxHeap;

/*
 * Caleb Knapp 9/08/2024
 * CSCI-333 Homework 2
 * Implementation of a max heap
 */
public class Main {

	public static void main(String[] args) {
		String[] array1 = {"i", "d", "f", "b", "h"};
		String[] array2 = {"c", "j", "e", "g", "a"};
		String[] array3 = {"k", "i", "d", "f", "c", "h"};
		String[] array4 = {"j", "e", "g", "a", "b", "i"};
		String[] array5 = {"f", "c", "h", "k", "i", "d", "j", "e"};
		MaxHeap heap1 = new MaxHeap(array1);
		System.out.println("Original array: " + Arrays.toString(array1));
		System.out.println("Original heap: ");
		heap1.printMaxHeap();
		heap1.heapsort();
		System.out.println("Sorted heap: ");
		heap1.printMaxHeap();
		System.out.println("-----------------------------------------");
		
		MaxHeap heap2 = new MaxHeap(array2);
		System.out.println("Original array: " + Arrays.toString(array2));
		System.out.println("Original heap: ");
		heap2.printMaxHeap();
		heap2.heapsort();
		System.out.println("Sorted heap: ");
		heap2.printMaxHeap();
		System.out.println("-----------------------------------------");
		
		MaxHeap heap3 = new MaxHeap(array3);
		System.out.println("Original array: " + Arrays.toString(array3));
		System.out.println("Original heap: ");
		heap3.printMaxHeap();
		heap3.heapsort();
		System.out.println("Sorted heap: ");
		heap3.printMaxHeap();
		System.out.println("-----------------------------------------");
		
		MaxHeap heap4 = new MaxHeap(array4);
		System.out.println("Original array: " + Arrays.toString(array4));
		System.out.println("Original heap: ");
		heap4.printMaxHeap();
		heap4.heapsort();
		System.out.println("Sorted heap: ");
		heap4.printMaxHeap();
		System.out.println("-----------------------------------------");
		
		MaxHeap heap5 = new MaxHeap(array5);
		System.out.println("Original array: " + Arrays.toString(array5));
		System.out.println("Original heap: ");
		heap5.printMaxHeap();
		heap5.heapsort();
		System.out.println("Sorted heap: ");
		heap5.printMaxHeap();
		System.out.println("-----------------------------------------");
		
	}
}
