package development_topics;

import java.util.Arrays;
import java.util.*;
import java.util.List;

public class Comparator_day_22 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(8,9,2,4,5,6,1,3,7);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        System.out.println(list);
//        Collections.sort(list,(A,B)->A-B);
//        System.out.println(list);
//        Collections.sort(list,(a,b)->b-a);
//        System.out.println(list);
        List<String> list = new ArrayList<>(Arrays.asList("prateek","ratnesh","aman","vikash","rahul"));
        Collections.sort(list,(s1,s2)->s1.charAt(0)-s2.charAt(0));
        System.out.println(list);
    }
}
