package development_topics.Design_pattern;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton Instance;
    private ThreadSafeSingleton(){};
    public static ThreadSafeSingleton getInstance(){
        if(Instance==null){
            synchronized(ThreadSafeSingleton.class){
                if(Instance==null){
                    Instance = new ThreadSafeSingleton();
                }
            }
        }
        return Instance;
    }
    public void showMessage(){
        System.out.println("ThreadSafeSingleton Instance "+this.hashCode());
    }
}
class Test1{
    public static void main(String[] args) {
        ThreadSafeSingleton t1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton t2 = ThreadSafeSingleton.getInstance();
        System.out.println(t1==t1);
        t1.showMessage();
        t2.showMessage();


    }
}
