package dsa_problems;

public class day_25 {
    public static void main(String[] args) {
       String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
    }
    public static boolean match(char[][]board,String word,int row,int column,int index){
        if(row>=board.length||row<0||column>=board[0].length||column<0) return false;
        if(board[row][column]!=word.charAt(index)) return false;
        if(index==word.length()-1) return true;
        char temp = board[row][column];
        board[row][column] = '#';
        boolean mached = match(board,word,row,column+1,index+1)||match(board,word,row,column-1,index+1)|| match(board,word,row+1,column,index+1)||match(board,word,row-1,column,index+1);
        board[row][column] = temp;
        return mached;
    }
    public static boolean exist(char[][] board, String word) {
        for(int row = 0; row<board.length; row++){
            for(int column = 0; column<board[0].length; column++){
                if(match(board,word,row,column,0)) return true;
            }
        }
        return false;
    }
}
