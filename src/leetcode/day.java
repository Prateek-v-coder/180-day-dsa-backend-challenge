package leetcode;

import dsa_topics.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day {
    public void permutation(int[] nums, boolean[] visited,List<Integer> current, List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            current.add(nums[i]);
            visited[i]=true;
            permutation(nums,visited,current,result);
            current.remove(current.size()-1);
            visited[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums,new boolean[nums.length],new ArrayList<>(),result);
        return result;
    }//beats 88.44%
    public void combination(int[] candidates,int index,int target,List<Integer> current, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0) return;
        for(int i = index; i<candidates.length; i++){
            current.add(candidates[i]);
            combination(candidates,i,target-candidates[i],current,result);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates,0,target,new ArrayList<>(),result);
        return result;
    }//beats 93% with sum help
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int maxDepth = Math.max(maxDepth(root.left),maxDepth(root.right));
        return 1+maxDepth;
    }// beats 100%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.data>p.data&&root.data>q.data){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.data<p.data&&root.data<q.data){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;

    }//beats 97%
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i = 0; i<nums.length; i++){
            if(i>maxJump) return false;
            else maxJump = Math.max(nums[i]+i,maxJump);
        }
        return true;
    }// beats 89.87%
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int count = 0;
        int firstEnd = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(firstEnd>start){
                count++;
            }else{
                firstEnd = end;
            }

        }
        return count;

    }//beats 85.68%
    public int solve(int n, int[] dp){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        int oneStep = solve(n-1,dp);
        int twoStep = solve(n-2,dp);
        return dp[n] = oneStep+twoStep;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }// beats 100%
    class Solution {
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
        }
    }//beats 100%
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right<s.length(); right++){
            freq[s.charAt(right)]++;
            while(freq[s.charAt(right)]>1){
                freq[s.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }// beats 86%
}
