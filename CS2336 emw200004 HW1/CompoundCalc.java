import java.util.*;
public class CompoundCalc {
	
	public static void main(String[] args) {
		final double INTEREST = 0.00417; // monthly interest divided from annual interest
		double saveAmount = 0;
		double totalSave = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the monthly saving amount: "); // prompt user and receive input
		saveAmount = input.nextDouble();

		for (int i = 0; i < 6; i++) { // loop over 6 months
			totalSave = (saveAmount + totalSave) * (1 + INTEREST); // use formula to calculate amount saved
		}
		
		System.out.printf("After the sixth month, the account value is $%,.2f", totalSave);
		
		input.close();
	}
}
