package VolatileAtomic;

class SharedResource{
    private volatile boolean flag = false;
    public void setFlagTrue(){
        flag = true;
    }

    public void printFlagValue(){
        while(!flag){
            //do nothing
        }
        System.out.println("Flag Value is True");
    }
}
public class VolatileExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            obj.setFlagTrue();
        });

        Thread readerThread = new Thread(() -> {
            obj.printFlagValue();
        });

        writerThread.start();
        readerThread.start();
    }
}
