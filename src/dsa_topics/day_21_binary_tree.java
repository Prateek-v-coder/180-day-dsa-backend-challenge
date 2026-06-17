package dsa_topics;
public class day_21_binary_tree {
    public static void main(String[] args) {
        int[] nodes = {50, 30, 70, 20, 40, 60, 80};
        Binary_Tree tree = new Binary_Tree();
        TreeNode root = new TreeNode(nodes[0]);
        for (int i = 1; i<nodes.length; i++){
            root = tree.insert(root,nodes[i]);
        }
       tree.inOrderTraversal(root);
        System.out.println();
        System.out.println(tree.search(root,10));
        System.out.println(tree.findMinimum(null));
        System.out.println(tree.findMaximum(root));
        System.out.println(tree.countNodes(root));
        System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.height(root));
        System.out.println(tree.isValidTree(root,Long.MAX_VALUE,Long.MIN_VALUE));
    }
}
