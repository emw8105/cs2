import java.util.Scanner;

public class Loan {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Loan Amount: "); // prompt user and receive input
		double loanAmount = input.nextInt();
		System.out.print("Number of Years: "); // prompt user and receive input
		int numYears = input.nextInt();
		System.out.print("Annual Interest Rate: "); // prompt user and receive input
		double interest = input.nextInt();

		interest /= 100; // turn interest from percentage to decimal
		double monthlyInterestRate = interest / 12; // divide by 12 to get monthly amount instead of yearly
		
		// use given formula
		double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - (Math.pow(1 + monthlyInterestRate, -1 * numYears * 12)));
		
		System.out.printf("Monthly Payment: %,.2f", monthlyPayment); // output calculated monthly payment
		System.out.println("");
		System.out.printf("Total Payment: %,.2f", monthlyPayment * numYears * 12); // multiply monthly payment by amount of months for total
		System.out.println("");

		System.out.println("Payment#\tInterest\tPrincipal\tBalance"); // output sheet
		for (int i = 1; i <= numYears * 12; i++) { // loop through number of months
			interest = loanAmount * monthlyInterestRate; // use calculation for interest, will decrease as amount to pay decreases
			double principal = monthlyPayment - interest; // use calculation for principal, will increase as interest decreases
			loanAmount = loanAmount - principal; // amount left to pay off decreases each month
			System.out.printf(i + "\t\t%,.2f\t\t%,.2f\t\t%,.2f", interest, principal, loanAmount); // output calculations
			System.out.println("");
		}

		input.close();
	}
}