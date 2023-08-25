package leetcode.topinterview150;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of
islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    // this implementation is DFS based and not BFS since you make recursive call for each adjacent node
    // and in turn their children instead of processing all adjacent nodes and then process the same of their children.
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void callDFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        callDFS(grid, i + 1, j);
        callDFS(grid, i - 1, j);
        callDFS(grid, i, j - 1);
        callDFS(grid, i, j + 1);
    }
}
