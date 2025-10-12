
// Without executor --> Manual Handling

package ExecutorFramework;

public class Main {
    
    public static long factorial(int n){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result = 1;

        for(int i = n; i > 0; i--){
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[9];
        for(int i = 1; i < 10; i++){

            final int num = i;
            threads[i - 1] = new Thread(
                () -> {
                    long result = factorial(num);
                    System.out.println(result);
                }
            );

            threads[i - 1].start();
        }

        for(Thread thread: threads){
            thread.join();
        }

        System.out.println("Total Time: "+ (System.currentTimeMillis() - startTime));
    }
}
