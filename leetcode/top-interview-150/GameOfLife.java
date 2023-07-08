package leetcode.topinterview150;

import java.util.Arrays;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:

Input: board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}}
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLife().gameOfLife(board);
        Arrays.stream(board).forEachOrdered(a -> Arrays.stream(a).forEachOrdered(System.out::println));
    }

    public void gameOfLife(int[][] board) {
        int R = board.length;
        int C = board[0].length;

        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int liveCount = 0;
                for(int k = 0; k < 8; k++) {
                    if(isSafe(i + dx[k], j + dy[k], R, C) && Math.abs(board[i + dx[k]][j + dy[k]]) == 1) {
                        liveCount++;
                    }
                }

                if(board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                }
                if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                board[i][j] = board[i][j] > 0? 1 : 0;
            }
        }
    }

    private boolean isSafe(int x, int y, int R, int C) {
        return (x >= 0 && x < R && y >= 0 && y < C);
    }
}
