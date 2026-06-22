package development_topics;
import java.util.TreeMap;
import java.util.TreeSet;
public class Tree_Map {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1,"prateek");
        map.put(3,"ratnesh");
        map.put(2,"vikash");
        System.out.println(map);
        System.out.println(map.get(2));
        System.out.println(map.ceilingEntry(2));
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        System.out.println(set);
        System.out.println(set.clone());

    }
}
