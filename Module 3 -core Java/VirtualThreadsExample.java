import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsExample {
    private static final int TASK_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        Instant virtualStart = Instant.now();
        List<Thread> virtualThreads = new ArrayList<Thread>();

        for (int i = 1; i <= TASK_COUNT; i++) {
            final int taskNumber = i;
            Thread thread = Thread.startVirtualThread(() -> {
                System.out.println("Virtual thread message from task " + taskNumber);
            });
            virtualThreads.add(thread);
        }

        for (Thread thread : virtualThreads) {
            thread.join();
        }

        long virtualTime = Duration.between(virtualStart, Instant.now()).toMillis();
        System.out.println("Virtual threads completed in " + virtualTime + " ms.");

        Instant platformStart = Instant.now();
        List<Thread> platformThreads = new ArrayList<Thread>();
        int platformTaskCount = 1_000;

        for (int i = 1; i <= platformTaskCount; i++) {
            final int taskNumber = i;
            Thread thread = new Thread(() -> {
                System.out.println("Platform thread message from task " + taskNumber);
            });
            thread.start();
            platformThreads.add(thread);
        }

        for (Thread thread : platformThreads) {
            thread.join();
        }

        long platformTime = Duration.between(platformStart, Instant.now()).toMillis();
        System.out.println("Platform threads completed in " + platformTime + " ms for "
                + platformTaskCount + " threads.");
    }
}
