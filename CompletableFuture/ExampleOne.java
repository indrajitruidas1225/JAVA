package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExampleOne {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        // Step 1: Run a background task that returns a value
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread running in "+ Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 20*20;
        });

        System.out.println("Main thread doing another task");

        // Step 2: Wait and get result (optional)

        Integer result = future.get();
        System.out.println("Result "+result);

    }
}
