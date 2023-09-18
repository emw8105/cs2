import java.util.*;

public class Geometry {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
		double r1X = input.nextDouble(); // x value of first square
		double r1Y = input.nextDouble(); // y value of first square
		double r1Width = input.nextDouble(); // width value of first square
		double r1Height = input.nextDouble(); // height value of first square

		System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
		double r2X = input.nextDouble(); // x value of second square
		double r2Y = input.nextDouble(); // y value of second square
		double r2Width = input.nextDouble(); // width value of second square
		double r2Height = input.nextDouble(); // height value of second square
		
		// if the x values of r2 are contained within the x values of r1
		if ((r2X + (r2Width/2) <= r1X + (r1Width/2)) && (r2X - (r2Width/2) >= r1X - (r1Width/2))) {
			//if the y values of r2 are contained within the y values of r1
			if ((r2Y + (r2Height/2) <= r1Y + (r1Height/2)) && (r2Y - (r2Height/2) >= r1Y - (r1Height/2))) {
				System.out.println("r2 is inside r1"); // then the whole of r2 is contained within r1
			}
		} // if the x values of r1 are contained within the x values of r2
		else if ((r1X + (r1Width/2) <= r2X + (r2Width/2)) && (r1X - (r1Width/2) >= r2X - (r2Width/2))) {
			//if the y values of r1 are contained within the y values of r2
			if ((r1Y + (r1Height/2) <= r2Y + (r2Height/2)) && (r1Y - (r1Height/2) >= r2Y - (r2Height/2))) {
				System.out.println("r1 is inside r2"); // then the whole of r1 is contained within r2
			}
		}
		// if leftmost point of r1 and rightmost point of r2 don't cross, also opposite
		// if topmost point of r1 and bottommost point of r1 don't cross, also opposite
		else if ((r1X + (r1Width/2) < r2X - (r2Width/2)) || (r1X - (r1Width/2) > r2X + (r2Width/2))
				|| (r1Y + (r1Height/2) < r2Y - (r2Height/2)) || (r1Y - (r1Height/2) > r2Y + (r2Height/2))) {
				System.out.println("r2 does not overlap r1");
		}
		else { // if any values cross, then there will be overlap
			System.out.println("r2 overlaps r1");
		}
		
		input.close();
	}
}