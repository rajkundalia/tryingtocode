package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = {{1,2,3},{4,5,6},{7,8,9}}
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) {
                break;
            }
        }
        return result;
    }
}
