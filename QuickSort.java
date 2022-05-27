// Quick Sort algorithm. Selects a pivot, partitions the array, and
// sorts the array around the pivot. Time complexity of O(n log n)

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {

		Random rand = new Random();
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
		}

// Printing version of array BEFORE quick sort

		System.out.println("Before:");
		System.out.println();
		printArray(numbers);

// Using the Quicksort algorithm to sort our elements

		quicksort(numbers, 0, numbers.length - 1);

// Printing version of array AFTER quick sort

		System.out.println("\nAfter:");
		System.out.println();
		printArray(numbers);
	}

// Our Quick Sort method takes in 3 parameters: array input, low index (numbers
// less than pivot) and highIndex(numbers greater than our pivot).

	private static void quicksort(int[] array, int lowIndex, int highIndex) {
	
// If we're dealing with a subarray that has only one element, we already know it's 
// sorted, therefore return it as is.
		
		if (lowIndex >= highIndex) {
			return;
		}

// Because this is a recursive algorithm, we can't always just pick the last element
// of the array that we're sorting as the pivot. 
// At any given recursive step in the middle, we may have to sort just one small sub array
// portion of the entire array. That will be passed into our method recursively with a low 
// index and a high index (indicating the range we want to recursively sort).

		int pivot = array[highIndex];

// We'll create two pointers - one that points to the left most portion of the array, one 
// that points to the right most portion of the array. We'll start at the left and walk
// through array a single element at a time until we find an element LARGER than our pivot.

		int leftPointer = lowIndex;
		int rightPointer = highIndex;

// Create a left & right pointer embedded in a loop that will enable them to move toward each other
// We will accomplish this with a conditional statement that will evaluate to true as long as our 
// left pointer is less than right pointer. Once this is false, we will break out of our loop and 
// partitioning is complete.

		while (leftPointer < rightPointer) {

// inside of our while loop, we want to walk our left pointer from left to right UNTIL we find a number
// higher than our pivot, OR we hit our right pointer. Therefore, we create an inner while loop

			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}

// We will also created a similar nested while loop for our right pointer as well.
// Here we will decrement our right pointer in order to get it to move from right to left

			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
// Once our pointers meet, we break out the while loop and call our swap method
			
			swap(array, leftPointer, rightPointer);
		}
		
// After initial swap, we actually want to pass through our highIndex, because we know
// this highIndex will be the index of our pivot. 
		
		swap(array, leftPointer, highIndex);
	
	
		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);
	}

// swap method which will take in 3 parameters: the array which contains the 2 elements we
// wish to swap, the 2 indexes we wish to swap, and we create a temp variable to hold one of
// the values we wish to swap

	private static void swap(int[] array, int index1, int index2) {

		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
// our method to print elements of array
	
	private static void printArray(int[] numbers) {
	    for (int i = 0; i < numbers.length; i++) {
	      System.out.println(numbers[i]);
	    }
}
}
