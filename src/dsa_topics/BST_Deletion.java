package dsa_topics;

public class BST_Deletion {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        TreeNode root = new TreeNode(1);
        tree.insert(root,2);
        tree.insert(root,3);
        tree.insert(root,7);
        tree.insert(root,9);
        tree.insert(root,78);
        tree.insert(root,9);
        tree.preOrderTraversal(root);
        System.out.println();
        delete(root,9);
        tree.preOrderTraversal(root);

    }
    public static TreeNode delete(TreeNode root,int value){
        if(root.data>value){
          root.left = delete(root.left,value);
        }
        else if (root.data<value){
            root.right = delete(root.right,value);
        }
        else{
            if(root.left==null&&root.right==null) return null;
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            TreeNode sc = successor(root.right);
            root.data=sc.data;
           root.right =  delete(root.right,sc.data);
        }
        return root;
    }
    public static TreeNode successor(TreeNode root){
        if (root==null) return null;
        root.left=  successor(root.left);
        return root;
    }
}
