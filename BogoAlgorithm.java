// BogoAlgorithm demonstration. 
// Goal is to randomly shuffle an unsorted list in hopes of it being sorted
// once done. If shuffle is unsuccessful, random shuffle will continue until 
// list is sorted perfectly. 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BogoAlgorithm {

	public static void main(String[] args) {

// Instantiate random object, as well as a list of integers.
// Our for loop will iterate list, calling the add method to 
// randomly add integers for our specified range. In this example,
// our list will have 3 numbers between the range of 0 to 9,999.

		Random rand = new Random();
		List<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			numberList.add(rand.nextInt(10000));
		}

// "Bogo Sort" algorithm: we check to see if our is shuffled.
// If not, we call the shuffle message again.

		while (!isListSorted(numberList)) {
			Collections.shuffle(numberList);
		}

// Once successully sorted, our list calls the ".forEach()" method to iterate 
// and print random integers added to list:

		numberList.forEach(i -> System.out.println(i));
	}

// boolean method which returns "true" if list is sorted. "false" if otherwise

	private static boolean isListSorted(List<Integer> numberList) {

// will return true if numberList is equal to null because by default, an "empty"
// list is technically "sorted". Same principle applies if list only has 1 element

		if (numberList == null) {
			return true;
		}

		int length = numberList.size();
		if (length <= 1) {
			return true;
		}

		
// for loop which compares numberList indexes to determine if sort for ascending order
// was successful. If the previous index is greater than the following number being 
// iterated, we return false:
		
		for (int i = 0; i < length - 1; i++) {
			if (numberList.get(i) > numberList.get(i + 1)) {
				return false;
			}
		}

		return true;

	}

}
