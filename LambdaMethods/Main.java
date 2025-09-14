package LambdaMethods;

public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        MyThread t1 = new MyThread("Indra", c);
        MyThread t2 = new MyThread("Runu", c);
        MyThread t3 = new MyThread("Intu", c);
        // t1.setPriority(Thread.MIN_PRIORITY);
        // t2.setPriority(Thread.NORM_PRIORITY);
        // t3.setPriority(Thread.MAX_PRIORITY);

        t1.setDaemon(true);
        t1.start();
        // t2.start();
        // t3.start();
        // t2.interrupt();
        // t3.interrupt();

        // try {
        //     t1.join();
        //     t2.join();
        //     t3.join();
        //     System.out.println(c.getCount());
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" done");
        System.out.println(c.getCount());
    }
}
