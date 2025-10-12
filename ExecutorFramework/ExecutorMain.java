package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorMain {

    public static long factorial(int n) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result = 1;

        for (int i = n; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            final int num = i;
            executor.submit(() -> {
                long result = factorial(num);
                System.out.println(result);
            });
        }
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));
    }
}
