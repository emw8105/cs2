import java.util.*;

public class ListPart {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter list: ");
		int listSize = input.nextInt(); // first value represents the list size
		int[] list = new int[listSize];
		for (int i = 0; i < listSize; i++) { // remaining values will be added to the list one by one
			list[i] = input.nextInt();
		}

		partition(list); // call method on user-entered list

		System.out.print("After the partition, the list is");
		for (int i = 0; i < list.length; i++) {
			System.out.print(" " + list[i]);
		}
		input.close();
	}

	public static int partition(int[] list) {
		int partIndex = 0; // tracks the index of the partition
		int partition = list[0]; // tracks the value of the partition
		int end = list.length - 1; // tracks the values at the end of the list to swap to

		// will have at most list.length swaps because either part index increments or end decrements each iteration
		while (partIndex < end) { // loop until the partition location reaches the end values
			if (partition <= list[partIndex+1]) { // if the partition value is less than the next value in the list
				int temp = list[end]; // use temp to swap elements
				list[end] = list[partIndex+1]; // send element to the second half of the list after the partition
				list[partIndex+1] = temp;
				end--; // decrement end so next element that is sent will be in the index on the left of the previous one
			} else { // if the partition value is greater than the next value in the list
				list[partIndex] = list[partIndex+1]; // swap the next value and the partition value in the list
				list[partIndex+1] = partition; // have the next value be the new partition value
				partIndex++; // increment partIndex to correlate with next value of partition
			}
		}
		return partIndex;
	}

}
