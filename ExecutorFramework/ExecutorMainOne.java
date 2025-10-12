package ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorMainOne {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(()->55); //uses callable because it returns omething
        Future<?> future2 = executor.submit(() -> {System.out.println("Hello");}); //uses runnable because it doesn't return anything
        System.out.println(future.get());

        if(future.isDone()){
            System.out.println("Task is completed");
        }
        executor.shutdown();
    }
}
