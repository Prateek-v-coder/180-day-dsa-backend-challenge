package development_topics;
@FunctionalInterface
public interface functional_interface {
    public int operator(int a ,int b);

    public static void main(String[] args) {
        functional_interface sum = (a,b)->a+b;
        System.out.println(sum.operator(7,8));
    }
}
