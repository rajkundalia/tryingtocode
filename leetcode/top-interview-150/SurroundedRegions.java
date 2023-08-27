package leetcode.topinterview150;

import java.util.Arrays;

/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:

Input: board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
Output: [['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [['X']]
Output: [['X']]
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    /*
        We will start by traversing all the boundaries of the board. Hence, we will go for a depth-first search
        on the top row and bottom row cells and mark all cells that have value as ‘O’ to ‘#’.
        Repeat the same step for the first and the last column.

        Once we are done with the modifications, we will process each cell in the grid and change the cell value to ‘X’
        if it’s value is ‘O’ and to ‘O’ if it’s value is ‘#’.
     */
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                DFS(board, 0, i);
            if (board[board.length - 1][i] == 'O')
                DFS(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                DFS(board, i, 0);
            if (board[i][board[0].length - 1] == 'O')
                DFS(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }

    private void DFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = '#';
        DFS(board, i + 1, j);
        DFS(board, i - 1, j);
        DFS(board, i, j + 1);
        DFS(board, i, j - 1);

    }
}
