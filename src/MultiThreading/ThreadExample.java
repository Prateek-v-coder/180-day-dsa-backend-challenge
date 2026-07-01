package MultiThreading;

public class ThreadExample {
    public static void main(String[] args) {
//       Thread t = new Thread(()-> {
//          for (int i =0; i<10; i++){
//              System.out.println(Thread.currentThread().getName()+" "+ i);
//          }
//       });
//        Thread t2 = new Thread(()-> {
//            for (int i =0; i<10; i++){
//                System.out.println(Thread.currentThread().getName()+" "+ i*2);
//            }
//        });
//       t2.start();
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        t.start();
        Counter counter = new Counter();
        Thread1 t1 = new Thread1(counter);
        Thread2 t2 = new Thread2(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter.getCount();

    }

    }
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
class Counter{
    private int count = 0;
    public void increment(){
        count++;
    }
    public void getCount(){
        System.out.println(count);
    }
}
class Thread1 extends Thread{
    private Counter counter;
    public Thread1(Counter counter){
        this.counter=counter;
    }

    @Override
   public void run(){
        for (int i =0; i<1000; i++){
            counter.increment();
        }

    }
}
class Thread2 extends Thread{
    private Counter counter;
    public Thread2(Counter counter){
        this.counter=counter;
    }

    @Override
   public void run(){
        for (int i =0; i<1000; i++){
            counter.increment();
        }

    }
}
