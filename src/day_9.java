import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class day_9 {
    public static void main(String[] args) {
    Collections ct = new Collections();
    //ct.arraylist();
       // ct.hashmap();
       // ct.hashset();
       // ct.frequencyCounter("aaabbbsssdeds");
        int[] arr = {1,2,3};
       // ct.arrayFrequency(arr);
       // ct.removeDuplicate(arr);
       // System.out.println(ct.containsDuplicate(arr));
        System.out.println(ct.validAnagram("abc","baca"));
    }
}
class Collections{
    public void arraylist(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        for (int i:list){
            System.out.print(i+" ");
        }
        System.out.println();
//        list.add(4,6);
//        for (int i:list){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        System.out.println(list.get(2));
        list.set(1,3);
        for (int i:list){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(list.contains(10));
        System.out.println(list.size());
        System.out.println(list.indexOf(5));
        System.out.println(list.isEmpty());
    }
    public void hashmap(){
        HashMap <Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(2,0);
        map.put(3,2);
        map.put(4,0);
        map.put(5,0);
        map.put(3,map.get(3)-1);
        System.out.println(map);
//        for (Map.Entry<Integer,String> e :map.entrySet()){
//            System.out.println(e.getValue());
//        }
//        System.out.println(map);
//        System.out.println(map.containsKey(10));
//        map.remove(2);
//        System.out.println(map);
//        System.out.println(map.remove(1,"prateek"));
//        System.out.println(map);
//        System.out.println(map.size());

    }
    public void hashset(){
        HashSet <Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
        System.out.println(set.remove(10));
        System.out.println(set);
        System.out.println(set.contains(10));
        System.out.println(set.isEmpty());
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public void frequencyCounter(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currCHar = str.charAt(i);
            map.put(currCHar,map.getOrDefault(currCHar,0)+1);
        }
        System.out.println(map);
    }
    public void arrayFrequency(int[] arr){
        HashMap <Integer,Integer> map = new HashMap<>();
        for (int i =0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map);
    }
    public void removeDuplicate(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int i =0; i<arr.length; i++){
            set.add(arr[i]);
        }
        System.out.println(set);
    }
    public boolean containsDuplicate(int[] arr){
        HashSet <Integer> set = new HashSet<>();
        for (int i =0; i<arr.length; i++){
            boolean contains = set.add(arr[i]);
            if (!contains){
                return true;
            }
        }
        return false;
    }
    public boolean validAnagram(String str, String s){
        HashMap<Character,Integer> map = new HashMap<>();
        if (str.length()!=s.length()){
            return false;
        }
        for (int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
        }
        for (Integer m:map.values()){
            if (m!=0){
                return false;
            }
        }
        return true;
    }
}