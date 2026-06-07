import java.util.HashMap;
import java.util.LinkedList;

public class day_11{
    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.insertion();
        //list.deletion();
      //  list.accessing();
       // list.searching();
//        list.traversal();
//        System.out.println(list.largestElement(new int[]{8}));
       // System.out.println(list.validAnagram("",""));
        System.out.println(list.maxSumSubArrSizeK(new int[]{1,2,3},5));
    }
}
class linkedList{
    LinkedList<Integer> list = new LinkedList<>();
    public void insertion(){
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(40);
        list.addLast(50);
        list.add(2,10);
    }
    public void deletion(){
        list.remove();
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
    public void accessing(){
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));

    }
    public void searching(){
        System.out.println(list.contains(10));
        System.out.println(list.contains(100));
        System.out.println(list.indexOf(10));
        System.out.println(list.lastIndexOf(10));
        list.set(3,10);
        System.out.println(list);
    }
    public void traversal(){
        for (int i:list){
            System.out.print(i+"->");
        }
        System.out.println("null");
//        for (Integer i:list){
//            System.out.println(i);
//        }
        for (int i =0; i<list.size(); i++){
            System.out.print(list.get(i)+"->");
        }
        System.out.println("null");

    }
    // revision problems
    public int largestElement(int[] arr){
        if (arr.length==0){
            throw new IllegalArgumentException("array is empty");
        }
        int largest =arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }
    public boolean validAnagram(String s, String str){
        HashMap<Character,Integer> map = new HashMap<>();
        if (s.length()!=str.length()){
            return false;
        }
        for (int i =0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)-1);
        }
        for (int value:map.values()){
            if (value!=0){
                return false;
            }
        }
        return true;
    }
    public int maxSumSubArrSizeK(int[] arr, int k){
        if (arr.length==0||arr.length<k){
            throw new IllegalArgumentException("invalid input");
        }
        int maxSum = 0;
        int sum =0;
        for (int i =0; i<k; i++){
            sum+=arr[i];
        }
        maxSum=sum;
        for (int i =k; i<arr.length; i++){
            sum=sum+arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public int factorial(int n){
        if (n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
