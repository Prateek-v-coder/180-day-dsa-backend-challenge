package leetcode;

import java.util.Arrays;

public class day_46 {
        public int solve(int i, int[] nums, int[] dp){
            if(i>=nums.length){
                return 0;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
            int rob = nums[i]+solve(i+2,nums,dp);
            int skip = solve(i+1,nums,dp);
            return dp[i] = Math.max(rob,skip);
        }
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return solve(0,nums,dp);

        }
        // isme help laga mai sab bhool gaya tha but beats 100%

            public int solve1(int i , int[] cost, int[] dp){
                if(i>=cost.length) return 0;
                if(dp[i]!=-1) return dp[i];
                int oneStep = cost[i]+solve(i+1,cost,dp);
                int twoStep = cost[i]+solve(i+2,cost,dp);
                return dp[i] = Math.min(oneStep,twoStep);
            }
            public int minCostClimbingStairs(int[] cost) {
                int[] dp = new int[cost.length];
                Arrays.fill(dp,-1);
                return Math.min(solve1(0,cost,dp),solve1(1,cost,dp));
            }
            // beats 39% but yanha bhi thoda help laga question to samjha gaya tha 0 se ya 1 se kaise start karna hai ye nahi samjha aa raha tha

             public int solve3(int i , String s , int[] dp){
                 if(i==s.length()) return 1;
                 if(s.charAt(i)=='0') return 0;
                 if(dp[i]!=-1) return dp[i];
                 int one = solve3(i+1,s,dp);
                 int two = 0;
                 if(i+1<s.length()){
                     int nums = Integer.parseInt(s.substring(i,i+2));
                     if(nums<=26){
                         two = solve3(i+2,s,dp);
                     }
                 }
                 return dp[i] = one + two;
             }
            public int numDecodings(String s) {
               int[] dp = new int[s.length()];
               Arrays.fill(dp,-1);
               return solve3(0,s,dp);
               // beats 79.02 % but yanha bhi kafi help laga hai

    }


    }
