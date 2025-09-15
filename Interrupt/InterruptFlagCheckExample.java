package Interrupt;

public class InterruptFlagCheckExample implements Runnable{

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Thread is running");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                // Re-interrupt the thread to preserve the interrupted status
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted during sleep.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptFlagCheckExample());
        thread.start();
        Thread.sleep(9000);
        thread.interrupt();
    }
}
/*

If a thread doesn’t check for interrupts, it might keep 
running even when we tell it to stop. This can waste resources and slow down the program.
In the example, the thread does some work, pauses for 1 second,
and keeps checking if it has been interrupted. When it gets interrupted, 
it notices it, stops its work, and exits safely.


When a thread is running normally (not sleeping or waiting),
an interrupt does not stop it automatically—it only sets a flag. 
The thread must manually check this flag using isInterrupted() or Thread.interrupted() and decide to stop. 
If it’s sleeping or waiting, Java throws InterruptedException, which also clears the flag, 
so we often re-set it to remember the interrupt. Without manually checking, 
a running thread would keep executing even after being interrupted.

*/