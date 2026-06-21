package development_topics;

import java.util.ArrayList;
import java.util.List;

public class _2DArrays {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},
//                           {4,5,6},
//                           {7,8,9}};
////        for (int  i =0; i<arr.length; i++){
////            for (int j = 0; j<arr[i].length; j++){
////                System.out.print(arr[i][j]);
////            }
////            System.out.println();
////        }
////        int row1 = 1;
////        int column1 = 1;
////        System.out.print(arr[row1-1][column1]+" ");
////        System.out.print(arr[row1+1][column1]+" ");
////        System.out.print(arr[row1][column1-1]+" ");
////        System.out.print(arr[row1][column1+1]+" ");
//        int[][] matrix1 = {{1,2,3,4,5,6},
//                          {7,8,9,10,11,12},
//                          {13,14,15,16,17,18},
//                          {19,20,21,22,23,24},
//                          {25,26,27,28,29,30},
//                          {31,32,33,34,35,36}};
//        int[] rowDir ={-1,1,0,0};
//        int[] colDir = {0,0,-1,1};
        // print all grid
//        for (int row =0; row<matrix.length; row++){
//            for (int column = 0; column<matrix[row].length; column++){
//              for (int d = 0; d<4; d++){
//                  int newRow = row+rowDir[d];
//                  int newCol = column+colDir[d];
//                  if(newRow>=0&&newRow<matrix.length&&newCol>=0&&newCol<matrix.length){
//                      System.out.print(matrix[newRow][newCol]+" ");
//                  }
//              }
//                System.out.println();
//
//            }
//            System.out.println();
//        }
        // sum of all grods
//        for (int row = 0; row<matrix.length; row++){
//            for (int column = 0; column<matrix[row].length; column++){
//                int sum = 0;
//                for (int d = 0; d<4; d++){
//                    int newRow = row+rowDir[d];
//                    int newCol = column+colDir[d];
//                    if(newRow>=0&&newRow<matrix.length&&newCol>=0&&newCol<matrix.length){
//                        sum+=matrix[newRow][newCol];
//                    }
//                }
//                System.out.println(sum);
//            }
       // }
        // print Diagonal elements
//        for (int row = 0; row<matrix.length; row++){
//            for (int column = 0; column<matrix[row].length; column++){
//                if (row==column){
//                    System.out.println(matrix[row][column]);
//                }
//            }
//        }
        // TRANSPOSE grid row to column
//        for (int row = 0; row<matrix.length; row++){
//            for (int column = row+1; column<matrix[row].length;column++){
//                int temp = matrix[row][column];
//                matrix[row][column]=matrix[column][row];
//                matrix[column][row]=temp;
//            }
//        }
//        for (int row = 0; row<matrix.length; row++){
//            for (int column = 0; column<matrix[row].length;column++){
//                System.out.print(matrix[row][column]+" ");
//            }
//            System.out.println();
//        }
//        char[][] board = {
//                {'A','B','C'},
//                {'S','F','C'},
//                {'A','D','E'}
//        };
//
//        String word = "AS";
//
//        // STEP 1: KYA board[0][0] == word[0] ('A')?
//        boolean step1 = board[0][0] == word.charAt(0);
//
//        // STEP 2: KYA board[1][0] == word[1] ('S')?
//        boolean step2 = board[1][0] == word.charAt(1);
//
//        System.out.println(step1);  // ?
//        System.out.println(step2);  // ?
//        System.out.println(step1 && step2);
        List<Integer> result = new ArrayList<>();
        int[][] arr = {{1,4,7},{2,5,8},{3,6,9}};
        for (int i= 0; i<arr.length; i++){
            for(int j =i+1; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for (int i= 0; i<arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
