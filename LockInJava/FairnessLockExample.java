import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class FairnessLockExample{
    private final Lock lock = new ReentrantLock(true);

    public void accessResource(){
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName()+" acquired the lock");
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }finally{
            System.out.println(Thread.currentThread().getName()+" released the lock");
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        FairnessLockExample fairnessLockExample = new FairnessLockExample();

        Runnable task = new Runnable(){
            @Override
            public void run(){
                fairnessLockExample.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread1");
        Thread thread2 = new Thread(task, "Thread2");
        Thread thread3 = new Thread(task, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

