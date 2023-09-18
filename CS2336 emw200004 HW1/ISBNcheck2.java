import java.util.Scanner;

public class ISBNcheck2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first 9 digits of an ISBN as integer: "); // prompt user and receive input
		String isbn = input.next();

		int total = 0;

		for (int i = 0; i < isbn.length(); i++) { // loop through ISBN
			char temp = isbn.charAt(i); // get each digit as chars
			total += (Character.getNumericValue(temp)) * (i + 1); // convert charts to integers and multiply digit by index, add to total
		}
		total = total % 11; // do ISBN calculation

		if (total == 10) // if 10 last digit is represented by X, else just use number
			System.out.println("The ISBN-10 number is " + isbn + 'X');
		else
			System.out.println("The ISBN-10 number is " + isbn + total);
		
		input.close();
	}
}
