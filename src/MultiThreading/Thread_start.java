package MultiThreading;

public class Thread_start {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 thread1 = new MyThread1();
       Thread thread2 = new Thread(new MyThread2(thread1));
        thread1.setName("first thread");
        thread2.setName("second thread");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main end");
    }

}
class MyThread1 extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i<5; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
class MyThread2 implements Runnable{
    private Thread thread1;
    public MyThread2(Thread thread1){
        this.thread1=thread1;
    }
    @Override
    public void run() {
        try {
            thread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("second thread");

    }
}
