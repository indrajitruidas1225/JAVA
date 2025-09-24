package Threads.InterThreadCommunication;

class SharedBuffer{
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value){
        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        System.out.println("Produced Value "+data);
        hasData = true;
        notifyAll();
    }

    public synchronized void consume(int value){
        while(!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+" Consumed Value "+data);
        hasData = false;
        notifyAll();
    }
}

class Producer extends Thread{
    private SharedBuffer buffer;

    Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i = 0; i < 30; i++){
            buffer.produce(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            buffer.consume(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SingleProducerMultipleConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        Consumer consumer3 = new Consumer(buffer);

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
