import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<String>();

        System.out.print("Enter the number of student names: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);
        }

        System.out.println("Student names entered:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
