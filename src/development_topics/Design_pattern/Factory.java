package development_topics.Design_pattern;

public class Factory {
    public static void main(String[] args) {
        Animal a = ObjectFactory.getInstance("dog");
        assert a != null;
        a.speak();
        Animal a1 = ObjectFactory.getInstance("cat");
        assert a1 != null;
        a1.speak();
    }
}
interface Animal{
    public void speak();
}
class Dog implements Animal{
    @Override
    public void speak(){
        System.out.println("woof....");
    }
}
class Cat implements Animal{
    @Override
    public void speak(){
        System.out.println("meow.....");
    }
}
class ObjectFactory{
    public static Animal getInstance(String type){
        if(type.equalsIgnoreCase("dog")) return null;
        if(type.equalsIgnoreCase("cat")) return new Cat();
        else return null;
    }
}
