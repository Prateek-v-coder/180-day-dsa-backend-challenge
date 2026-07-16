package dsa_problems;

import java.util.ArrayList;
import java.util.List;

public class day_38 {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int V  =6;
        createGraph(graph,V);
        System.out.println(!hasCycle(graph,V));

    }
    public static void createGraph(List<List<Integer>> graph,int V){
        for(int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(5).add(0);
        graph.get(5).add(2);
    }
    public static boolean dfs_cycle(List<List<Integer>> graph, int curr, boolean[] visited, boolean[] recurTrace){
        visited[curr] = true;
        recurTrace[curr] = true;
        for(int i:graph.get(curr)){
            if(!visited[i]){
                if(dfs_cycle(graph,i,visited,recurTrace)) return true;
            }else if(recurTrace[i]) return true;
        }
        recurTrace[curr] = false;
        return false;
    }
    public static boolean hasCycle(List<List<Integer>>graph,int v){
        boolean[] visited = new boolean[v];
        boolean[] rt = new boolean[v];
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                if(dfs_cycle(graph,i,visited,rt)) return true;
            }
        }
        return false;
    }
}
