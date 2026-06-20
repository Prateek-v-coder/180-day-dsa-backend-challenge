package dsa_problems;

import com.sun.source.tree.Tree;
import dsa_topics.TreeNode;

public class day_24_tree_intensive_day {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(4);
        root.right=new TreeNode(5);
        root.left.left= new TreeNode(1);
        root.left.right = new TreeNode(2);
       TreeNode subRoot = new TreeNode(4);
       subRoot.left = new TreeNode(1);
       subRoot.right = new TreeNode(2);
        System.out.println(subTree(root,subRoot));



    }
    public static boolean isSameTree(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        if(root1.data!=root2.data) return false;
        return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }
    public static boolean symmetricChecker(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        if(root1.data!=root2.data) return false;
        return symmetricChecker(root1.left,root2.right)&&symmetricChecker(root1.right,root2.left);
    }
    public static boolean isSymmetric(TreeNode root){
        return symmetricChecker(root,root);
    }
    public static boolean isSame(TreeNode root, TreeNode subRoot){
        if (root==null&&subRoot==null) return true;
        if (root==null||subRoot==null) return false;
        if(root.data!=subRoot.data) return false;
        return isSame(root.left,subRoot.left)&&isSame(root.right,subRoot.right);
    }
    public static boolean subTree(TreeNode root,TreeNode subRoot){
        if(root==null) return false;
        if(isSame(root,subRoot)) return true;
        return subTree(root.left,subRoot)||subTree(root.right,subRoot);
    }
    // Leetcode 617
    public static TreeNode mergerTrees(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null) return null;
        if (root1==null){
            return root2;
        } else if (root2==null) {
            return root1;
        }else{
            root1.data+= root2.data;
        }
        root1.left = mergerTrees(root1.left,root2.left);
        root1.right = mergerTrees(root1.right,root2.right);
        return root1;
    }
    // leetcode 951
    public static boolean flipEquiv(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        if(root1.data!=root2.data) return false;
        return flipEquiv(root1.right,root2.left)&&flipEquiv(root1.left,root2.right)||flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right);
    }

}
