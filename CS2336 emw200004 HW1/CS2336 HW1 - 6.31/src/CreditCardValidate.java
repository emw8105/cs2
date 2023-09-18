import java.util.*;
public class CreditCardValidate {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number as a long integer: ");
		
		long card = input.nextLong();
		
		if (isValid(card)) {
			System.out.println(card + " is valid");
		}
		else {
			System.out.println(card + " is invalid");
		}
		
		input.close();
	}
	
	//return true if valid, recursively call other methods
	//Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up 
	//the two digits to get a single-digit number.
	//Then add all single-digit numbers from Step 1
	public static boolean isValid(long number) {
		int cardLength = getSize(number);
		if (cardLength <= 13 || cardLength >= 16) { // first check if the number of digits input is correct
			long prefix = getPrefix(number, 2);
			if (prefixMatched(prefix, 2)) {
				long digitGetter = 10;
				boolean doubleDigit = false;
				int total = 0;
				for (int i = cardLength; i > 0 ; i--) { // loop thru digits in the card from right to left
						long digit = number % digitGetter; // cut off numbers before desired digit
						digit = (digit*10)/digitGetter; // cut off number after desired digit
						digitGetter *= 10; // increase "index" of digit segmenting for next loop iteration
						if (doubleDigit == true) { // if digit is even, double every second digit
							total += sumOfDoubleEvenPlace(digit);
						}
						else { // if digit was odd
							total += sumOfOddPlace(digit);
						}
						doubleDigit = !doubleDigit; // switch for next digit to be doubled / not doubled
				}
				if (total % 10 == 0) { // if total is divisible by 0, then card has passed all checks and is valid
					return true;
				}
				else { // card is invalid based on mod 10 check
					return false;
				}
			}
			else { // card is invalid based on prefix
				return false;
			}
		}
		else { // card is invalid based on number of digits
			return false;
		}
	}
	
	//"get the result from step 2" : add all single digit numbers
	// from step 1, which is double every second digit and do getDigit
	public static int sumOfDoubleEvenPlace(long number) {
		number *= 2;
		number = getDigit((int)number);
		return (int)number;
	}
	
	//returns the given num if one digit, returns the sum if two
	public static int getDigit(int number) {
		if (number > 9) { // if more than one digit
			int num1 = (int)number % 10;
			int num2 = (int)number % 100;
			num2/=10;
			return num1 + num2;
		}
		else { // if only one digit
			return (int)number;
		}
	}
	
	public static int sumOfOddPlace(long number) {
		number = getDigit((int)number);
		return (int)number;
	}
	
	
	//not really sure how to use prefixMatched, maybe as send value of getPrefix to prefixMatched which will output
	// true or false if the prefix has a correct match, then if statement in isValid will do the system.output for it
	public static boolean prefixMatched(long number, int d) {
		if (d == 2 && number == 37) { // check if 2 digit answer works
			return true;
		}
		else { // if 2 digit answer is invalid, try just first digit valid answers
			number = getPrefix(number, 1);
			if (number == 4 || number == 5 || number == 6) {
				return true;
			}
			else { // if no prefixes were valid, then card is invalid
				return false;
			}
		}
	}

	
	// use getSize to get the number of digits in the card, return result to getValid and check if the
	// number of digits are between 13 and 16 inclusive, have result saved in variable to do loop after
	public static int getSize(long d) {
		return String.valueOf(d).length();
	}
	
	
	// use getPrefix to get a specified number of digits from the beginning of the card #, ideally 1 or 2
	// to check the prefix's of the valid card companies, then send result back to prefixMatched in isValid
	public static long getPrefix(long number, int k) {
		String str = "" + number; // convert card number to string
		str = str.substring(0, k); // use substring method to get digits from 0 to k
		return Long.parseLong(str); // convert substring to long and return value
	}
}
