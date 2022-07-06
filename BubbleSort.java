// Bubble Sort Algorithm. Also referred to as "Sinking Sort". Bubble Sort repeatedly 
// iterates through a list, compares adjacent elements, and SWAPS  them if they're in 
// the wrong order. At the end of each iteration, the heaviest element gets "bubbled" 
// to claim it's rightful position
// space complexity of O(n). Horrible for larger data sets, ideal for small amounts of data

import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {

// Random object initialized, along with int array with a capacity of 10 elements
// For loop created which will select integers between 0 and 1.

		Random rand = new Random();
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(1000000);
		}

// Once loop is executed, we print the "before" sequence of numbers:

		System.out.println("Before:");
		System.out.println();
		printArray(numbers);

// BUBBLE SORT ALGORITHM: 

// to avoid an infinite while loop, we ensure we set our boolean variable swappedSomething
// to false. This way, if program does not have to swap anything, it automatically knows 
// our list is sorted. Otherwise, our for loop will run.

		boolean swappedSomething = true;
		while (swappedSomething) {
			swappedSomething = false;

// In for loop, we incorporate i < numbers.length - 1 because when we're 
// looking at the second to last element, we'll be comparing it with the one
// after it(which will be the last element) so there's no reason to look at
// the last element by itself since there's nothing after it to compare it with.

			for (int i = 0; i < numbers.length - 1; i++) {

// if statement simply determining if index is greater than next index, swap them.
// In the even that the next index is greater, we implement a temp variable to hold
// our current index in, then reassign the numbers.

				if (numbers[i] > numbers[i + 1]) {
					swappedSomething = true;
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
				}
			}
		}

		System.out.println("\nAfter:");
		System.out.println();
		printArray(numbers);
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
