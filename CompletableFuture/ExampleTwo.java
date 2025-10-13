package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ExampleTwo {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            return "Data from server";
        })
        .thenApply(data -> data.toUpperCase())
        .thenAccept(result -> System.out.println("Processed: "+ result));

        System.out.println("Main thread not blocked...");
        Thread.sleep(3000); // wait so background work can finish
    }
}
