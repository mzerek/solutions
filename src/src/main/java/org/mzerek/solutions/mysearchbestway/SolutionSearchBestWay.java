package org.mzerek.solutions.mysearchbestway;

/*
Find the best way to sum the highest value from the grid,
they only move up and right and start from bottom to top,
for example:
         {{0, 0, 0, 0, 5}, -> END
         {0, 1, 1, 1, 0},
START -> {2, 0, 0, 0, 0}}

example steps: 2 + 0 + 1 + 1 + 1 + 0 + 5 = 10
*/

public class SolutionSearchBestWay {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 5},
                        {0, 1, 1, 1, 0},
                        {2, 0, 0, 0, 0}};

        System.out.println("Max value: " + findBestWay(grid));
    }

    public static int findBestWay(int[][] grid) {

        int girdLength = grid.length;

        int[][] tmpGrid = new int[girdLength][grid[0].length];

        // tmpGrid how it should look like
        // int[][] tmpGrid = {{2, 3, 4, 5, 10},
        //                   {2, 3, 4, 5, 5},
        //                   {2, 2, 2, 2, 2}};

        for (int x = girdLength - 1; x >= 0; x--) {
            for (int y = 0; y < grid[x].length; y++) {
                if (x == girdLength - 1 && y == 0) {
                    tmpGrid[x][y] = grid[x][y];
                } else if (x == girdLength - 1) {
                    tmpGrid[x][y] = tmpGrid[x][y -1] + grid[x][y];
                } else if (y == 0) {
                    tmpGrid[x][y] = tmpGrid[x+1][y] + grid[x][y];
                } else {
                    tmpGrid[x][y] = Math.max(tmpGrid[x + 1][y], tmpGrid[x][y - 1]) + grid[x][y];
                }
                System.out.println(String.format("grid[%d][%d] = %d ", x, y, grid[x][y]));
                System.out.println(String.format("tmpGrid[%d][%d] = %d ", x, y, tmpGrid[x][y]));
                System.out.println(" ");
            }
        }

        return tmpGrid[0][grid[0].length - 1];
    }
}
