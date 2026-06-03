public class PatternMatchingSwitchExample {
    public static void printObjectType(Object value) {
        String message = switch (value) {
            case Integer integer -> "Integer value: " + integer;
            case String text -> "String value: " + text;
            case Double decimal -> "Double value: " + decimal;
            case Boolean flag -> "Boolean value: " + flag;
            case null -> "The object is null.";
            default -> "Unknown type: " + value;
        };

        System.out.println(message);
    }

    public static void main(String[] args) {
        printObjectType(42);
        printObjectType("Hello Java");
        printObjectType(12.5);
        printObjectType(true);
        printObjectType(null);
    }
}
