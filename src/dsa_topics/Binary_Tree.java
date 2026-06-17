package dsa_topics;

public class Binary_Tree {
    public TreeNode insert(TreeNode root,int data){
        if (root==null){
            return new TreeNode(data);
        }
        if(root.data<data){
           root.right =  insert(root.right,data);
        }
        if (root.data>data){
            root.left = insert(root.left,data);
        }
        return root;
    }
    public boolean search(TreeNode root,int data){
        if (root==null) return false;
        if(root.data==data) return true;
        if (root.data>data){
           return search(root.left,data);
        }else{
            return search(root.right,data);
        }
    }
    public int findMinimum(TreeNode root){
        if (root==null) return 0;
        if (root.left==null) return root.data;
        return findMinimum(root.left);
    }
    public int findMaximum(TreeNode root){
        if (root==null) return 0;
        if (root.right==null) return root.data;
        return findMaximum(root.right);
    }
    public int countNodes(TreeNode root){
        if (root==null) return 0;
        return countNodes(root.left)+countNodes(root.right) + 1;
    }
    public int sumOfNodes(TreeNode root){
        if (root==null) return 0;
        return sumOfNodes(root.left)+sumOfNodes(root.right) +root.data;
    }
    public int height(TreeNode root){
        if (root==null) return 0;
        int leftHeight = height(root.left)+1;
        int rightHeight = height(root.right)+1;
        return Math.max(leftHeight,rightHeight);

    }
    public TreeNode invert(TreeNode left, TreeNode right){
        return invert(right,left);
    }
    public boolean isValidTree(TreeNode root, long max,long min){
        if (root==null) return true;
        if (root.data<=min || root.data>=max) return false;
        return isValidTree(root.left,root.data,min) && isValidTree(root.right,max,root.data);
    }
   public void preOrderTraversal(TreeNode root){
        if(root==null) return;
       System.out.print(root.data+" ");
       preOrderTraversal(root.left);
       preOrderTraversal(root.right);
   }
   public  void postOrderTraversal(TreeNode root){
        if (root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
       System.out.print(root.data+" ");
   }
   public void inOrderTraversal(TreeNode root){
       if (root==null) return;
       inOrderTraversal(root.left);
       System.out.print(root.data+" ");
       inOrderTraversal(root.right);
   }
}
