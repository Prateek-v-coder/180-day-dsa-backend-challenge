package dsa_topics;

import java.util.Arrays;

public class Knapsack_pattern {
    public static int knapSack(int index, int capacity, int[]weight, int[] value, int[][]dp){
        if(index==weight.length||capacity==0) return 0;
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        int skip = knapSack(index+1,capacity,weight,value,dp);
        int choose = 0;
        if(weight[index]<=capacity){
            choose = value[index]+ knapSack(index+1,capacity-weight[index],weight,value,dp);
        }
        return dp[index][capacity] = Math.max(skip,choose);
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4,5};
        int[] value = {1,4,5,7};
        int capacity = 7;
        int n = weight.length;
        int[][] dp = new int[n][capacity+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        int ans = knapSack(0,capacity,weight,value,dp);
        System.out.println(ans);

    }
}
