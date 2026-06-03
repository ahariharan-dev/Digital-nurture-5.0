public class TypeCastingExample {

    public static void main(String[] args) {

        double price = 99.99;
        int convertedPrice = (int) price;

        System.out.println("Double Value: " + price);
        System.out.println("Converted to Int: " + convertedPrice);

        int marks = 95;
        double newMarks = marks;

        System.out.println("Integer Value: " + marks);
        System.out.println("Converted to Double: " + newMarks);
    }
    
}   
