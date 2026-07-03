package dsa_topics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRecall {
    public static void main(String[] args) {
        List<List<Integer>> graph =new ArrayList<>();
        int V = 10;
        builtGraph(graph,V);
//        System.out.println(graph);
       // BFS(graph,V);
        DFS(graph,new boolean[V],0);
    }
    public static void BFS(List<List<Integer>> graph ,int V){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        while (!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");
            for (int neigh:graph.get(curr)){
                if(!visited[neigh]){
                    q.offer(neigh);
                    visited[neigh]=true;
                }
            }
        }
    }
    public static void DFS(List<List<Integer>> graph, boolean[] visited,int curr){
        visited[curr] =true;
        System.out.print(curr+" ");
        for (int neigh:graph.get(curr)){
            if (!visited[neigh]){
                DFS(graph,visited,neigh);
            }
        }
    }
    public static void builtGraph(List<List<Integer>> graph,int V){
        for(int i =0; i<=V; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);
        graph.get(1).add(0);
        graph.get(1).add(4);
        graph.get(2).add(0);
        graph.get(2).add(7);
        graph.get(3).add(0);
        graph.get(3).add(5);
        graph.get(3).add(6);
        graph.get(4).add(1);
        graph.get(4).add(9);
        graph.get(5).add(3);
        graph.get(5).add(9);
        graph.get(5).add(8);
        graph.get(6).add(3);
        graph.get(6).add(8);
        graph.get(7).add(2);
        graph.get(7).add(8);
        graph.get(8).add(6);
        graph.get(8).add(5);
        graph.get(8).add(7);
        graph.get(8).add(9);
        graph.get(9).add(4);
        graph.get(9).add(5);
        graph.get(9).add(8);
    }
}
