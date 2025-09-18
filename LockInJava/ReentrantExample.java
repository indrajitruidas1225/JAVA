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
