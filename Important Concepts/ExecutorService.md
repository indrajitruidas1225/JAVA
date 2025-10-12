# ExecutorService in Java

`ExecutorService` is a subinterface of `Executor`.

It extends the simple task execution model of `Executor` by adding:

* Task submission methods that can return results
* Lifecycle control methods (`shutdown`, `terminate`)
* Support for collections of tasks (e.g., `invokeAll`, `invokeAny`)

---

### Definition

```java
public interface ExecutorService extends Executor {
    void shutdown();
    List<Runnable> shutdownNow();
    boolean isShutdown();
    boolean isTerminated();

    <T> Future<T> submit(Callable<T> task);
    <T> Future<T> submit(Runnable task, T result);
    Future<?> submit(Runnable task);

    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;
    <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException;
}
```

---

### How to Create an ExecutorService

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

---

### Other Factory Methods

| Method                      | Description                                                            |
| --------------------------- | ---------------------------------------------------------------------- |
| `newSingleThreadExecutor()` | Creates an executor with one thread only                               |
| `newFixedThreadPool(n)`     | Creates a pool with a fixed number of threads                          |
| `newCachedThreadPool()`     | Expands/shrinks dynamically; idle threads are removed after 60 seconds |
| `newScheduledThreadPool(n)` | Creates a pool for delayed or periodic tasks                           |

---

### Shutdown Methods

| Method          | Behavior                                                    |
| --------------- | ----------------------------------------------------------- |
| `shutdown()`    | Stops accepting new tasks; waits for running ones to finish |
| `shutdownNow()` | Attempts to stop all running tasks immediately              |

---

### invokeAll()

**Usage:** Submit multiple tasks and get all results.

This method accepts a collection of `Callable` tasks and runs them concurrently.
It blocks until all are finished and returns a `List` of `Future` objects.

**Key Point:**
`invokeAll()` waits until all tasks are completed before returning.

---

### invokeAny()

**Usage:** Run multiple tasks and return the result of the first one that finishes.

**Behavior:**

* Executes a collection of `Callable` tasks
* Returns the result of the first completed task
* Cancels all other unfinished tasks automatically

---

### awaitTermination()

```java
executor.shutdown();
if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
    System.out.println("Some tasks didn't finish in time.");
}
```

Used after calling `shutdown()` — waits for all tasks to finish within a given timeout.

---

### Status Methods

| Method           | Description                                                                 |
| ---------------- | --------------------------------------------------------------------------- |
| `isShutdown()`   | Returns `true` if `shutdown()` has been called                              |
| `isTerminated()` | Returns `true` when all tasks are finished and executor is fully terminated |

---

### Summary Table

| Method                            | Description                          | Blocking? | Returns                |
| --------------------------------- | ------------------------------------ | --------- | ---------------------- |
| `submit()`                        | Submit a single Runnable or Callable | No        | `Future`               |
| `invokeAll()`                     | Run a list of tasks, wait for all    | ✅ Yes     | `List<Future>`         |
| `invokeAny()`                     | Run a list, return first result      | ✅ Yes     | Result of one task     |
| `shutdown()`                      | Gracefully stop accepting new tasks  | No        | void                   |
| `shutdownNow()`                   | Forcefully stop running tasks        | No        | List<Runnable> not run |
| `awaitTermination()`              | Wait for termination                 | ✅ Yes     | boolean                |
| `isShutdown()` / `isTerminated()` | Check status                         | No        | boolean                |
