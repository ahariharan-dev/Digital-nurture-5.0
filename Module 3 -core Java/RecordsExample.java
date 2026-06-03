import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {
}

public class RecordsExample {
    public static void main(String[] args) {
        Person firstPerson = new Person("Asha", 20);
        Person secondPerson = new Person("Vikram", 16);

        System.out.println(firstPerson);
        System.out.println(secondPerson);

        List<Person> people = Arrays.asList(
                firstPerson,
                secondPerson,
                new Person("Neha", 25),
                new Person("Arjun", 17));

        List<Person> adults = people.stream()
                .filter(person -> person.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("People aged 18 or above:");
        for (Person person : adults) {
            System.out.println(person);
        }
    }
}
