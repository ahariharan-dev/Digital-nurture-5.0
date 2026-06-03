import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = new ArrayList<Future<String>>();

        for (int i = 1; i <= 5; i++) {
            final int taskNumber = i;
            Callable<String> task = () -> "Task " + taskNumber + " completed by "
                    + Thread.currentThread().getName();
            futures.add(executorService.submit(task));
        }

        try {
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            System.out.println("Task execution failed: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
