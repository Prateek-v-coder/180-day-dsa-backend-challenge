package dsa_problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Day_30 {
    public static void main(String[] args) {
        //  int[] arr = {2,3,1,2,4,3};
        //System.out.println(minimumSubArraySum(arr,7));
//        int[][] arr = {{1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}};
//        System.out.println(Arrays.toString(search_int_2dArray(arr,16)));
        int[][] arr = {{1,3},{-2,2}};
        System.out.println(Arrays.deepToString(kClosest(arr,1)));
    }
    public static int minimumSubArraySum(int[] arr,int target){
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right<arr.length; right++){
            sum+=arr[right];
            while(sum>=target){
                minLength = Math.min(minLength,right-left+1);
                sum-=arr[left];
                left++;
            }

        }
        return minLength;
    }
    public static int[] search_int_2dArray(int[][] arr, int target){
        int rows = arr.length;
        int cols = arr[0].length;
        int str = 0;
        int end = rows*cols-1;
        while(str<=end){
            int mid = str+(end-str)/2;
            int row = mid/cols;
            int col = mid%cols;
            if(arr[row][col]==target){
                return new int[]{row,col}; 
            } else if (arr[row][col]<target) {
                str = mid+1;
            }else {
                end = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int[][] kClosest(int[][] arr,int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
       for(int[] i:arr){
           maxHeap.offer(i);
           if (maxHeap.size()>k){
               maxHeap.poll();
           }
       }
       int[][] result = new int[k][2];
       while (!maxHeap.isEmpty()){
           result[--k] = maxHeap.poll();
       }
       return result;
    }
}
// leetcode 295 Hard
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}
