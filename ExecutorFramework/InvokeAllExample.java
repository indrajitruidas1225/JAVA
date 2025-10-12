package ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class InvokeAllExample {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> { Thread.sleep(1000); return "Task 1 done"; },
            () -> { Thread.sleep(2000); return "Task 2 done"; },
            () -> { Thread.sleep(1500); return "Task 3 done"; }
        );
        System.out.println("Submitting tasks....");

        List<Future<String>> results = executorService.invokeAll(tasks);
        System.out.println("All tasks completed successfully.");

        for(Future<String> f : results){
            System.out.println(f.get());
        }

        executorService.shutdown();
    }
}
