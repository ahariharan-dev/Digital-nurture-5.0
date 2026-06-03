public class BytecodeInspectionDemo {
    public int addNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static void main(String[] args) {
        BytecodeInspectionDemo demo = new BytecodeInspectionDemo();
        int result = demo.addNumbers(10, 20);

        System.out.println("Result: " + result);
        System.out.println("Compile and inspect bytecode with:");
        System.out.println("javac BytecodeInspectionDemo.java");
        System.out.println("javap -c BytecodeInspectionDemo");
    }
}
