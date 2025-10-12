package ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a ScheduledExecutorService with 2 threads

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        // 1. schedule(Runnable, delay, unit)

        Runnable oneTimeTask = () -> System.out.println("1. One time task executed after 2 seconds");
        scheduler.schedule(oneTimeTask, 2, TimeUnit.SECONDS);

        // 2. schedule(Callable, delay, unit)
        Callable<String> callableTask = () -> {
            Thread.sleep(1);
            return "Callable result after 3 seconds delay";
        };

        ScheduledFuture<String> future = scheduler.schedule(callableTask, 3, TimeUnit.SECONDS);
        System.out.println(future.get());

        // 3. scheduleAtFixedRate(Runnable, initialDelay, period, unit)
        Runnable fixedRateTask = () ->
            System.out.println("Fixed rate task: " + System.currentTimeMillis());

        scheduler.scheduleAtFixedRate(fixedRateTask, 1, 4, TimeUnit.SECONDS);

        // 4. scheduleWithFixedDelay(Runnable, initialDelay, delay, unit)
        Runnable fixedDelayTask = () -> {
            System.out.println("Fixed delay task: " + System.currentTimeMillis());
            try {
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        scheduler.scheduleWithFixedDelay(fixedDelayTask, 2, 3, TimeUnit.SECONDS);
        Thread.sleep(15000);
        scheduler.shutdown();
        System.out.println("Scheduler shutdown called");

        if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Some tasks did not finish in time...");
            scheduler.shutdownNow();
        } else {
            System.out.println("All tasks completed before shutdown.");
        }
    }
}
