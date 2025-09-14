package Synchronization;

public class Counter {
    
    private int count = 0;

    public void increment(){  //public synchronized void increment , this makes the whole method synchronized
        
        synchronized(this){
            count++;                  // way to achieve synchronization in only the block, here 'this' refers we are talking about one instance
        }
        
    }

    public int getCount(){
        return count;
    }
}
