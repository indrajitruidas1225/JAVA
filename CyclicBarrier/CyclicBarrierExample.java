
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierExample{
    public static void main(String[] args) {
        int numberOfSubsystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
            @Override
            public void run(){
                System.out.println("All systems are up and running. System startup complete");
            }
        });

        Thread webserverThread = new Thread(new Subsystem("Web Server", 2000, barrier));
        Thread databasThread = new Thread(new Subsystem("Database server", 4000, barrier));
        Thread cachedThread = new Thread(new Subsystem("Cache Server", 1500, barrier));
        Thread messagingServicThread = new Thread(new Subsystem("messaging service", 5000, barrier));

        webserverThread.start();
        databasThread.start();
        cachedThread.start();
        messagingServicThread.start();

    }
}

class Subsystem implements Runnable{

    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;
    public Subsystem(String name, int initializationTime, CyclicBarrier barrier){
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run(){
        try {
            System.out.println("Initialization started");
            Thread.sleep(initializationTime);
            System.out.println(name+" initialization complete.");
            barrier.await();
        } catch (InterruptedException ex) {
        } catch (BrokenBarrierException ex) {
        }
    }
}