class MessagePrinter implements Runnable {
    private final String message;

    MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - Count: " + i);
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new MessagePrinter("First thread is running"));
        Thread secondThread = new Thread(new MessagePrinter("Second thread is running"));

        firstThread.start();
        secondThread.start();
    }
}
