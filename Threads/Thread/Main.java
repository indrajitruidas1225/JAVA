class MyThread extends Thread{
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

public class Main {
    public static void main(String[] args){
      MyThread T1 = new MyThread("Indra");
      MyThread T2 = new MyThread("Sonu");

      T1.start();
      T2.start();

      System.out.println("Main thread finished starting other threads");
    }
}
