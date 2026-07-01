package dsa_topics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graphs {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(List<List<Integer>> graph,int V){
      for (int i =0; i<V; i++){
          graph.add(new ArrayList<>());
      }
      graph.get(1).add(2);
      graph.get(1).add(4);
      graph.get(2).add(3);
      graph.get(2).add(1);
      graph.get(3).add(2);
      graph.get(3).add(6);
      graph.get(4).add(1);
      graph.get(4).add(5);
      graph.get(5).add(4);
      graph.get(5).add(6);
      graph.get(6).add(3);
      graph.get(6).add(5);
      graph.get(6).add(7);
      graph.get(7).add(6);

    }
    public static void BFS(List<List<Integer>> graph, int V){
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[V];
      q.offer(1);
      visited[1]=true;
      while(!q.isEmpty()){
          int curr = q.poll();
          System.out.print(curr+" ");
          for (int neigh:graph.get(curr)){
            if(!visited[neigh]){
                visited[neigh] = true;
                q.offer(neigh);
            }
          }
      }

    }
    public static void DFS(List<List<Integer>> graph,int curr,boolean[] visited){
        visited[curr] = true;
        System.out.print(curr+" ");
        for (int i:graph.get(curr)){
            if (!visited[i]){
                visited[i]=true;
                DFS(graph,i,visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 8;
       List<List<Integer>> graph = new ArrayList<>();
        createGraph(graph,V);
        BFS(graph,V);
        System.out.println();
        DFS(graph,1,new boolean[V]);


    }
}
