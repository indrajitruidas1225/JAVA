package ExecutorFramework;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000); // simulate long task
            return 10 * 10;
        });

        System.out.println("Task submitted...");
        System.out.println("Is done? " + future.isDone());

        Integer result = future.get(); // blocks until result is ready
        System.out.println("Result: " +result);

        executor.shutdown();
    }
}

