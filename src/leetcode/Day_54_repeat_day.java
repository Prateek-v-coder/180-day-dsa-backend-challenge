package leetcode;

import java.util.Arrays;

public class Day_54_repeat_day {
        public void dfs(int i, int j,char[][] grid){
            if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1') return;
            grid[i][j]='0';
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
        }
        public int numIslands(char[][] grid) {
            int islands = 0;
            for(int i =0; i<grid.length; i++){
                for(int j =0; j<grid[0].length; j++){
                    if(grid[i][j]=='1'){
                        dfs(i,j,grid);
                        islands++;
                    }
                }
            }
            return islands;

        }// beats 85%
    public boolean canJump(int[] nums) {
        int maxjump = 0;
        for(int i =0; i<nums.length; i++){
            if(i>maxjump) return false;
            maxjump =  Math.max(nums[i]+i,maxjump);

        }
        return true;

    }//beats 89.63%
        public int solve(int n, int[] dp){
            if(n==0||n==1) return 1;
            if(dp[n]!=-1) return dp[n];
            int onestep = solve(n-1,dp);
            int twostep = solve(n-2,dp);
            return dp[n] = onestep+twostep;
        }
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
            return solve(n,dp);
    }// beats 100%
    public int solve(int i , int[] nums, int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int rob = nums[i]+solve(i+2,nums,dp);
        int skip = solve(i+1,nums,dp);
        return dp[i] = Math.max(rob,skip);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);

    }// beats 100%
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i<cost.length; i++){
            dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);

    }//beats 100%
    public int solve1(int amount, int[] coins, int[] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int coin:coins){
            int result = solve(amount-coin,coins,dp);
            if(result!=Integer.MAX_VALUE){
                minCoins = Math.min(minCoins,result+1);
            }
        }
        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int result = solve1(amount,coins,dp);
        if(result==Integer.MAX_VALUE) return -1;
        return result;
    }//beats 28% but isme abhi jada help lagi hai to ise kal phir se solve karana
}

