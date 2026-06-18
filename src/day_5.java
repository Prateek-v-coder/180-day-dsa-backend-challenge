import java.util.Arrays;

public class day_5 {
    public static void main(String[] args) {
     //  Dog dog = new Dog();
//        Puppy puppy = new Puppy(10);
//       puppy.setName("tommy");
//       puppy.setAge(3);
//        System.out.println(puppy.getName());
//        System.out.println(puppy.getAge());
//        puppy.eat();
//       // puppy.make_sound();
//        puppy.skin_color();
        Sliding_window window = new Sliding_window();
        int[] arr = {0,0,0,0};
        String str = "abcabcbb";
        //System.out.println(window.maxSumSubArray(arr,3));
        //System.out.println(Arrays.toString(window.avgSubArray(arr,3)));
        //System.out.println(window.smallestSubArray(arr,7));
       // System.out.println(window.maximumOnc(arr,2));
        //System.out.println(window.longestSubstring(str));
        //System.out.println(Arrays.toString(window.findSum(arr,6)));
     //   System.out.println(window.findSunArraySum(arr,0));
       // System.out.println(window.secondMin(arr));
        window.threeSum(arr,0);
    }
}

// Inheritance
class Animal{
    public Animal(int a){
        System.out.println("Animal constructor "+a);
    }
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            System.out.println("invalid age");
            return;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println("animal eat food");
    }
    public void make_sound(){
        System.out.println("animal sound");
    }
}
class Dog extends Animal{
    public Dog(int a){
        super(a);
        System.out.println("Dog constructor");
    }
    @Override
    public void eat(){
        System.out.println("Dog eat food");
    }
    @Override
    public void make_sound(){
        System.out.println("dog barks");
    }
    public void skin_color(){
        System.out.println("skin color is brown");
    }
}
class Puppy extends Dog{
    public Puppy(int a){
        super(a);
        System.out.println("puppy constructor");
    }
    @Override
    public void skin_color(){

        System.out.println("black");
        super.make_sound();
    }
}
class Sliding_window{
   // Problem 1 — Maximum Sum Subarray of Size K
    public int maxSumSubArray(int[] arr, int k){
        int start=0;
        int end = k-1;
        int sum = 0;
        for (int i = start; i<=end; i++){
            sum+=arr[i];
        }
        int max_sum = sum;
        for (int j = end+1; j<arr.length; j++){
            start++;
            sum=sum+arr[j]-arr[start-1];
            max_sum = Math.max(max_sum,sum);
        }
        return max_sum;
    }

    //Problem 2 — Average of SubArrays of Size K

    public double[] avgSubArray(int[] arr, int k){
        double[] avg_sum_arr = new double[arr.length-k+1];
        int index = 0;
        double sum = 0;
        for (int i = 0; i<=k-1; i++){
            sum+=arr[i];
        }
        avg_sum_arr[index++]=sum/k;
        for (int j = k; j<arr.length; j++){
            sum = sum+arr[j]-arr[j-k];
            avg_sum_arr[index++] = sum/k;
        }
        return avg_sum_arr;
    }

    // Problem 3 — Smallest Subarray With Sum >= K

    public int smallestSubArray(int[] arr, int k){
        int sum = 0;
        int windowLength = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right<arr.length; right++){
            sum = sum+arr[right];
            while (sum>=k){
                windowLength = right-left+1;
                minLength = Math.min(minLength,windowLength);
                sum-=arr[left];
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    // Problem 4 — Maximum Ones After Replacing K Zeros
    public int maximumOnc(int[] arr,int k){
        int max_length = 0;
        int zero_count = 0;
        int left = 0;
        for (int right = 0; right<arr.length; right++){
            if (arr[right]==0){
                zero_count++;

            }
            while (zero_count>k){
                if (arr[left]==0){
                    zero_count--;
                }
                    left++;
            }
            max_length = Math.max(max_length,right-left+1);
        }
        return max_length;
    }

    // Problem 5 — Longest Substring Without Repeating Characters

    public int longestSubstring(String str){
        boolean[] present = new boolean[256];
        int max_length = 0;
        int left = 0;
        for (int right =0; right<str.length(); right++){
            char currChar = str.charAt(right);
            while (present[currChar]){
                present[str.charAt(left)] =false;
                left++;
            }
            present[currChar] = true;
            max_length = Math.max(max_length,right-left+1);
        }
        return max_length;
    }
    /*
    4 Revision Problems
Revision 1 — Two Pointer (Day 4)
     */

    public int[] findSum(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int sum = 0;
        while (left<right){
            sum = arr[left]+arr[right];
            if (sum==target){
                return new int[]{left,right};
            }
            if (sum<target){
                left++;
            }else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }

    // Revision 2 — Two Pointer (Day 4) three sum
    public void threeSum(int[] arr, int target) {
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i+1;
            int right = arr.length - 1;
            while (left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    System.out.print("["+arr[i] +","+arr[left]+","+arr[right]+"] ,");
                    left++;
                    right--;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    // Revision 3 —
    public boolean findSunArraySum(int[] arr, int target){
        for (int i =0; i<arr.length; i++){
            int sum = 0;
            for (int j =i; j<arr.length; j++){
                sum+=arr[j];
                if (sum>target){
                    break;
                }
                if (sum==target){
                    return true;
                }
            }
        }
        return false;
    }

    // Revision 4 — Arrays (Day 2)
    public int secondMin(int[] arr){
        int min = arr[0];
        int second_min = Integer.MAX_VALUE;
        for (int i = 0; i<arr.length; i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        for (int i = 0; i<arr.length; i++){
            if (arr[i]!=min&&arr[i]<second_min){
                    second_min=arr[i];
            }
        }
        return second_min;
    }
}
