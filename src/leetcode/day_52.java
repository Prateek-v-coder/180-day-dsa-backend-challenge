package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class day_52 {public int solve(List<List<int[]>> graph, int V, int src){
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
    int[] dist = new int[V+1];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src] = 0;
    pq.offer(new int[]{src,0});
    while(!pq.isEmpty()){
        int[] node = pq.poll();
        int u = node[0];
        int d = node[1];
        if(d>dist[u]) continue;
        for(int[]i:graph.get(u)){
            int v = i[0];
            int w = i[1];
            if(dist[u]+w<dist[v]){
                dist[v] = dist[u]+w;
                pq.offer(new int[]{v,dist[v]});
            }
        }
    }
    int ans = 0;
    for(int i = 1; i<dist.length; i++){
        if(dist[i]==Integer.MAX_VALUE) return -1;
        else ans = Math.max(ans,dist[i]);
    }
    return ans;
}
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i:times){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            graph.get(u).add(new int[]{v,w});
        }
        return solve(graph,n,k);
    }// beats 24% bas
        public int solve(String s,int left, int right){
            int count = 0;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
            return count;
        }
        public int countSubstrings(String s) {
            int ans = 0;
            for(int i = 0;i<s.length(); i++){
                ans+=solve(s,i,i);
                ans+=solve(s,i,i+1);
            }
            return ans;

        }// beats 98 % bas thoda sa help laga
    public String solveLP(String s, int left , int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i<s.length(); i++){
            String odd = solveLP(s,i,i);
            String even = solveLP(s,i,i+1);
            if(ans.length()<odd.length()){
                ans=odd;
            }
            if(ans.length()<even.length()){
                ans=even;
            }
        }
        return ans;
    }// beats 45% but isme bhi thoda sa help lena pada
    }

