import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Ravi");
        names.add("Anita");
        names.add("Meera");
        names.add("Kiran");

        Collections.sort(names, (first, second) -> first.compareTo(second));

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
