package dsa_problems;

public class day_28 {
    public static void main(String[] args) {
        int[] arr = {1,4,6,9,10,15,26,53};
        System.out.println(binary_search(arr,8));
        System.out.println("first occurrence "+firstOccurrence(arr,10));
        System.out.println("last occurrence "+lastOccurrence(arr,10));
    }
    public static int binary_search(int[] arr, int target){
        int str = 0;
        int end = arr.length-1;
        while(str<=end){
            int mid = str+(end-str)/2;
            if (target==arr[mid]){
                return mid;
            } else if (target<arr[mid]) {
                end = mid-1;
            }else {
                str = mid+1;
            }
        }
        return -1;
    }
    public static int firstOccurrence(int[] arr, int target){
        int str = 0;
        int end = arr.length-1;
        int ans = -1;
        while(str<=end){
            int mid = str+(end-str)/2;
            if(arr[mid]==target){
                ans = mid;
                end = mid-1;
            } else if (arr[mid]<target) {
                str = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static int lastOccurrence(int[] arr, int target){
        int str = 0;
        int end = arr.length-1;
        int ans = -1;
        while (str<=end){
            int mid  = str +(end-str)/2;
            if (arr[mid]==target){
                ans=mid;
                str = mid+1;
            } else if (arr[mid]<target) {
                str = mid+1;
            }else {
                end = mid-1;
            }
        }
        return ans;
    }
    public static int searchInsertPos(int[] arr, int target){
        int str = 0;
        int end = arr.length-1;
        while(str<=end){
            int mid = str+(end-str)/2;
            if (target==arr[mid]){
                return mid;
            } else if (target<arr[mid]) {
                end = mid-1;
            }else {
                str = mid+1;
            }
        }
        return str;
    }
    public int findMinimumRotatedArray(int[] arr){
        int str = 0;
        int end = arr.length-1;
        while(str<end){
            int mid = str+(end-str)/2;
           if (arr[mid]>arr[end]){
               str = mid+1;
           }else{
               end = mid;
           }
        }
        return str;
    }
}
