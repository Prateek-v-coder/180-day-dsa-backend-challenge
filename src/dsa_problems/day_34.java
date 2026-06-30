package dsa_problems;

public class day_34 {
    public static int numIceLand(char[][] grid){
        int count =0;
        int rows = grid.length;
        int column = grid[0].length;
        for (int i =0; i<rows; i++){
            for (int j =0; j<column; j++){
                if (grid[i][j]=='1'){
                    count++;
                    DFS(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void DFS(char[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j]='0';
        DFS(grid,i-1,j);
        DFS(grid,i+1,j);
        DFS(grid,i,j-1);
        DFS(grid,i,j+1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0'},
                         {'1','0','0','1'},
                         {'0','0','1','0'}};
        System.out.println(numIceLand(grid));
    }
}
