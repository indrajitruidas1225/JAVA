
---

### Locks in Java

In **Java**, every object has an inbuilt lock in it.
The purpose of the lock is to ensure no race condition happens and the expected output comes.

When two or more threads work on a shared resource, for example:

```java
public class Counter implements Runnable {
    private int c = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                c++;
            }
        }
    }

    public int getCount() {
        return c;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getCount());
    }
}
```

Here, a race condition may happen (we may not get `2000` as the output).
To avoid it, we make the function or a specific block **synchronized**.

---

### Problem with `synchronized`

The problem with `synchronized` is that once a thread acquires the lock, if it does not complete, it can keep the resource locked for an **indefinite time**, and other threads will keep waiting.

---

### ReentrantLock

To solve this, Java provides a manual way of working with locks: **`ReentrantLock`**.

* `ReentrantLock` is a class that implements the **Lock interface**.
* We can create an object of `ReentrantLock` and use its functionalities.
* In `ReentrantLock`, multiple threads can acquire the same lock *reentrantly*, but each call to `lock()` must be followed by a matching `unlock()`.
* For each lock, a **hold count** is maintained.

⚠️ If we forget to `unlock()`, other threads may never acquire the lock (leading to deadlock).
⚠️ If we call more `unlock()` than `lock()`, we’ll get an **IllegalMonitorStateException**.

👉 **Rule:** Each `lock()` must be mapped to exactly one `unlock()`.
As the below example shows .

```java
package LockInJava;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class ReentrantExample {
    
    private final Lock lock = new ReentrantLock();

    public void OuterMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " - Outer Method");
            InnerMethod();
        } finally {
            lock.unlock(); // Outer unlock
        }
    }

    public void InnerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " - Inner Method");
        } finally {
            // 🔴 if we comment this unlock, lock will never be fully released
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample obj = new ReentrantExample();
        Runnable task = () -> {
            obj.OuterMethod();
        };
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();
    }
}

```

---

### Functionalities of `ReentrantLock`

* **`lock()`** → Works like `synchronized`. Acquires the lock if available, otherwise waits until the lock is released.
* **`tryLock()`** → Attempts to acquire the lock immediately. If the lock is available, it acquires it; otherwise, it returns `false` instead of waiting.
* **`tryLock(long time, TimeUnit unit)`** → Waits for the specified time to acquire the lock. If not acquired within that time, it exits waiting.
* **`lockInterruptibly()`** → Unlike `lock()`, this method allows a thread to be interrupted while waiting for the lock.

---

### Deadlock Prevention with ReentrantLock

ReentrantLock **does not automatically prevent all deadlocks** (programmer must still use it carefully),
but it provides **tools to avoid them**, unlike `synchronized` which can only block indefinitely:

1. **Timeout with `tryLock(time, unit)`**

   * A thread can try to acquire the lock but give up after a certain time if it doesn’t succeed.
   * This prevents two threads from waiting forever for each other.

2. **Interruptible lock acquisition (`lockInterruptibly`)**

   * If a thread is waiting on a lock, another thread can interrupt it, so it doesn’t stay stuck indefinitely.

3. **Explicit lock management**

   * Since you control `lock()` and `unlock()`, you can design strategies (like acquiring multiple locks in a fixed order) to avoid deadlock situations.

So, unlike `synchronized`, where a waiting thread is *stuck until the lock is released*,
with `ReentrantLock`, you can **time out, back off, or get interrupted**, thus avoiding classic deadlock scenarios.

---

### Fairness of Lock

Fairness in locks determines the order in which multiple threads acquire the lock. By default, a `ReentrantLock` is **non-fair**, meaning that any waiting thread can attempt to acquire the lock, and there is no guaranteed order. This can lead to higher throughput but some threads may be "starved."
If we enable fairness (`new ReentrantLock(true)`), threads acquire the lock in the order they requested it (FIFO), ensuring predictable scheduling but potentially reducing overall performance.

---

### Read-Write Reentrant Lock

A **ReadWriteLock** (commonly `ReentrantReadWriteLock`) separates lock access into **read** and **write** locks.

* **Read Lock**: Multiple threads can hold the read lock simultaneously as long as no thread holds the write lock. This improves performance when reads are frequent.
* **Write Lock**: Only one thread can hold the write lock, and it blocks all readers and writers until it is released.

This design is useful when read operations are much more common than writes, as it allows higher concurrency.

---




