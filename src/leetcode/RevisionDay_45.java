package leetcode;
import dsa_topics.TreeNode;

import java.util.Arrays;
public class RevisionDay_45 {
    // leetcode 435
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            int count = 0;
            int lastEnd = intervals[0][1];
            for(int i = 1; i<intervals.length; i++){
                if(intervals[i][0]<lastEnd){
                    count++;
                    lastEnd = Math.min(intervals[i][1],lastEnd);
                }else{
                    lastEnd = intervals[i][1];
                }
            }
            return count;
        }
        // beats 59.02%
    // leetcode 572
        public boolean isSame(TreeNode root, TreeNode subRoot){
            if(root==null&&subRoot==null) return true;
            if(root==null||subRoot==null) return false;
            if(root.data!=subRoot.data) return false;
            return isSame(root.right,subRoot.right)&&isSame(root.left,subRoot.left);
        }
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(subRoot==null) return true;
            if(root==null) return false;
            if(isSame(root,subRoot)) return true;
            return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
        }
        // beats 99%
}

