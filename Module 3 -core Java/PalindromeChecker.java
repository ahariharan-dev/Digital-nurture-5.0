import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedText = new StringBuilder(cleanedText).reverse().toString();

        if (cleanedText.equals(reversedText)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}
