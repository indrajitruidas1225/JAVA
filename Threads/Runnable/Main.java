class Demo{
    Demo(){
        System.out.println("This is a demo class");
    }
}

class MyThread extends Demo implements Runnable{
    private String threadName;

    MyThread(String name){
        this.threadName = name;
    }

    @Override
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(threadName + "-Count:"+i);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(threadName+" interrupted");
            }
        }
        System.out.println(threadName + " finished.");
    }
}
public class Main{
   public static void main(String[] args){
        MyThread obj1 = new MyThread("thread 1");
        Thread t1 = new Thread(obj1);

        MyThread obj2 = new MyThread("thread 1");
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
   }
}
