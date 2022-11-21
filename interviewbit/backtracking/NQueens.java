package interviewbit.backtracking;

import java.util.ArrayList;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.'
both indicate a queen and an empty space respectively.

For example,

There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        boolean[][] board = new boolean[a][a];
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }

    private static void backtrack(boolean[][] board, int row, ArrayList<ArrayList<String>> result) {
        if (row == board.length) {
            ArrayList<String> res = insert(board);
            result.add(res);
            return;
        }

        // Placing Queens and Checking for every row and column
        for (int col = 0; col < board.length; col++) {
            // place if queen is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                backtrack(board, row + 1, result);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // Left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Right diagonal
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<String> insert(boolean[][] board) {
        ArrayList<String> ans = new ArrayList<>();
        for (boolean[] row : board) {
            String s = "";
            for (boolean element : row) {
                if (element) {
                    s += "Q";
                } else {
                    s += ".";
                }
            }
            ans.add(s);
        }
        return ans;
    }
}
