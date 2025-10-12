# Future Interface in Java

The `Future` interface represents the result of an asynchronous computation — a task that runs in the background and eventually produces a value.

It is part of the `java.util.concurrent` package.

---

### Definition of the Interface

```java
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
```

---

### Key Points

When a task is submitted via `ExecutorService.submit()`, it returns a `Future` object.

`Future` helps to:

* Check if the task is done (`isDone()`)
* Cancel the task (`cancel()`)
* Get the result (`get()` — blocks until done)

---

### Example

```java
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
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
```
