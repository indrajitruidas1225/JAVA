package CountDownLatch;
import java.util.concurrent.*;
public class Example {
    

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        Future<String> future1 = executorService.submit(new DependentService(latch));
        Future<String> future2 = executorService.submit(new DependentService(latch));
        Future<String> future3 = executorService.submit(new DependentService(latch));
        latch.await();
       
        System.out.println("Main");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String>{

    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        
        try {
            System.out.println(Thread.currentThread().getName() + " service started. ");
            Thread.sleep(2000);   
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}
