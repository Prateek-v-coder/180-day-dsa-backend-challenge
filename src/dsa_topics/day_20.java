package dsa_topics;

public class day_20 {
    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Binary_Tree.preOrderTraversal(root);
        System.out.println();
        Binary_Tree.postOrderTraversal(root);
        System.out.println();
        Binary_Tree.inOrderTraversal(root);


    }
}
