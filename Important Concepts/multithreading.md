
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