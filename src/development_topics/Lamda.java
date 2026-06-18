package development_topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lamda {
    public static void main(String[] args) {
//        functional_interface sum  = (a,b)->a-b;
//        System.out.println(sum.operator(1,7));
//        Interface hey = ()-> System.out.println("hello");
//        hey.sayHello();
        List<String> list = new ArrayList<>(Arrays.asList("prateek","ratnesh","Aman","vikash","rahul"));
        predicate check = (str)->str.charAt(0)=='A';

        for (int i = 0; i<list.size();i++){
            String str1 = list.get(i);
            System.out.println(check.predicate(str1));
        }
//        Collections.sort(list,(s1, s2)->s1.charAt(0)-s2.charAt(0));
//        System.out.println(list);
//        Collections.sort(list,(s1,s2)->s1.length()-s2.length());
//        System.out.println(list);
//


    }
}
@FunctionalInterface
interface Interface{
    public void sayHello();
}
@FunctionalInterface
interface predicate{
    public boolean predicate(String str);
}
