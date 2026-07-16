package dsa_topics;
import java.util.ArrayList;
import java.util.List;

public class day_37_connected_component {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int V  = 11;
        create_graph(graph,V);
       // dfs_component(graph,new boolean[V],V);
        System.out.println(detect_cycle(graph,new boolean[V],V));

    }

    public static void create_graph(List<List<Integer>> graph, int V){
       for(int i =0; i<=V; i++){
           graph.add(new ArrayList<>());
       }
       //component 1
       graph.get(0).add(1);
       graph.get(0).add(3);
       graph.get(1).add(2);
       graph.get(1).add(0);
       graph.get(2).add(1);
       graph.get(2).add(3);
       graph.get(3).add(2);
       graph.get(3).add(0);
       //component 2
       graph.get(4).add(5);
       graph.get(5).add(4);
       // component 3
       graph.get(6).add(8);
       graph.get(6).add(7);
       graph.get(7).add(6);
       graph.get(7).add(8);
       graph.get(8).add(6);
       graph.get(8).add(7);
       // component 4 & 5
    }
    public static void dfs(List<List<Integer>> graph , int curr, boolean[] visited){
        visited[curr]=true;
        System.out.print(curr+" ");
        for (int neigh:graph.get(curr)){
            if (!visited[neigh]){
                dfs(graph,neigh,visited);
            }
        }
    }
    public static void dfs_component(List<List<Integer>> graph, boolean[] visited,int V) {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
    public static boolean DFS_Cycle_Detection(List<List<Integer>> graph, int curr,boolean[] visited, int parent)
    {
        visited[curr] = true;
        for(int i :graph.get(curr)){
            if(!visited[i]){
                if(DFS_Cycle_Detection(graph,i,visited,curr)) return true;
            } else if (i!=parent) {
                return true;
            }
        }
        return false;
    }
    public static boolean detect_cycle(List<List<Integer>> graph,boolean[] visited,int v){
        for (int i = 0;i<v; i ++){
            if (!visited[i]){
               if( DFS_Cycle_Detection(graph,i,visited,-1)) return true;
            }
        }
        return false;
    }
}
