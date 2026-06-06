import java.util.*;

public class day_10 {
    public static void main(String[] args) {
         DSATask task = new DSATask();
         //task.arraylist();
         //task.hashset();
       // task.hashmap();
       // task.frequencyCounter(new int[]{1,2,3,4,1,2,4,5,6});
        int[] nums1 = {2, 1, 5, 1, 3, 2};
        int[] nums2 = {1,2,8,9,6};
      //  System.out.println(Arrays.toString(task.intersection(nums1,nums2)));
      // System.out.println(task.occurrence(nums1));
       // System.out.println(task.firstUniqueChar("leetcode"));
       // System.out.println(Arrays.toString(task.twoSum(nums1,6)));
      //  System.out.println(task.secondLargets(nums2));
       // System.out.println(task.maxSubArrSum(nums1,3));
        System.out.println(task.sumOfDigit(1234));

    }
}class DSATask {
    public void arraylist() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
//       for (int i =0; i<list.size(); i++){
//           System.out.print(list.get(i)+" ");
//       }
        //  System.out.println(list.get(2));
        System.out.println(list);
        list.set(1, 40);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.contains(50));
        System.out.println(list.contains(80));
        System.out.println(list.size());

    }

    public void hashset() {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.add(4));
        System.out.println(set.add(1));
        System.out.println(set.add(4));
        System.out.println(set.add(3));
    }

    public void hashmap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("prateek", 1);
        map.put("rahul", 2);
        map.put("aman", 3);
        map.put("ratnesh", 4);
        System.out.println(map.containsKey("ratnesh"));
//        for (HashMap.Entry<String,Integer> m :map.entrySet()){
//            System.out.print(m);
//        }
//        for (int value:map.values()){
//            System.out.print(value+" ");
//        }
       // System.out.println(map.get("aman"));

//        for (String s:map.keySet()){
//            System.out.println(s);
//        }
    }
        public void frequencyCounter ( int[] arr){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            System.out.println(map);
        }
        public int[] intersection ( int[] nums1, int[] nums2){
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> result = new HashSet<>();
            for (int num : nums1) {
                set.add(num);
            }
            for (int num : nums2) {
                if (set.contains(num)) {
                    result.add(num);
                }
            }
            int[] ans = new int[result.size()];
            int index = 0;
            for (int num : result) {
                ans[index++] = num;
            }
            return ans;
        }
        public boolean occurrence ( int[] arr){
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (int value : map.values()) {
                if (!set.add(value)) {
                    return false;
                }
            }

            return true;
        }
    public int firstUniqueChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i =0; i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for (int i =0; i<str.length(); i++){
           if(map.get(str.charAt(i))==1){
               return i;
           }

        }
        return -1;
    }
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int freq = (nums.length/2)+1;
        for (int i:nums){
            if (map.get(i)>=freq){
                return i;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<arr.length; i++){
            int complement = target-arr[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }
    public int secondLargets(int[] arr){
        int max = arr[0];
        int secMax = Integer.MIN_VALUE;
        for (int i =0; i<arr.length; i++){
          max = Math.max(max,arr[i]);
        }
        for (int i =0; i<arr.length; i++){
            if (arr[i]!=max){
               secMax = Math.max(secMax,arr[i]);
            }
        }
        return secMax;
    }
    public int maxSubArrSum(int[] arr, int k){
        int max =0;
        int left = 0;
        int sum =0;
        for (int i = 0; i<k; i++){
            sum+=arr[i];
        }
        max=sum;
        for (int i =k; i<arr.length; i++){
            left++;
            sum=sum+arr[i]-arr[i-k];
            max = Math.max(max,sum);
        }
        return max;
    }
    public int sumOfDigit(int n){
        if (n==0){
            return n;
        }
        return (n%10)+sumOfDigit(n/10);
    }

}
