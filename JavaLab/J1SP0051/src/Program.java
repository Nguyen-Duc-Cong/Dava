public class Program {
    public static void alculateSuperlativeEquation() {
        System.out.print("Enter A: ");
        int a = Validation.checkInputInt();
        System.out.print("Enter B: ");
        int b = Validation.checkInputInt();
        System.out.printf("Solution: x = %.3f", -b / a);
        System.out.print("Number is Odd:");
        if (odd(a))
            System.out.print(a);
        if (odd(b))
            System.out.print(b);
        System.out.print("Number is Even:");
        if (!odd(a))
            System.out.print(a);
        if (!odd(b))
            System.out.print(b);

    }

    public static void calculateQuadraticEquation() {
        System.out.print("Enter A: ");
        int a = Validation.checkInputInt();
        System.out.print("Enter B: ");
        int b = Validation.checkInputInt();
        System.out.print("Enter C: ");
        int c = Validation.checkInputInt();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        if (delta == 0)
            System.out.printf("Solution: x = %.3f", x1);
        else if (delta > 0)
            System.out.printf("Solution: x1 = %.3f x2 = %.3f", x1, x2);
        else System.out.println("it not calculate quadratic equation ");
        System.out.print("Number is Odd: ");
        if (odd(a))
            System.out.print(a);
        if (odd(b))
            System.out.print(b);
        if (odd(c))
            System.out.print(c);
        System.out.print("Number is Even:" );
        if (!odd(a))
            System.out.print(a);
        if (!odd(b))
            System.out.print(b);
        if (!odd(c))
            System.out.print(c);
    }

    private static boolean odd(int num) {
        if (num % 2 == 1)
            return true;
        return false;
    }
}
