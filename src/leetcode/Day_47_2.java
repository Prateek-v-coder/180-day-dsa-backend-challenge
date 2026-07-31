package leetcode;

import java.util.Arrays;

public class Day_47_2 {
        public int solve(int i, int prev,int[] nums,int[][]dp){
            if(i==nums.length) return 0;
            if(dp[i][prev+1]!=-1) return dp[i][prev+1];
            int count = 0;
            if(prev==-1||nums[prev]<nums[i]){
                count = 1+solve(i+1,i,nums,dp);
            }
            int skip = solve(i+1,prev,nums,dp);
            return dp[i][prev+1] = Math.max(count,skip);
        }
        public int lengthOfLIS(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            for(int i[]:dp){
                Arrays.fill(i,-1);
            }
            return solve(0,-1,nums,dp);
            // beats 15% but yanha bhi jada help laga
        }
        public boolean solve(int i , int sum , int[] nums, Boolean[][] dp){
            if(sum==0) return true;
            if(i==nums.length) return false;
            if(dp[i][sum]!=null) return dp[i][sum];
            boolean take = false;
            if(nums[i]<=sum){
                take = solve(i+1,sum-nums[i],nums,dp);
            }
            boolean skip = solve(i+1,sum,nums,dp);
            return dp[i][sum] = take||skip;
        }
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i = 0; i<nums.length; i++){
                sum = sum+nums[i];
            }
            int target = sum/2;
            if(sum%2!=0) return false;
            Boolean[][] dp = new Boolean[nums.length][target+1];
            return solve(0,sum/2,nums,dp);
        }
        //beats 10% isme bhi jada help laga queation samjha hi nahi aa raha tha
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
            // beats 10% maine hashMap bhi try kiya but usse bhi beats 8% hi aa raha tha

}
