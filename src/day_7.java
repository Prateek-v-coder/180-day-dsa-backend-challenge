import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class day_7 {
    public static void main(String[] args) {
        kadane_algo kd = new kadane_algo();
        int[] arr = {-1, 0, 1, 2, -1, -4};
       // System.out.println(kd.maxSubArraySum(arr));
        //System.out.println(Arrays.toString(kd.adjacentMax(arr)));
      //  System.out.println(kd.prefixSum(arr));
//       kd.threeSum(arr,0);
        TextAnalyser txt = new TextAnalyser("hello world");
        System.out.println(txt.countWord());
        System.out.println(txt.countVowels());
        System.out.println(txt.isPalindrome());
        System.out.println(txt.mostFreChar());



    }
    }
// KADANE'S ALGORITHM
class kadane_algo{
    public int maxSubArraySum(int[] arr){
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i<arr.length; i++){
            sum+=arr[i];
            maxSum = Math.max(maxSum,sum);
            if (sum<0){
                sum = 0;
            }
        }
        return maxSum;
    }
    //  Problem 1 — Arrays
    public int[] adjacentMax(int[] arr){
        int[] adjacentAx = new int[arr.length];
        int ind = 0;
        for (int i= 0; i<arr.length; i++){
           if (i==0) {
               if (arr[i] > arr[i + 1]) {
                   adjacentAx[ind++] = arr[i];
               }
           }else if (i==arr.length-1) {
                   if (arr[i]>arr[i-1]){
                       adjacentAx[ind++] = arr[i];
                   }
               }else {
               if (arr[i]>arr[i+1]&&arr[i]>arr[i-1]){
                   adjacentAx[ind++]=arr[i];
               }
           }
        }
        return adjacentAx;
    }

    // Problem 2 — Prefix Sum (Easy)
    public int prefixSum(int[] arr){
        int maxSum = 0;
        int oddSum = 0;
        int evenSum = 0;
        for(int i =0; i<arr.length; i++){
            if (i%2==0){
                evenSum+=arr[i];
            }else {
                oddSum+=arr[i];
            }
        }
        maxSum = Math.max(oddSum,evenSum);
        return maxSum;
    }

    // Problem 3 — Two Pointer
    public void threeSum(int[] arr,int target){
        Arrays.sort(arr);
        for (int i =0; i<arr.length; i++){
            int left =i+1;
            int right = arr.length-1;
            while (left<right){
                if ((arr[i]+arr[left]+arr[right])==target){
                    System.out.print("["+arr[i] +","+arr[left]+","+arr[right]+"] ,");
                    left++;
                    right--;

                } else if ((arr[i]+arr[left]+arr[right])<target) {

                    left++;
                }else {
                    right--;
                }
            }
        }

    }

    // Problem 4 — Sliding Window
    public int KDistinct(String str,int k){
        int[] distinct = new int[26];
        int distinctCh = 0;
        int maxLen = 0;
        int left = 0;
       for (int right= 0; right<str.length(); right++){
           char rc = str.charAt(right);
           distinct[rc-'a']++;
           if (distinct[rc-'a']==1){
               distinctCh++;
           }
           while (distinctCh>k){
               char lc = str.charAt(left);
               distinct[lc-'a']--;
               if (distinct[lc-'a']==0) distinctCh--;
               left++;
           }
           maxLen = Math.max(maxLen,right-left+1);
       }
       return maxLen;
    }

    // Problem 5 — Kadane's  algo
    public int maxSum(int[] arr){
        int maxSum = arr[0];
        int sum = arr[0]+arr[1];
        for (int  i =0; i<arr.length; i++){
            if (sum<0)sum = arr[i-1]+arr[i];
            else sum+=arr[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
class TextAnalyser{
    String str;
    TextAnalyser(String str){
        this.str=str;
    }
    public int countWord(){
        int count = 0;
        String[] newS = str.split(" ");
        for (int i =0; i<newS.length; i++){
            count++;
        }
        return count;
    }
    public int countVowels(){
        int count = 0;
        for (int  i =0; i<str.length(); i++){
            if (str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='i'){
                count++;
            }
        }
        return count;
    }
    public boolean isPalindrome(){
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            while(left<right&&!Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }
            while(left<right&&!Character.isLetterOrDigit(str.charAt(right))){
                right--;
            }
            if (str.charAt(left)!=str.charAt(right)){
                return false;
            }
        }
        return true;
    }
    public char mostFreChar(){
        int[] freq = new int[26];
        int Maxfreq = 0;
        int index = 0;
        for (int i =0; i<str.length(); i++){
            if (str.charAt(i)==' ') continue;
            freq[str.charAt(i)-'a']++;
        }
        for (int i =0; i<freq.length; i++){
            if (freq[i]>Maxfreq){
                Maxfreq = freq[i];
                index = i;
            }
        }
        return (char) (index+'a');
    }
}
