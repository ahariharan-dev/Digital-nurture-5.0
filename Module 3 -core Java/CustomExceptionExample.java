import java.util.Scanner;

class InvalidAgeException extends Exception {
    private static final long serialVersionUID = 1L;

    InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            checkAge(age);
            System.out.println("You are eligible.");
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        }

        scanner.close();
    }
}
