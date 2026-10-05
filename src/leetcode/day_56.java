package leetcode;

import java.util.Arrays;

public class day_56 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i = 0; i<=amount; i++){
            for(int coin:coins){
                if(coin<=i) dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }//beats 78% by using tabulation with help
        public int solve(int i , int j, int m ,int n, int [][]dp){
            if(i>=m||j>=n) return 0;
            if(i==m-1&&j==n-1) return 1;
            if(dp[i][j]!=-1) return dp[i][j];
            int right = solve(i,j+1,m,n,dp);
            int down = solve(i+1,j,m,n,dp);
            return dp[i][j]=right+down;
        }
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int []i:dp){
                Arrays.fill(i,-1);
            }
            return solve(0,0,m,n,dp);
        }// beats 100% with some help
    public int solve(int i, int j, int m,int n,int[][] grid, int[][]dp){
        if(i>=m||j>=n) return Integer.MAX_VALUE;
        if(i==m-1&&j==n-1) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(i,j+1,m,n,grid,dp);
        int down = solve(i+1,j,m,n,grid,dp);
        return dp[i][j] =grid[i][j]+ Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,m,n,grid,dp);
    }//beats 99.85%
}
