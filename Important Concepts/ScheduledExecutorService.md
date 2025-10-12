Here’s the cleanly formatted version:

---

### **ScheduledExecutorService**

`ScheduledExecutorService` is a subinterface of `ExecutorService` that can schedule tasks to run after a delay or periodically.

---

#### **Definition**

```java
public interface ScheduledExecutorService extends ExecutorService {
    ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
    <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);
    ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
```

---

#### **Methods**

| Method                                                        | Description                                                                                              |
| ------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| `schedule(Runnable, delay, unit)`                             | Runs a one-time task after the given delay                                                               |
| `schedule(Callable, delay, unit)`                             | Same as above, but returns a result                                                                      |
| `scheduleAtFixedRate(Runnable, initialDelay, period, unit)`   | Runs a task repeatedly at a **fixed rate** (start times are fixed intervals apart)                       |
| `scheduleWithFixedDelay(Runnable, initialDelay, delay, unit)` | Runs a task repeatedly with a **fixed delay** between the end of one execution and the start of the next |

---

### **🕒 scheduleAtFixedRate()**

* Runs tasks **at fixed time intervals** from the **start time**.
* If one run takes longer, the **next starts immediately** (no extra wait).
* Keeps a **steady rhythm**.

So:
✅ If task < 4s → runs exactly every 4s
⚠️ If task > 4s → next run starts right after it finishes (to catch up)

---

### **⏳ scheduleWithFixedDelay()**

* Waits a **fixed delay after the task finishes** before starting again.
* If a run takes longer, the **whole schedule shifts forward**.
* Keeps a **steady gap**.

---

| Method       | Next run starts...             | Example                 |
| ------------ | ------------------------------ | ----------------------- |
| `FixedRate`  | From previous **start time**   | Every 4s (even if slow) |
| `FixedDelay` | After previous **end + delay** | Wait 4s after finishing |
