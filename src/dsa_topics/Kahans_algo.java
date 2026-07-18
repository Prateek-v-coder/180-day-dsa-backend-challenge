package dsa_topics;

import java.lang.reflect.Array;
import java.util.*;

public class Kahans_algo {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int V = 2;
        create_list(graph,V);
        System.out.println(Arrays.toString(kahans_algo(graph,V)));

    }
    public static void create_list(List<List<Integer>> graph, int V){
        for(int  i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
    }
    public static int[] kahans_algo(List<List<Integer>> graph, int V) {
        int[] result = new int[V];
        int[] indeg = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (int neigh : graph.get(i)) {
                indeg[neigh]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int idx = 0;
        while (queue.size() > 0) {
            int curr = queue.poll();
            result[idx++] = curr;
            for (int i : graph.get(curr)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        if (idx != V) {
            return new int[0];
        }
        return result;
    }
}
