package Revision_day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Revision_day1 {
    public static void main(String[] args) {
       int [] arr = {1,2,3};
       List<List<Integer>> result = new ArrayList<>();
       permutation(arr,new boolean[arr.length],new ArrayList<>(),result);
        System.out.println(result);
    }
    public static void createGraph(List<List<Integer>> graph,int V){
        for (int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);


    }
    public static void BFS(List<List<Integer>> graph,int curr,int V){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        queue.offer(curr);
        visited[curr] = true;
        while(!queue.isEmpty()){
            int popNode = queue.poll();
            System.out.print(popNode+" ");
            for(int i:graph.get(popNode)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
    public static void DFS(List<List<Integer>> graph,int curr,boolean[] visited){
        visited[curr] = true;
        System.out.print(curr+" ");
        for(int i:graph.get(curr)){
            if(!visited[i]){
                DFS(graph,i,visited);
            }
        }
    }
    public static void connected_component(List<List<Integer>> graph,int V){
        boolean[] visited = new boolean[V];
        for(int i = 1; i<V; i++){
            if(!visited[i]){
                DFS(graph,i,visited);
            }
        }
    }
    public static boolean cycle_unDirect(List<List<Integer>> graph,int curr, int parent,boolean[] visited){
        visited[curr] = true;
        for(int i :graph.get(curr)){
            if(!visited[i]){
                if(cycle_unDirect(graph,i,curr,visited)) return true;
            } else if (i!=parent) {
                return true;
            }
        }
        return false;
    }
    public static List<Integer> kahnsAlgo(List<List<Integer>> graph,int V){
        Queue<Integer> queue = new LinkedList<>();
       int[] indeg = new int[V];
       for(int i = 0; i<V; i++){
           for(int neigh:graph.get(i)){
               indeg[neigh]++;
           }
       }
       for(int i = 0; i<V; i++){
           if(indeg[i]==0){
               queue.offer(i);
           }
       }
       List<Integer> result = new ArrayList<>();
       while(!queue.isEmpty()){
           int curr = queue.poll();
           result.add(curr);
           for(int i :graph.get(curr)){
               indeg[i]--;
               if(indeg[i]==0){
                   queue.offer(i);
               }
           }
       }
       if (result.size()!=V){
           return new ArrayList<>();
       }
       else {
           return result;
       }
    }
    public static void permutation(int [] arr,boolean[] fixed, List<Integer> current,List<List<Integer>> result){
        if(current.size()==arr.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(fixed[i]) continue;
            current.add(arr[i]);
            fixed[i]=true;
            permutation(arr,fixed,current,result);
            current.remove(current.size()-1);
            fixed[i]=false;
        }
    }
}
