package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Callable_Future_Demo {
   public static void callable_demo() throws ExecutionException, InterruptedException {
       ExecutorService service = Executors.newFixedThreadPool(3);
       List<Future<String>> futures = new ArrayList<>();
       for (int i = 0; i<=5; i++){
           final int task = i;
           Callable<String> c = ()->{
               Thread.sleep(1000);
               return "Hello from "+ Thread.currentThread().getName();
           };
           Future<String> future = service.submit(c);
           futures.add(future);
       }
       for (Future<String> i:futures){
           System.out.println("Result "+i.get());

       }
       service.shutdown();
   }

    public static void main(String[] args) {
        try{
            callable_demo();
        }catch (Exception e){}
    }


}
