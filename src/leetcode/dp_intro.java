package leetcode;

import java.util.Arrays;

public class dp_intro {
    class Solution {
        public static int fibo(int n,int[] dp){
            if(n<=1) return n;
            if(dp[n]!=-1) return dp[n];
            return dp[n] = fibo(n-1,dp)+fibo(n-2,dp);
        }
        public int fib(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
            return fibo(n,dp);
        }
        // beats 100 % and ek chhoti se help lagi thi
        //leetcode 70
            public int findSteps(int n, int[] dp){
                if(n<=2) return n;
                if(dp[n]!=-1) return dp[n];
                return dp[n] = findSteps(n-1,dp)+findSteps(n-2,dp);
            }
            public int climbStairs(int n) {
                int[] dp = new int[n+1];
                Arrays.fill(dp,-1);
                return findSteps(n,dp);
            }
            // beats 100% but isme jyada help lagi question hi samajh nahi a raha tha ki fibonacci jaisa code hi kyo use kar raha hai aur dono me difference kya hai
        }
       // leetcode 198
        public int solve(int i, int[] arr , int[] dp){
            if(i>=arr.length) return 0;
            if(dp[i]!=-1) return dp[i];
            int rob = arr[i]+solve(i+2,arr,dp);
            int skip =  solve(i+1,arr,dp);
            return dp[i] = Math.max(rob,skip);
        }
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return solve(0,nums,dp);
        }
        // beats 100 % but isme bhi help laga hai
    }

