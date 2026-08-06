package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class day_50 {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int[][] dp = new int[n+1][m+1];
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=m; j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[n][m];

        }// beats 78% and isme jada help lagi hai code dekhana pada hai
    public int solve(int i , int j, String s, int[][]dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j] = 2+solve(i+1,j-1,s,dp);
        }else{
            int skipleft = solve(i+1,j,s,dp);
            int skipright = solve(i,j-1,s,dp);
            dp[i][j] = Math.max(skipleft,skipright);
        }
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,s.length()-1,s,dp);

    }// beast 86% but isme bhi jada help lagi hai code dekhana pada hai
    class Solution {
        public int minDis(int i, int j ,String word1, String word2, int[][] dp){
            if(i==word1.length()) return word2.length()-j;
            if(j==word2.length()) return word1.length()-i;
            if(dp[i][j]!=-1) return dp[i][j];
            if(word1.charAt(i)==word2.charAt(j)){
                dp[i][j] = minDis(i+1,j+1,word1,word2,dp);
            } else{
                int insert = 1+minDis(i,j+1,word1,word2,dp);
                int delete = 1+minDis(i+1,j,word1,word2,dp);
                int replace = 1+minDis(i+1,j+1,word1,word2,dp);
                dp[i][j] = Math.min(insert,Math.min(delete,replace));
            }
            return dp[i][j];
        }
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length()][word2.length()];
            for(int[]i:dp){
                Arrays.fill(i,-1);
            }
            return minDis(0,0,word1,word2,dp);

        }
    }// beats 98% but isme bahut jada help lagi hai code dekha hu but ise revise karna padega baad me yaad se kara dena

        public int dijktra(List<List<int[]>> graph,int src,int V){
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
            int[] dist = new int[V+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[src] = 0;
            pq.offer(new int[]{src,0});
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int currNode = curr[0];
                int distance = curr[1];
                if(distance>dist[currNode]) continue;
                for(int[]neigh:graph.get(currNode)){
                    int v = neigh[0];
                    int weight = neigh[1];
                    if(dist[currNode]+weight<dist[v]){
                        dist[v] = dist[currNode]+weight;
                        pq.offer(new int[]{v,dist[v]});
                    }
                }

            }
            int ans = 0;
            for(int i = 1; i<dist.length; i++){
                if(dist[i]==Integer.MAX_VALUE) return -1;
                ans = Math.max(ans,dist[i]);
            }
            return ans;
        }
        public int networkDelayTime(int[][] times, int n, int k) {
            List<List<int[]>> graph = new ArrayList<>();
            for(int i =0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            for(int[]i:times){
                int u = i[0];
                int v= i[1];
                int w = i[2];
                graph.get(u).add(new int[]{v,w});
            }
            return dijktra( graph,k,n);


        }// beats 26% but isme me jada help lagi hai and mujhe lagata hai isme aur bhi practice karni chaiye
    }


