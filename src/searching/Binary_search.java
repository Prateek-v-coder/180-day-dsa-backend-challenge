package searching;

import java.util.Arrays;

public class Binary_search {
    public static void main(String[] args) {
        int [] arr = {2,3,8,8,8,8,8,8,9,10};
       // System.out.println(binary_search(arr,10));
        int firstOcc = firstOccurrence(arr,8);
        int lastOcc = lastOccurrence(arr,8);
        int[] firstAndLastOcc = {firstOcc,lastOcc};
        System.out.println(Arrays.toString(firstAndLastOcc));
        int countOccurrence = (firstOcc==-1)? 0: lastOcc-firstOcc+1;
        System.out.println(countOccurrence);
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
    // variants...
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
}
