package leetcode.topinterview150;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */
public class WordSearch {
    public static void main(String[] args) {
        System.out.println(new WordSearch()
                .exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;

        visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean searchWord(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (searchWord(i + 1, j, index + 1, board, word) ||
                searchWord(i - 1, j, index + 1, board, word) ||
                searchWord(i, j + 1, index + 1, board, word) ||
                searchWord(i, j - 1, index + 1, board, word)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }
}
