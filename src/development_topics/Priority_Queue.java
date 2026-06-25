package development_topics;

import java.util.Collections;
import java.util.PriorityQueue;

public class Priority_Queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(40);
        minHeap.offer(20);
        minHeap.offer(30);
        minHeap.offer(10);
        System.out.println(minHeap);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        minHeap.clear();
        System.out.println();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(10);
        maxHeap.offer(30);
        maxHeap.offer(40);
        maxHeap.offer(20);
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());
    }
}
