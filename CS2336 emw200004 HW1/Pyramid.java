
public class Pyramid {

	public static void main(String[] args) {
		for (int i = 1; i < 9; i++) { // from top down
			int k = 0; // use k as a tracker for the powers of 2 when switching sides of the pyramid
			for (int j = 0; j < 9-i; j++) { // tab over a decrementing amount to form left side triangle
				System.out.print("\t");
			}
			for (int j = 0; j < i; j++) { // powers of 2 on the left side of the pyramid inc to the middle
				System.out.print((int)Math.pow(2, j) + "\t");
				k = j;
			}
			for (int j = 0; j < i-1 ; j++) { // powers of 2 on the right side of the pyramid dec from the middle
				k--;
				System.out.print((int)Math.pow(2, k) + "\t");
			}
			System.out.println(""); // go down a line and continue
		}

	}

}