package dsa_problems;

import java.util.*;

public class day_41 {
    public static void main(String[] args) {

    }
        public void topo(int[][] graph,int V,int[] indeg,List<Integer> result){
            List<List<Integer>> revGraph = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i<V; i++){
                revGraph.add(new ArrayList<>());
            }
            for(int i = 0; i<V; i++){
                for(int neigh:graph[i]){
                    revGraph.get(neigh).add(i);
                    indeg[i]++;
                }
            }
            for(int i =0;i<V; i++){
                if(indeg[i]==0){
                    queue.offer(i);
                }
            }
            while(!queue.isEmpty()){
                int curr = queue.poll();
                result.add(curr);
                for(int neigh:revGraph.get(curr)){
                    indeg[neigh]--;
                    if(indeg[neigh]==0){
                        queue.offer(neigh);

                    }
                }

            }

        }
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            int[] indeg = new int[V];
            List<Integer> result = new ArrayList<>();
            topo(graph,V,indeg,result);
            Collections.sort(result);
            return result;
        }
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] sufix = new int[nums.length];
        pref[0]=nums[0];
        for(int i = 1; i<nums.length; i++){
            pref[i]=nums[i]*pref[i-1];
        }
        sufix[nums.length-1]=nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--){
            sufix[i] = nums[i]*sufix[i+1];
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(i==0){
                ans[i]=sufix[i+1];
            }else if(i==nums.length-1){
                ans[i]=pref[i-1];
            }else{
                ans[i]=pref[i-1]*sufix[i+1];
            }
        }
        return ans;
    }
}
