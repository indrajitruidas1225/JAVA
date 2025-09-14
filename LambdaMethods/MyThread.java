package LambdaMethods;

public class MyThread extends Thread{

    Counter myCounter;
    MyThread(String name, Counter counter){
        super(name);
        this.myCounter = counter;
    }

    @Override
    public void run(){
        for(;;){
            // Thread.yield();
            myCounter.increment();
            System.out.println(Thread.currentThread().getName()+" is executing");
            System.out.print("Priority of "+Thread.currentThread().getName()+" is "+Thread.currentThread().getPriority()+"\n");
            System.out.println(myCounter.getCount());
            // try {
            //     Thread.sleep(100);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
        }
    }
}