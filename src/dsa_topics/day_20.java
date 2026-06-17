package dsa_topics;

public class day_20 {
    public static void main(String[] args) {

        Binary_Tree tree = new Binary_Tree();
        TreeNode root = new TreeNode(10);
        tree.insert(root,20);
        tree.insert(root,15);
        tree.insert(root,17);
        tree.insert(root,30);
        tree.insert(root,35);
       TreeNode root1 =  tree.insert(root,17);



    }
}
