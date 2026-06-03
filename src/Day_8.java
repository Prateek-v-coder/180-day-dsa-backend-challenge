import java.util.Arrays;

public class Day_8 {
    public static void main(String[] args) {
        Fibo f  = new Fibo();
//      int fact =  f.factorial(0);
//        System.out.println(fact);
        //System.out.println(f.sumDigit(1234));
       // System.out.println(f.powerOfX(2,3));
        int[] arr ={1,2,3,4,6};
//        System.out.println(f.isSort(arr,0));
       // System.out.println(f.allOccurrence(arr,0,2,0));
      //  System.out.println(f.maxSubArray(arr));
//        System.out.println(f.kDistinctChar("eceeeccba",2));
        System.out.println(Arrays.toString(f.twoSum(arr,9)));

    }

}
class Fibo{
    public int factorial(int n){
        if (n==0){
            return 1;
        }
        return n * factorial(n-1);
    }
    public int sumDigit(int n){
        if (n==0){
            return n;
        }
       return (n%10)+sumDigit(n/10);
    }
    public int powerOfX(int x,int n){
        if (n==0){
            return 1;
        }
        return x*powerOfX(x,n-1);
    }
    public boolean isSort(int[] arr,int i){
        if (i==arr.length-1){
            return true;
        }
       if (arr[i]>arr[i+1]){
           return false;
       }
       return isSort(arr,i+1);
    }
    public int allOccurrence(int[] arr,int i, int target,int count){
        if (i==arr.length){
            return count;
        }
        if (arr[i]==target){
            count++;
        }
        return allOccurrence(arr,i+1,target,count);
    }

    // Revision 1 — Kadane's
    public int maxSubArray(int[] arr){
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i =0; i<arr.length; i++){
            if (sum<0){
                sum=0;
            }
            sum+=arr[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    // Revision 2 — Sliding Window
    public int kDistinctChar(String str, int k){
        int[] freq = new int[26];
        int distinct = 0;
        int maxLen = 0;
        int left = 0;
        for (int i =0; i<str.length(); i++){
            freq[str.charAt(i)-'a']++;
            if (freq[str.charAt(i)-'a']==1) distinct++;
            while (distinct>k){
                freq[str.charAt(left)-'a']--;
                if (freq[str.charAt(left)-'a']==0) distinct--;
                left++;
            }
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    // Revision 3 — Two Pointer
    public int[] twoSum(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            if (arr[left]+arr[right]==target){
                return new int[]{left,right};
            } else if (arr[left]+arr[right]<target){
                left++;
            }else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }
}
