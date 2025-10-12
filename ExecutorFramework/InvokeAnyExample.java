package ExecutorFramework;

import java.util.*;
import java.util.concurrent.*;

public class InvokeAnyExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> { Thread.sleep(2000); return "Result from Task A"; },
            () -> { Thread.sleep(1000); return "Result from Task B"; },
            () -> { Thread.sleep(3000); return "Result from Task C"; }
        );

        String result = executor.invokeAny(tasks);
        System.out.println("First completed task: " + result);

        executor.shutdown();
    }
}

