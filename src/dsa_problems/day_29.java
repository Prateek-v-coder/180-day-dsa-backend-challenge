package dsa_problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class day_29 {
    public static void main(String[] args) {
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = {1,4,8,3,5,9,2,10};
        for (int i = 0; i<arr.length; i++){
            min.offer(arr[i]);
        }
        int k = 4;
        for (int i = 0;i<k-1; i++){
            min.poll();
        }
        System.out.println(min.peek());
    }
}
