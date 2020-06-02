public class Program {
    public static Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = Validation.checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = Validation.checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = Validation.checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }
    public static Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = Validation.checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = Validation.checkInputDouble();
        return new Rectangle(width, length);
    }

    public static Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = Validation.checkInputDouble();
        return new Circle(radius);
    }

    public static void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
