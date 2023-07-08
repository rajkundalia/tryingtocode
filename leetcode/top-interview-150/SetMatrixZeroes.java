package leetcode.topinterview150;

import java.util.Arrays;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:

Input: matrix = {{1,1,1},{1,0,1},{1,1,1}}
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1},
                          {1, 0, 1},
                          {1, 1, 1}};
        new SetMatrixZeroes().setZeroes(matrix);
        Arrays.stream(matrix).forEachOrdered(a -> Arrays.stream(a).forEachOrdered(System.out::println));
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 1 && columns == 1) {
            return;
        }

        boolean firstColumnZero = false;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
            }

            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstColumnZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
