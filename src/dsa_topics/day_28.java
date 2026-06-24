package dsa_topics;
public class day_28 {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.print();
        System.out.println();
        list.add(2,20);
        list.print();
    }

}
