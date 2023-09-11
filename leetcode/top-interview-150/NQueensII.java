package leetcode.topinterview150;

import java.util.ArrayList;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 */
// https://youtu.be/ShHtKUC_HI0?si=CvxuHohPJrXYAqa8
public class NQueensII {
    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        return backtrack(board, 0, result);
    }

    private int backtrack(boolean[][] board, int row, ArrayList<ArrayList<String>> result) {
        int count = 0;
        if (row == board.length) {
            ArrayList<String> res = insert(board);
            result.add(res);
            return 1;
        }

        // Placing Queens and Checking for every row and column
        for (int col = 0; col < board.length; col++) {
            // place if queen is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += backtrack(board, row + 1, result);
                board[row][col] = false;
            }
        }
        return count;
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
