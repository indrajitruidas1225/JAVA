package Threads.InterThreadCommunication;

class SharedBufferOne{
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

class ProducerOne extends Thread{
    private SharedBufferOne buffer;

    ProducerOne(SharedBufferOne buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            buffer.produce(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerOne extends Thread{
    private SharedBufferOne buffer;

    ConsumerOne(SharedBufferOne buffer){
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
public class SharedBufferOneExample {
    public static void main(String[] args) {
        SharedBufferOne buffer = new SharedBufferOne();
        ProducerOne producer = new ProducerOne(buffer);
        ConsumerOne consumer = new ConsumerOne(buffer);

        producer.start();
        consumer.start();
    }
}
