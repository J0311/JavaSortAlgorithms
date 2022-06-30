// Counting Sort algorithm. Specifically works for integers with a known range
// Complexity of O(n + k)

import java.util.*;

public class CountSort {

	public static void main(String[] args) {

		int[] arr = { 90, 80, 30, 60, 50, 40, 70, 80, 40, 30, 60, 50, 70 };
		
		System.out.println("Counting sort in Java\ninteger array before sorting");
		System.out.println();
		printArray(arr);

// Using the Counting sort algorithm to sort our elements
		System.out.println();
		sort(arr);

// Printing version of array AFTER quick sort

		System.out.println("integer array after sorting using counting sort algorithm");
		System.out.println();
		printArray(arr);

	}

// For our sort method, we utilize the min and max values using the Array stream api functions
// With min & max calculated, we can initiate our algorithm

	public static void sort(int[] arr) {
		int min = Arrays.stream(arr).min().orElse(0);
		int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

// the number of elements this array should hold is max - min + 1 

		int[] countArray = new int[max - min + 1];

// Next we want to iterate over the array we wish to sort, subtracting the minimum from it.
// for each value stored, we must subtract minimum from it. The value stored/referenced has 
// to be incremented for each element we calculate. 

		for (int value : arr) {
			countArray[value - min]++;
		}

// after counting numbers of occurrences, we must loop over the newly created array storing these
// occurrences using zero

		int arrayIndex = 0;
		for (int i = 0; i < max - min + 1; i++) {

// while number of occurrences are greater than 0, we have to store the index referencing the
// spot inside the initial array in final sorted position.

			while (countArray[i] > 0) {
				arr[arrayIndex] = i + min;
				countArray[i]--;
				arrayIndex++;

			}
		}
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
