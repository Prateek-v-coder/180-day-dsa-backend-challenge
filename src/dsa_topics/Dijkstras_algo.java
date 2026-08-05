package dsa_topics;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras_algo {
    public static void main(String[] args) {
        int V = 4;
        List<List<int[]>> graph = new ArrayList<>();
        createGraph(graph,V);
        int[] ans = dijkstras_algo(graph,0,V);
        System.out.println(Arrays.toString(ans));
    }
    public static void createGraph(List<List<int[]>> graph, int V){
        for(int i=0;i<V;i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(new int[]{1,4});
        graph.get(1).add(new int[]{0,4});
        graph.get(0).add(new int[]{2,8});
        graph.get(2).add(new int[]{0,8});
        graph.get(1).add(new int[]{3,2});
        graph.get(3).add(new int[]{1,2});
        graph.get(2).add(new int[]{3,3});
        graph.get(3).add(new int[]{2,3});
    }
    public static int[] dijkstras_algo(List<List<int[]>> graph,int src,int V){
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.offer(new int[]{0,src});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int d = curr[0];
            int node = curr[1];
            if(d>dist[node]) continue;
            for(int[] neigh:graph.get(node)){
              int nextNode = neigh[0];
              int weight = neigh[1];
              if(dist[node]+weight<dist[nextNode]){
                  dist[nextNode] = dist[node]+weight;
                  queue.offer(new int[]{dist[nextNode],nextNode});
              }
        }
        }
        return dist;
    }

}
