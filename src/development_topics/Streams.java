package development_topics;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = asList(1,1,2,3,6,8,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
       Stream<Integer> value = list.stream()
                .filter(n->n/2==4).map(n->n*2).sorted((a,b)->b-a);
       value.forEach(System.out::println);
        Stream<Integer> skip = list.stream().distinct().sorted((a, b) -> a - b).limit(10).skip(4);
        long count = list.stream().filter(n->n%2==0)
                .count();
      Optional<Integer> min = list.stream()
               .max(Integer::compareTo);
        System.out.println(min);
        List<String> words = Arrays.asList(
                "apple", "banana", "kiwi", "mango", "fig"
        );
        words.stream()
                .filter(n->n.length()==5).forEach(System.out::println);
        words.stream()
                .map(n->n.toUpperCase()).forEach(System.out::println);
        Optional<String> max = words.stream()
                .max(String::compareTo);
        System.out.println(max);
        List<Integer> nums = Arrays.asList();
        Stream<Integer> value1 = nums.stream().filter(n->n>10).sorted();
        value1.forEach(n-> System.out.print(n+" "));
        Optional<Integer> max1 = nums.stream()
                .max(Integer::compareTo);
        System.out.println(max1.orElse(-1));

    }
    }

