package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExampleThree {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 30);

        CompletableFuture<Integer> combined = future1.thenCombine(future2, (a, b) -> a + b);

        System.out.println("Sum: " + combined.get());
    }

}
