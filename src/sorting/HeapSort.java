package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,8,1,4,5,9,0,15,14,20};
        System.out.println(Arrays.toString(heap_sort(arr)));

    }
    public static int[] heap_sort(int[] arr){
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i:arr){
            min.offer(i);
        }
        int[] sortedArr = new int[arr.length];
        int k = 0;
       while(!min.isEmpty()){
           sortedArr[k++]=min.poll();
       }
        return sortedArr;
    }
}
