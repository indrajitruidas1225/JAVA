package LockInJava;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
public class Bank {
    
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try{
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrwal");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance "+balance);
                    }catch(Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally{
                        lock.unlock();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + " insufficient balance.");
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " couldn't acquire the lock. Try again later.");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

}
