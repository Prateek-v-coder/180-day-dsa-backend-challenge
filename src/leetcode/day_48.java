package leetcode;

import java.util.Arrays;

public class day_48 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length+1];
            Arrays.fill(dp,1);
            int ans = 1;
            for(int i = 0; i<nums.length; i++){
                for(int j = 0; j<i; j++){
                    if(nums[j]<nums[i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                ans = Math.max(dp[i],ans);
            }
            return ans;
        }// beats 72% but isme jada help lagi new patter se solve kiya hai isliye
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] freq = new int[128];
            int left = 0;
            int maxLen = 0;
            for(int right = 0; right<s.length(); right++){
                freq[s.charAt(right)]++;
                while(freq[s.charAt(right)]>1){
                    freq[s.charAt(left)]--;
                    left++;
                }
                maxLen = Math.max(maxLen,right-left+1);

            }
            return maxLen;
        }
    }// leetcode 3 resubmit karne pe bhi beats 14.99 %
        public int solve(int i , int j, int m, int n , int[][]dp){
            if(i==m-1&&j==n-1) return 1;
            if(i>=m||j>=n) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int right = solve(i+1,j,m,n,dp);
            int down = solve(i,j+1,m,n,dp);
            return dp[i][j] = right+down;
        }
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int[]i :dp){
                Arrays.fill(i,-1);
            }
            return solve(0,0,m,n,dp);

        }
        // beats 100% and ye khud kiya 0 help ke
        public int solve(int i , int j, int m ,int n, int[][]grid, int[][]dp){
            if(i==m-1&&j==n-1) return grid[i][j];
            if(i>=m||j>=n) return Integer.MAX_VALUE;
            if(dp[i][j]!=-1) return dp[i][j];
            int right = solve(i+1,j,m,n,grid,dp);
            int down =  solve(i,j+1,m,n,grid,dp);
            return dp[i][j] =grid[i][j] + Math.min(right,down);
        }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,m,n,grid,dp);

    }// beats 99.99% but isme help lagi hai lagbhag 70%
    public int solve1(int i , int j ,int m , int n, int[][] grid, int[][]dp){
        if(i>=m||j>=n||grid[i][j]==1) return 0;
        if(i==m-1&&j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(i,j+1,m,n,grid,dp);
        int down  = solve(i+1,j,m,n,grid,dp);
        return dp[i][j] = right+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,m,n,obstacleGrid,dp);
    }//beats 100% without help 0% help
    }

