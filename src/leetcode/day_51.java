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
    }
