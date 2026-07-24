package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor_Framework {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i<=5; i++){
            final int task = i;
            executor.execute(()->{
                System.out.println("taks "+task+" running on "+
                        Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                System.out.println("task "+task + " completed");
            });
        }
        executor.shutdown();
    }
}
