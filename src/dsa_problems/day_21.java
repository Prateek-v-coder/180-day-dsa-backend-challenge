package dsa_problems;
import dsa_topics.Binary_Tree;
import dsa_topics.TreeNode;

public class day_21 {
    public static void main(String[] args) {
        int[] nodes = {50, 30, 70, 20, 40, 60, 80};
        Binary_Tree tree = new Binary_Tree();
        TreeNode root = new TreeNode(nodes[0]);
        for (int i = 1; i<nodes.length; i++){
            root = tree.insert(root,nodes[i]);
        }
        tree.preOrderTraversal(root);
        TreeNode Root = invertTree(root);
        System.out.println();
        tree.preOrderTraversal(Root);
    }
    public static TreeNode invertTree(TreeNode root){
        if(root==null) return null;
        TreeNode temp = root.right;
        root.right=root.left;
        root.left=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public static boolean isEqualTree(TreeNode tree1root,TreeNode tree2root){
        if (tree1root==null&&tree2root==null) return true;
        if (tree1root==null || tree2root==null) return false;
        if (tree1root.data!=tree2root.data) return false;
      return isEqualTree(tree1root.left,tree2root.left) &&  isEqualTree(tree1root.right,tree2root.right);
    }
    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return null;
        if (root.data>p.data&&root.data>q.data){
            return LCA(root.left, p, q);
        } else if (root.data<p.data&&root.data<q.data) {
            return LCA(root.right, p, q);
        }
        else return root;
    }
    public static boolean isValid(TreeNode root,long max,long min){
        if (root==null) return true;
        if (root.data<=min||root.data>=max) return false;
        return isValid(root.left,root.data,min) && isValid(root.right,max ,root.data);
    }
}
