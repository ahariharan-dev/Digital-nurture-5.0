import java.util.Scanner;

public class Simplecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double r;

        switch (op) {
            case '+':
                r = num1 + num2;
                System.out.println("Result = " + r);
                break;

            case '-':
                r = num1 - num2;
                System.out.println("Result = " + r);
                break;

            case '*':
                r = num1 * num2;
                System.out.println("Result = " + r);
                break;

            case '/':
                if (num2 != 0) {
                    r = num1 / num2;
                    System.out.println("Result = " + r);
                } else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;

            default:
                System.out.println("Invalid operation!");
        }

        sc.close();
    }
}