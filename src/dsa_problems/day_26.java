package dsa_problems;

import java.util.ArrayList;
import java.util.List;

public class day_26 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiral_matrix(arr));
    }
    public static List<Integer> spiral_matrix(int[][]arr){
        List<Integer> result = new ArrayList<>();
        int top = 0; int bottom = arr.length-1;
        int left = 0; int right = arr[0].length-1;
        while(top<=bottom&&left<=right) {
            for (int col = left; col <= right; col++) {
                result.add(arr[top][col]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                result.add(arr[row][right]);
            }
            right--;
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(arr[bottom][col]);
                }
                bottom--;
            }
            if (right <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(arr[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}
