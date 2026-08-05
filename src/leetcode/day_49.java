package leetcode;

import java.util.Arrays;

public class day_49 {
        public boolean solve(int i,int target,int[]nums,int[][]dp){
            if(target==0) return true;
            if(i==nums.length) return false;
            if(dp[i][target]!=-1) return dp[i][target]==1;
            boolean skip = solve(i+1,target,nums,dp);
            boolean choose = false;
            if(nums[i]<=target){
                choose = solve(i+1,target-nums[i],nums,dp);
            }
            dp[i][target] = (skip||choose)?1:0;
            return  skip||choose;
        }
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i = 0; i<nums.length; i++){
                sum+=nums[i];
            }
            if(sum%2!=0) return false;
            sum=sum/2;
            int[][] dp = new int[nums.length][sum+1];
            for(int[]i:dp){
                Arrays.fill(i,-1);
            }
            return solve(0,sum,nums,dp);
        }
    // beats 18% and help bhi leni padi hai
    public int coin(int index, int amount, int[] coins, int[][]dp){
        if(amount==0) return 1;
        if(index==coins.length) return 0;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int skip = coin(index+1,amount,coins,dp);
        int choose = 0;
        if(coins[index]<=amount){
            choose = coin(index,amount-coins[index],coins,dp);
        }
        return dp[index][amount] = skip+choose;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return coin(0,amount,coins,dp);

    }// beats 19.85% and isme bhi help lagi hai
        public int grid(int i , int j, int m, int n , int[][]dp){
            if(i==m-1&&j==n-1) return 1;
            if(i>=m||j>=n) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int right = grid(i,j+1,m,n,dp);
            int down = grid(i+1,j,m,n,dp);
            return dp[i][j] = right+down;
        }
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int[]i:dp){
                Arrays.fill(i,-1);
            }
            return grid(0,0,m,n,dp);
        }// beats 100%
}

