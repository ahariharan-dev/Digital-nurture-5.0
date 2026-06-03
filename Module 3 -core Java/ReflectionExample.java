import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> targetClass = Class.forName("ReflectionTarget");
            Object targetObject = targetClass.getDeclaredConstructor().newInstance();

            System.out.println("Declared methods:");
            for (Method method : targetClass.getDeclaredMethods()) {
                System.out.print(method.getName() + "(");

                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getSimpleName());
                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println(")");
            }

            Method greetMethod = targetClass.getDeclaredMethod("greet", String.class);
            Object greeting = greetMethod.invoke(targetObject, "Reflection");
            System.out.println("Invoked greet(): " + greeting);
        } catch (ReflectiveOperationException e) {
            System.out.println("Reflection failed: " + e.getMessage());
        }
    }
}
