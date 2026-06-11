import java.lang.management.MemoryType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class day_15{
    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
       // System.out.println(avarageSum(arr,3));
      //  System.out.println(minSizeSubArray(arr,11));
        //System.out.println(longestSubstring("abcabcbb"));
       // System.out.println(permutationSubs("ab","eidbaooo"));
       // System.out.println(fruitsInBasket(arr));
       // System.out.println(pivot(arr));
       // System.out.println(Arrays.toString(twoSum(arr,9)));
        System.out.println(validParen("{}()[]]"));

    }
    public static float avarageSum(int[] arr,int k){
        float sum = 0;
        for (int i=0; i<k; i++){
            sum+=arr[i];
        }
        float max = sum;
        for (int i=k; i<arr.length; i++){
            sum=sum+arr[i]-arr[i-k];
            max= Math.max(sum,max);
        }
        return max/k;
    }
    public static int minSizeSubArray(int[] arr, int target){
        int sum = 0;
        int minsize =Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i<arr.length; i++){
            sum+=arr[i];
            while (sum>=target){
                minsize= Math.min(minsize,i-left+1);
                sum-=arr[left];
                left++;
            }
        }
        if (minsize==Integer.MAX_VALUE){
            return 0;
        }else {
            return minsize;
        }
    }
    public static int longestSubstring(String str){
        HashSet<Character> set = new HashSet<>();
        int longestSubs = 0;
        int left = 0;
        for (int  i=0; i<str.length(); i++){
           while(set.contains(str.charAt(i))){
               set.remove(str.charAt(left));
               left++;
           }
           set.add(str.charAt(i));
           longestSubs= Math.max(longestSubs,i-left+1);
        }
        return longestSubs;
    }
    public static boolean permutationSubs(String s1,String s2){
        if (s1.length()>s2.length()){
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i =0;i<s1.length(); i++){
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(map1,map2)){
            return true;
        }
        for (int i = s1.length(); i<s2.length(); i++){
            map2[s2.charAt(i)-'a']++;
            map2[s2.charAt(i-s1.length())-'a']--;
            if (Arrays.equals(map1,map2)){
                return true;
            }
        }
        return false;
    }
    public static int fruitsInBasket(int[] arr){
        int[] count = new int[arr.length];
        int types = 0;
        int left = 0;
        int maxFruits = 0;
        for (int right = 0; right<arr.length; right++){
         count[arr[right]]++;
         if (count[arr[right]]==1){
             types++;
         }
            while (types>2){
               count[arr[right]]--;
               if (count[arr[right]]==0){
                   types--;
               }
                left++;
            }
            maxFruits=Math.max(maxFruits,right-left+1);
        }
        return maxFruits;
    }
    public static int pivot(int[] arr){
        int [] prefix = new int[arr.length];
        prefix[0]=arr[0];
        for (int i = 1; i<arr.length; i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for (int i = 0;i<arr.length; i++){
            int left = (i==0) ? 0 :prefix[i-1];
            if (left==prefix[prefix.length-1]-prefix[i]){
                return i;
            }
        }
        return -1;
    }
    public static int[] twoSum(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<arr.length; i++){
            map.put(arr[i],i);
        }
        for (int i =0; i<arr.length; i++){
            if (map.containsKey(target-arr[i])){
                return new int[]{i,map.get(target-arr[i])};
            }
        }
        return new int[] {-1,-1};
    }
    public static boolean validParen(String str){
        Stack<Character> stack = new Stack<>();
        for (int i =0; i<str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (str.charAt(i) == ')' && top != '(') return false;
                if (str.charAt(i) == '}' && top != '{') return false;
                if (str.charAt(i) == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
