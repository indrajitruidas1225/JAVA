
---
![example](../DeadLock/DeadLockExample.java)

## 🔹 What is Deadlock?

Deadlock is a situation in multithreading where **two or more threads are permanently blocked**, each waiting for a resource that the other holds.
Since none of the threads can proceed, the program “hangs.”

---

## 🔹 How this program can go into Deadlock?

1. **Thread-1** (`Task1`)

   * Acquires **Pen’s lock** (because `writeWithPenAndPaper()` is `synchronized` on `Pen`).
   * Then it tries to call `paper.finishWriting()`, which needs the **Paper’s lock**.

2. **Thread-2** (`Task2`)

   * Acquires **Paper’s lock** (because `writeWithPaperAndPen()` is `synchronized` on `Paper`).
   * Then it tries to call `pen.finishWriting()`, which needs the **Pen’s lock**.

👉 At this point:

* Thread-1 holds **Pen lock** and waits for **Paper lock**.
* Thread-2 holds **Paper lock** and waits for **Pen lock**.

Neither can proceed → **deadlock occurs**.

---

## 🔹 How to Prevent Deadlock?

Several strategies exist:

1. **Consistent Lock Ordering**
   Always acquire locks in the same order. For example, always lock `Pen` first, then `Paper`. If all threads follow the same order, circular waiting cannot occur.

2. **Try-Lock with Timeout** (`tryLock()` in `ReentrantLock`)
   Instead of waiting forever, a thread can try to acquire a lock and back off after a timeout, preventing permanent blocking.

3. **Lock Hierarchy / Avoid Nested Locks**
   Minimize situations where one synchronized method calls another synchronized method.

4. **Deadlock Detection**
   In some advanced systems, we can detect deadlock and restart/kill threads.

---

## 🔹 4 Necessary Conditions for Deadlock (Coffman’s conditions)

Deadlock can occur only if all these hold simultaneously:

1. **Mutual Exclusion**
   A resource (e.g., Pen, Paper) can be held by only one thread at a time.

2. **Hold and Wait**
   A thread is holding one resource and waiting for another.
   (Thread-1 holds Pen and waits for Paper; Thread-2 holds Paper and waits for Pen).

3. **No Preemption**
   A resource cannot be forcibly taken away from a thread; it must be released voluntarily.

4. **Circular Wait**
   A cycle of threads exists where each thread is waiting for a resource held by the next.
   (Thread-1 → needs Paper → held by Thread-2 → needs Pen → held by Thread-1).

---