package dsa_topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological_sort {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int V = 2;
        createGraph(graph,V);
        //System.out.println(hasCycle(graph,V,new boolean[V],new boolean[V]));
        Stack<Integer> stack = new Stack<>();
        topoSort(graph,new boolean[V],stack,V);
        while (stack.size()>0){
            System.out.print(stack.pop()+" ");
        }

    }
    public static void createGraph(List<List<Integer>> graph, int V){
        for(int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);

    }
    public static void dfs(List<List<Integer>> graph, int curr, boolean[] visited, Stack<Integer> stack){
        visited[curr] = true;
        for(int i:graph.get(curr)){
            if(!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }
        stack.push(curr);
    }
    public static void topoSort(List<List<Integer>> graph,boolean[] visited,Stack<Integer> stack,int V){
        for(int i =0; i<V; i++){
            if(!visited[i]){
                dfs(graph,i,visited,stack);
            }
        }
    }
}
