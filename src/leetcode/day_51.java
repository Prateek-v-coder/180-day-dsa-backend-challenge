package leetcode;

import java.util.Arrays;

public class day_51 {
        public int solve(int i, int j, int m, int n, int[][]dp){
            if(i==m-1&&j==n-1) return 1;
            if(i>=m||j>=n) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int right = solve(i,j+1,m,n,dp);
            int down = solve(i+1,j,m,n,dp);
            return dp[i][j] = right+down;
        }

        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int[]i:dp){
                Arrays.fill(i,-1);
            }
            return solve(0,0,m,n,dp);

        }// beats 100%
    public boolean solve(int i, int target,int[]nums,int[][] dp){
        if(target==0) return true;
        if(i==nums.length) return false;
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean skip = solve(i+1,target,nums,dp);
        boolean choose = false;
        if(target>=nums[i]){
            choose = solve(i+1,target-nums[i],nums,dp);
        }
        dp[i][target] = (skip||choose)?1:0;
        return dp[i][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,target,nums,dp);
    }// beats 18% but isme thoda help lena pada
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i =1; i<=text1.length(); i++){
            for(int j =1; j<=text2.length(); j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

    }// beats 48 % bas thoda sa help lena pada
    public int solve(int i, int j , String s, int[][]dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = 2 + solve(i+1,j-1,s,dp);
        }else{
            return dp[i][j] = Math.max(solve(i+1,j,s,dp),solve(i,j-1,s,dp));
        }
    }

    public int longestPalindromeSubseq(String s) {
        int[][] dp =  new int[s.length()][s.length()];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,s.length()-1,s,dp);

    }// beats 86% bus thoda sa help lena pada
    class Solution {
        public int solve(int i , int j , String s, String str, int[][]dp){
            if(i<0) return j+1;
            if(j<0) return i+1;
            if(dp[i][j]!=-1) return dp[i][j];
            if(s.charAt(i)==str.charAt(j)){
                return dp[i][j] = solve(i-1,j-1,s,str,dp);
            }else{
                int ins = 1+ solve(i,j-1,s,str,dp);
                int del = 1+ solve(i-1,j,s,str,dp);
                int rep = 1+ solve(i-1,j-1,s,str,dp);
                return dp[i][j] = Math.min(ins,Math.min(del,rep));
            }
        }

        public int minDistance(String word1, String word2){
            int[][] dp = new int[word1.length()][word2.length()];
            for(int[]i:dp){
                Arrays.fill(i,-1);
            }
            return solve(word1.length()-1,word2.length()-1,word1,word2,dp);

        }
    }// beats 98% bas thoda help lena pada haiand leetcode 743 nahi kar paya hu aaj
    }
