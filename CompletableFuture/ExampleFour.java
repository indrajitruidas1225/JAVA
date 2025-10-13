package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ExampleFour {
    public static void main(String[] args) {
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user data from server...");

            // Simulate failure
            if (true)
                throw new RuntimeException("Server not reachable");

            return "User: John";
        })
                .exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return "Default User"; // fallback value
                });

        System.out.println("Result: " + userFuture.join());
    }
}
