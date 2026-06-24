package development_topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Method_reference {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("prateek","vikash","shubham"));
        list.forEach(Method_reference::print);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(-1,2,-3,4));
        list1.stream().map(Math::abs).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("1","2","3"));
        List<Integer> collect = list2.stream().map(Integer::new).collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void print(String str){
        System.out.println(str);
    }
}
