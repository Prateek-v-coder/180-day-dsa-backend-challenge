package dsa_topics;

public class Binary_Tree {
   public static void preOrderTraversal(TreeNode root){
        if(root==null) return;
       System.out.print(root.data+" ");
       preOrderTraversal(root.left);
       preOrderTraversal(root.right);
   }
   public static void postOrderTraversal(TreeNode root){
        if (root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
       System.out.print(root.data+" ");
   }
   public static void inOrderTraversal(TreeNode root){
       if (root==null) return;
       inOrderTraversal(root.left);
       System.out.print(root.data+" ");
       inOrderTraversal(root.right);
   }
}
