package main.java.org.mzerek.solutions.algorithms_03.search;

/*
Find the best way to sum the highest value from the grid,
they only move up and right and start from bottom to top,
for example:
         {{0, 0, 0, 0, 5}, -> END
         {0, 1, 1, 1, 0},
START -> {2, 0, 0, 0, 0}}

example steps: 2 + 0 + 1 + 1 + 1 + 0 + 5 = 10
*/

public class SearchInGrid {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 5, 0, 5},
                        {0, 1, 1, 1, 0},
                        {2, 0, 0, 0, 0}};

                        // {{2, 3, 9, 9, 14},
                       //  {2, 3, 4, 5, 5},
                      //   {2, 2, 2, 2, 2}};
        System.out.println("Max value: " + searchSumInGridFromBottomToTop(grid));

                            // {{10,  10,  10,  5, 5},
                            //  {12,  12,  11,  6, 5},
                           //   {14,  12,  11,  6, 5}};

        System.out.println("Max value: " + searchSumInGridFromTopToBottom(grid));
    }

    //down and left
    public static int searchSumInGridFromTopToBottom(int[][] grid){
        int[][] tmpGrid = new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=grid[0].length-1; j>=0; j--){
                if(i==0 && j==grid[0].length-1) {
                    tmpGrid[i][j] = grid[i][j];
                }
                else if(i==0) {
                    tmpGrid[i][j] = tmpGrid[i][j+1] + grid[i][j];
                }
                else if (j == grid[0].length-1) {
                    tmpGrid[i][j] = tmpGrid[i-1][j] + grid[i][j];
                }
                else {
                    tmpGrid[i][j] = Math.max(tmpGrid[i-1][j], tmpGrid[i][j+1])+ grid[i][j];
                }
                //System.out.println(String.format("grid[%d][%d] = %d ", i, j, grid[i][j]));
                //System.out.println(String.format("tmpGrid[%d][%d] = %d ", i, j, tmpGrid[i][j]));
            }
        }
        return tmpGrid[tmpGrid.length-1][0];
    }

    //up and right
    public static int searchSumInGridFromBottomToTop(int[][] grid){
        int[][] tmpGrid = new int[grid.length][grid[0].length];

        for(int i=grid.length-1; i>=0; i--){
            for(int j=0; j<grid[i].length; j++){
                if(i==grid.length-1 && j==0){
                    tmpGrid[i][j] = grid[i][j];
                } else if(i==grid.length-1){
                    tmpGrid[i][j] = tmpGrid[i][j-1] + grid[i][j];
                } else if (j==0) {
                    tmpGrid[i][j] = tmpGrid[i+1][j] + grid[i][j];
                }
                else {
                    tmpGrid[i][j] = Math.max(tmpGrid[i+1][j], tmpGrid[i][j-1]) + grid[i][j];
                }
                //System.out.println(String.format("grid[%d][%d] = %d ", i, j, grid[i][j]));
                //System.out.println(String.format("tmpGrid[%d][%d] = %d ", i, j, tmpGrid[i][j]));
                //System.out.println(" ");
            }
        }
        return tmpGrid[0][tmpGrid[0].length - 1];
    }
}
