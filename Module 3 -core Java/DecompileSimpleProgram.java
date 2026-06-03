public class DecompileSimpleProgram {
    public static void main(String[] args) {
        String message = buildMessage("Java");
        System.out.println(message);
        System.out.println("Compile this file, then open DecompileSimpleProgram.class in JD-GUI or CFR.");
    }

    public static String buildMessage(String topic) {
        return "Decompiling " + topic + " bytecode";
    }
}
