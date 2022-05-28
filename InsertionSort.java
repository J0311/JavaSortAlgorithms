// Insertion Sort algorithm. This algorithm assumes first index is sorted. 
// Sorts the remainder of list and inserted elements in proper orders. Great
// for smaller sets of data. Time complexity of O(n^2)

import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		
// Instantiate random obj. from Random class
// Instantiate array with capacity of 10
// Use for loop to fill array with integers 1 - 100
		
		Random rand = new Random();
		int [] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
		}
		
// Printing out our array BEFORE insertion sort:
		
		System.out.println("Before:");
		System.out.println();
		printArray(numbers);
		
		insertionSort(numbers);
		System.out.println();
		
// Printing out our array AFTER insertion sort:
		
		System.out.println("After:");
		System.out.println();
		printArray(numbers);
	}
	
	private static void printArray( int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
		
	private static void insertionSort(int[] inputArray) {
		
// utilize for loop starting with index 1 INSTEAD of 0 because in an 
// insert sort algorithm, index 0 is already assumed to be sorted
		
		for (int i = 1; i < inputArray.length; i++) {
			int currentValue = inputArray[i];
			
// create variable int j to walk backwards towards beginning of array
// initialize j to be one space BEFORE the value that we're currently looking at ([i])
			
			int j = i -1;
			
// The first part of our condition is j >= 0 in order to make us stop walking back 
// once we make it to the beginning of the array
// Second part of condition is to look at value of the spot in array at j while that 
// value is greater than the current value that we're looking at @[i]
			
			while (j >= 0 && inputArray[j] > currentValue) {
				
				inputArray[j + 1] = inputArray[j];
				
// Decrement j in order to walk our way back towards beginning
				
				j--;
		}

// "insertion" portion which sets value of j in array for sorting
			
			inputArray[j + 1] = currentValue;
		
	}
	
	}
}
