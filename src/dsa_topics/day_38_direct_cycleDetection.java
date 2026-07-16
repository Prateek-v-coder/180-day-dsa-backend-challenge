package dsa_topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class day_38_direct_cycleDetection {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int V = 6;
        createGraph(graph,V);
        //System.out.println(hasCycle(graph,V,new boolean[V],new boolean[V]));
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
    public static boolean directed_cycle(List<List<Integer>> graph,int curr,boolean[] visited,boolean[] recursivePath){
        visited[curr] = true;
        recursivePath[curr] = true;
        for(int i :graph.get(curr)){
            if(!visited[i]){
                if(directed_cycle(graph,i,visited,recursivePath)) return true;
            }else if(recursivePath[i]){
                return true;
            }
        }
        recursivePath[curr] = false;
        return false;
    }
  public static boolean hasCycle(List<List<Integer>> graph,int V,boolean[] visited,boolean[] recursivePath){
        for (int i =0; i<V; i++){
            if(!visited[i]){
                if(directed_cycle(graph,i,visited,recursivePath)) return true;
            }
        }
        return false;
  }
}
