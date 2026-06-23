package dsa_problems;

import dsa_topics.TreeNode;
import org.w3c.dom.Node;

import java.util.HashSet;

public class dya_27 {
    public static void main(String[] args) {

    }
    // revision problems ...
    public static int longestStringWithoutRepeating(String str){
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        int left = 0;
        for (int right = 0; right<str.length(); right++){
          while (set.contains(str.charAt(right))){
              set.remove(str.charAt(left));
              left++;
          }
          set.add(str.charAt(right));
          length = Math.max(right-left+1,length);
        }
        return length;
    }
    // leetcode 234 palindrome linked list

    // leetcode 104 max depth of binary tree
    public static int maxDept(TreeNode root){
        if (root==null) return 0;
        int max = Math.max( maxDept(root.right),maxDept(root.left));
        return max+1;
    }
    // leetcode 912 leetcode 75 leetcode 88
}
