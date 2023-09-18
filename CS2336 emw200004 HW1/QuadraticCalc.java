import java.util.*;
public class QuadraticCalc {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a, b, c: "); // prompt user and receive input
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		double discriminant = Math.pow(b, 2) - (4*a*c); // use calculation for the discriminant
		
		
		if (discriminant < 0) { // no real roots if discriminant is negative
			System.out.println("The equation has no real roots");
		}
		else if (discriminant == 0) { // one real root if the discriminant is 0
			double root = (-1 * b)/(2 * a); // calculate the root
			System.out.print("The equation has one root " + root);
		}
		else { // two real roots if the discriminant is positive
			double root = ((-1 * b) + Math.pow(discriminant, 0.5))/ (2 * a); // calculate first root
			System.out.print("The equation has two roots " + root);
			root = ((-1 * b) - Math.pow(discriminant, 0.5))/ (2 * a); // calculate second root
			System.out.print(" and " + root);
		}
		
		input.close();
	}
}