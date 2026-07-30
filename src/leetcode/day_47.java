package leetcode;

import java.util.Arrays;

public class day_47 {
        public int solve(int i ,int end , int[] nums , int[] dp){
            if(i > end) return 0;
            if(dp[i]!=-1) return dp[i];
            int rob = nums[i]+solve(i+2,end,nums,dp);
            int skip = solve(i+1,end,nums,dp);
            return dp[i] = Math.max(rob,skip);
        }
        public int rob(int[] nums) {
            if(nums.length==1) return nums[0];
            int[] dp = new int[nums.length];
            int[] dp1 = new int[nums.length];
            Arrays.fill(dp,-1);
            Arrays.fill(dp1,-1);
            int case1 = solve(0,nums.length-2,nums,dp1);
            int case2 = solve(1,nums.length-1,nums,dp);
            return Math.max(case1,case2);
        }
    // beats 100% bas thoda help lena pada

}
