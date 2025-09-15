
# 🧵 Multithreading in Java

---

## Multitasking and Multithreading Concepts

On a **single-core machine**, multiple processes appear to run at the same time through **time slicing** and **context switching**, managed by the **operating system’s scheduler**, which decides which process gets CPU time.

On a **multi-core machine**, true parallelism is possible since multiple cores can execute tasks simultaneously. This overall concept is called **multitasking**.

A **process** is a program in execution, and it can be further divided into **threads**. Threads are lightweight units of execution that share the same memory space within a process, allowing faster communication. This is the concept of **multithreading**.

👉 Example: In Chrome, each tab usually runs as a **separate process**, and within each process, multiple **threads** handle tasks such as rendering, JavaScript execution, and networking.

---

## Creating Threads in Java

In Java, multithreading can be achieved using either the **`Thread` class** or the **`Runnable` interface**.
If a class already extends another class, we cannot extend `Thread` because Java does not support multiple inheritance. In such cases, we implement `Runnable`. Otherwise, we can directly extend the `Thread` class.

---

### 1️⃣ Using `Thread` class

We override the `run()` method and start execution using the `start()` method.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts the thread
    }
}
```

---

### 2️⃣ Using `Runnable` interface

We override the `run()` method and pass the object of the class to a `Thread` constructor.

```java
class ABC extends A implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        ABC obj = new ABC();
        Thread t1 = new Thread(obj);
        t1.start(); // starts the thread
    }
}
```

---

## 🔹 Methods in Java Multithreading

---

### **start()**

This method starts a new thread. Internally, it calls the `run()` method in a separate call stack.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();  // starts the thread
    }
}
```

---

### **sleep()**

This method pauses the execution of the current thread for a given number of milliseconds.
While one thread is sleeping, other threads can continue execution, ensuring good CPU utilization.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread is running...");
            Thread.sleep(100);  // thread pauses for 100ms
            System.out.println("Thread resumed...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
```

---

### **join()**

This method makes one thread wait until another thread finishes execution.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread task...");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        t1.join();  // main thread waits for t1 to finish
        System.out.println("Main thread continues...");
    }
}
```

---

### **currentThread()**

Returns a reference to the currently executing thread.

```java
class Demo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); // main
    }
}
```

---

### **Thread Priority**

In Java, each thread has a priority (default = 5).

* `MIN_PRIORITY = 1`
* `NORM_PRIORITY = 5`
* `MAX_PRIORITY = 10`

We can set a thread’s priority using `setPriority()`.
However, execution order is **not guaranteed** since it depends on the **JVM and OS scheduler**.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running thread: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }
}
```

---

### **yield()**

Suggests to the thread scheduler that the current thread is willing to pause so that other threads of equal or higher priority may execute.
(Not a guarantee.)

```java
class MyThread extends Thread {
    public void run() {
        for(int i=0; i<3; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        for(int i=0; i<3; i++) {
            System.out.println("Main thread");
        }
    }
}
```

---

### **Daemon Thread vs Main Thread**

* **Main thread** → the primary thread that runs your program.
* **Daemon threads** → background threads (like Garbage Collector). They stop automatically when all non-daemon (user) threads finish.

```java
class MyThread extends Thread {
    public void run() {
        if(Thread.currentThread().isDaemon())
            System.out.println("Daemon thread running...");
        else
            System.out.println("User thread running...");
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setDaemon(true); // set as daemon
        t1.start();
    }
}
```

---

### **interrupt()**

Used to interrupt a thread that is sleeping or waiting.
It sets an “interrupted” flag, which causes the thread to wake up and handle the interruption.

```java
class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread completed task");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        t1.interrupt();  // interrupt t1
    }
}
```
---

# 🔄 Lifecycle of a Thread in Java

A thread in Java goes through several **states** during its lifecycle. These states are defined in the `Thread.State` enum.

---

## **1. New (Created State)**

* When we create a `Thread` object, but before calling `start()`, the thread is in the **new state**.
* It is not yet eligible for running.

```java
Thread t = new Thread(() -> System.out.println("Hello"));
System.out.println(t.getState()); // NEW
```

---

## **2. Runnable State**

* When we call `start()`, the thread moves to the **Runnable** state.
* It means the thread is ready to run, but whether it executes immediately depends on the **OS scheduler**.
* Multiple threads can be in this state, waiting for CPU time.

```java
t.start();
System.out.println(t.getState()); // RUNNABLE (waiting for CPU)
```

---

## **3. Running State**

* When the **CPU scheduler picks** a thread from the runnable pool, it enters the **running state**.
* Only one thread per core can be in this state at a time. (If we check the state, it shows runnable)

---

## **4. Waiting / Timed Waiting State**

A running thread can be **paused**:

* **Waiting** → Thread waits indefinitely until another thread signals it (e.g., using `wait()`, `join()`).
* **Timed Waiting** → Thread pauses for a specific time (e.g., `sleep(ms)`, `join(ms)`).

```java
class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(1000); // Timed Waiting
            synchronized(this) {
                wait(); // Waiting
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## **5. Blocked State**

* A thread is **blocked** when it tries to enter a synchronized block/method but another thread already holds the lock.
* Once the lock is released, the blocked thread becomes runnable again.

---

## **6. Terminated (Dead State)**

* After completing its task (or if stopped forcefully), the thread enters the **terminated state**.
* Once terminated, a thread **cannot be restarted**.

```java
Thread t1 = new Thread(() -> System.out.println("Task done"));
t1.start();
t1.join();
System.out.println(t1.getState()); // TERMINATED
```

---

# 📊 Thread Lifecycle Diagram (Textual)

```
 NEW  --(start())-->  RUNNABLE --(scheduler picks)--> RUNNING
   ↑                        ↓                           ↓
   |                   (yield, wait, sleep, join)  (execution finishes)
   |                        ↓                           ↓
   └<----------------  WAITING / TIMED WAITING <------ TERMINATED
                              ↑
                         (notify/notifyAll, timeout)
```

---

✅ **Quick Summary for Interviews**

* **NEW** → Object created but not started.
* **RUNNABLE** → Eligible to run, waiting for CPU.
* **RUNNING** → Actively executing on CPU.
* **WAITING / TIMED\_WAITING** → Temporarily paused.
* **BLOCKED** → Waiting to acquire a lock.
* **TERMINATED** → Finished execution.

---

# 🔒 Synchronization and Race Condition

When two or more threads work on a shared resource **without proper coordination**, a **race condition** can occur.
This happens because multiple threads may try to **read and update the same variable simultaneously**, leading to unexpected results.

---

## ❌ Example: Race Condition

```java
class Counter {
    int count = 0;

    public void increment() {
        count++; // not atomic (read, modify, write)
    }
}

public class RaceDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count: " + c.count);
        // Expected: 2000, but often < 2000 due to race condition
    }
}
```

👉 This happens because `count++` is **not atomic** — it is actually 3 steps:

1. Read value of `count`
2. Increment it
3. Write back the new value

If two threads execute these steps simultaneously, increments can get lost.

---

## ✅ Solution: Synchronization

### 1. Synchronized Method

```java
public synchronized void increment() {
    count++; 
}
```

Here, the intrinsic lock is held on the **object instance** (`this`). Only one thread can execute `increment()` at a time.

---

### 2. Synchronized Block

```java
public void increment() {
    synchronized (this) { // 'this' refers to the *Counter object*, not the thread
        count++;
    }
}
```

👉 Small correction to your note: `this` refers to the **current object** (the instance of `Counter`), not the thread.
The thread acquires the lock on the object before executing the block.

---

## 📝 Key Point

* Synchronization ensures **mutual exclusion**, so only one thread accesses the shared resource at a time.
* This prevents race conditions, but may reduce performance due to **thread contention**.

---
