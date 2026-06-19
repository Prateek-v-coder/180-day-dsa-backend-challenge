package development_topics;

public class Generics {
    public static void main(String[] args) {
        Box<Integer,String> b = new Box<>();
        b.set(1,"prateek");
        b.set(2,"ratnesh");
        System.out.println(b.getKey());
        System.out.println(b.getValue());
        Demo d = new Demo();
        d.print(101.1);
        student s = new student("prateek",22);
        Checker<student> C = new Checker<>(s);
        C.print();
        Calculater<Number> c = new Calculater<>(100.10);
        System.out.println( c.square());
        System.out.println(d.number("prateek"));
        Container<Integer> co = (value)->System.out.println(value);
        co.print(15);


    }
}
@FunctionalInterface
interface Container<T>{
    void print(T value);
}
class Box<K,V>{
    private K key;
    private V value;
    public void set(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
class Demo{
    public <T> void print(T value){
        System.out.println(value);
    }
    public <T> T number(T value){
        return value;
    }
}
class student{
    private String name;
    private int age;
    student(String name , int age){
        this.name=name;
        this.age=age;
    }
    public void print(){
        System.out.println(name);
        System.out.println(age);
    }
}
class Checker<T extends student>{
    private T value;
    Checker(T value){
        this.value=value;
    }
    public void print(){
        value.print();
    }
}
class Calculater<T extends Number>{
    private T value;
    Calculater(T value){
        this.value=value;
    }
    public double square(){
        return value.doubleValue()* value.doubleValue();
    }
}
