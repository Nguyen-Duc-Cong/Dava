public class Program {
    public static void normalCalculator() {
        System.out.print("Enter number:  ");
        double a = Validation.checkInputInt();
        String chosse = "=";
        do {
            try {
                System.out.print("Enter Operator:   ");
                chosse = Validation.checkInputOperator();
                if (chosse == "=") {
                    System.out.printf("Result: %.1f", a);
                    break;
                }
                System.out.print("Enter number:  ");
                double b = Validation.checkInputInt();
                if (chosse.equals("+"))
                    a += b;
                else if (chosse.equals("-"))
                    a -= b;
                else if (chosse.equals("*"))
                    a *= b;
                else if (chosse.equals("/"))
                    a /= b;
                else
                    throw new itNotOperator("Please input (+, -, *, /, ^)");
                System.out.printf("Memory: %.1f", a);
            } catch (itNotOperator e) {
                System.out.println(e);
            }
        } while (true);

    }

    public static void calculatorBMIIndex() {
        System.out.print("Enter Weight(kg): ");
        double weight = Validation.checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = Validation.checkInputDouble();
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}
