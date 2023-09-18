import java.util.*;

public class ISBNcheck {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first 9 digits of an ISBN as integer: "); // prompt user and receive input
		int isbn = input.nextInt();

		int digitGetter = 10;
		int total = 0;

		for (int i = 9; i > 0; i--) { // loop through ISBN
			int temp = isbn % digitGetter; // remove leading numbers
			temp = (temp*10)/digitGetter; // remove trailing numbers
			total += temp * (i); // multiply the digit by it's index and add to the total
			digitGetter *= 10; // multiply by 10 to get the next digit in the next iteration
		}
		total = total % 11; // do ISBN calculation

		if (total == 10) // if 10 last digit is represented by X, else just use number
			System.out.println("The ISBN-10 number is " + isbn + 'X');
		else
			System.out.println("The ISBN-10 number is " + isbn + total);
		
		input.close();
	}
}
