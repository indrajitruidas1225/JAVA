package LambdaMethods;

public class Daemon extends Thread{

    @Override
    public void run(){
        while(true){
            System.out.println("Hello world");
        }
    }
    public static void main(String[] args) {
        Daemon t1 = new Daemon();
        t1.setDaemon(true);
        t1.start();
        
        System.out.println("Main finished");
    }
}
