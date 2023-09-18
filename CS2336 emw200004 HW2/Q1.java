class Rectangle {
    // Default values of a rectangle
    double width = 1;
    double height = 1;

    // Construct a rectangle object
    Rectangle() {
    }
    Rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }
    /** Return the area of this circle */
    double getArea() {
        return width * height;
    }
    /** Return the perimeter of this circle */
    double getPerimeter() {
        return width + height;
    }
}


public class Q1 {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4, 40);
        Rectangle rect2 = new Rectangle(3.5, 35.9);

        System.out.println("rect1:");
        System.out.println("width = 4, height = 40, area = " + rect1.getArea() + ", perimeter = " + rect1.getPerimeter());
        System.out.println("\nrect1:");
        System.out.println("width = 3.5, height = 35.9, area = " + rect2.getArea() + ", perimeter = " + rect2.getPerimeter());
    }
}