package leetcode;

import dsa_topics.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class day_55 {
    public void permutation(int[] nums, boolean[] used, List<Integer> current , List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(used[i]) continue;
            current.add(nums[i]);
            used[i] = true;
            permutation(nums,used,current,result);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }// beats 88% but mai ise ek dam bhool gaya tha dobara poora code samjhana pda hai kafi time se revision bhi nhi ho payi hai isi liye ek kaam karo hamara reveion day trak karo aur ise is baar jaldi schedule karo
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left!=null) return left;
        return right;
    }


    }
