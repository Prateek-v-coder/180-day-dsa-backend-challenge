package development_topics.Design_pattern;

public class Singleton {
    private static Singleton instance;
    private Singleton(){};
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
    public void showMessage(){
        System.out.println("Singleton instance "+ this.hashCode());
    }
}
class Test{
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);
        s1.showMessage();
        s2.showMessage();
    }

}
