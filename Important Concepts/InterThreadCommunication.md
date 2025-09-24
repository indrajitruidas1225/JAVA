
---

# Inter-Thread Communication in Java

When multiple threads share the same resource, proper coordination is necessary. If threads are not well coordinated, unexpected problems may occur. For example, one thread may depend on the result of another, but if there is no communication between them, the waiting thread may never proceed even though the other thread has finished its work.

To solve this, Java provides **inter-thread communication**, which allows threads to signal each other and coordinate execution. This ensures that threads run in the correct order and resources are accessed safely.

---

## Methods for Inter-Thread Communication

### `wait()`

* Called on a shared object’s monitor (inside a `synchronized` block/method).
* The current thread releases the lock on that object and goes into a waiting state until another thread calls `notify()` or `notifyAll()` on the same object.
* Essentially: “I can’t continue right now, I’ll pause and wait until someone wakes me up.”

```java
while (hasData) {
    wait();  // Producer stops until consumer notifies
}
```

---

### `notify()`

* Wakes up **one random thread** that is waiting on the same object’s monitor.
* That thread will try to regain the lock and continue execution.
* Essentially: “Hey, one of you waiting threads, wake up. But you can only run when I’m done with the lock.”

---

### `notifyAll()`

* Wakes up **all threads** waiting on the same object’s monitor.
* They all become runnable, but only one can acquire the lock at a time; the rest keep waiting.
* Useful when there are multiple producers/consumers and you don’t know which one should run.
* Essentially: “Everyone wake up! Whoever grabs the lock first gets to run.”

---

## Why Inside `synchronized`?

`wait()`, `notify()`, and `notifyAll()` must be used inside a `synchronized` block because they depend on the **lock of the object**.

* When a thread calls `wait()`, it gives up the lock and waits.
* When it is woken up, it needs to acquire the same lock again before continuing.
* `notify()` or `notifyAll()` wake up waiting threads, but only the thread holding the lock is allowed to do this.

If these methods are used without synchronization, it would cause confusion and unsafe access to shared data. To prevent this, Java enforces that they can only be called when the thread owns the lock.

---

