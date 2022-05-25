// Merge Sort Algorithm, a "divide and conquer" type of algorithm.
// Utilizes recursion and takes an array, cuts it in half, sorts the 
// 2 halves, then merges both sub-arrays back together sorted.

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		
// Random object instantiated along with our numbers array
		
		Random rand = new Random();
		int [] numbers = new int[100];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
		}
		
		System.out.println("Before:");
		System.out.println();
		printArray(numbers);
		
		mergeSort(numbers);
		
		System.out.println("\nAfter:");
		System.out.println();
		printArray(numbers);

	}
	
// Heart of the Merge Sort algorithm. We will call this mergeSort method recursively
	
	private static void mergeSort(int[] inputArray) {
		int inputLength = inputArray.length;
		
// any array with less than 2 elements will naturally already be sorted, therefore we return it
		
		if (inputLength < 2) {
			return;
		}
		
// midIndex variable cuts our array in half. 
// for rightHalf variable, we use [inputLength - midIndex] to account for
// those arrays which may have an ODD number of elements
		
		int midIndex = inputLength / 2;
		int [] leftHalf = new int[midIndex];
		int [] rightHalf = new int[inputLength - midIndex];
		
// for loop places elements in both halves of our arrays (left and right half)
		
		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}
		
// We recursively call our mergeSort method to SORT our 2 sub-arrays	
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
// We call our merge function to merge our completely sorted halves
		
		merge(inputArray, leftHalf, rightHalf);
	}
	
// This method will actually merge our sub-arrays once they have been sorted

	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		
// here we create our looping indexes
		
		int i = 0;
		int j = 0; 
		int k = 0;
		
// comparing the i element of left half with the j element of the right half. 
// Basically, if left half at i is less than or equal to right half at j, then 
// this is the SMALLER of the two numbers. Or they could be equal therefore order
// will not matter
		
		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {
				inputArray[k] = leftHalf[i];
				i++;
			}			
			else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}

// we implement two additional while loops to account for any left over elements 
// in either side of our array
		
		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
	}
	
// our method to print the merged array
	
	private static void printArray( int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}