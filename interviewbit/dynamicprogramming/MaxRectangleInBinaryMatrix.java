package interviewbit.dynamicprogramming;

import java.util.Arrays;
import java.util.Stack;

/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0
    ]

Output : 4

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
 */
public class MaxRectangleInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new MaxRectangleInBinaryMatrix().maximalRectangle(new int[][]{
                {1, 1, 1},
                {0, 1, 1},
                {1, 0, 0}
        }));
//        System.out.println(new MaxRectangleInBinaryMatrix().maximalRectangle(new int[][]{
//                {1}
//        }));
//        System.out.println(new MaxRectangleInBinaryMatrix().maximalRectangle(new int[][]{
//                {1},
//                {0},
//                {0}
//        }));
    }

    // DRAW DIAGRAM IN TERMS OF HISTOGRAM TO UNDERSTAND THE SOLUTION
    public int maximalRectangle(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int m = A.length;
        int n = A[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int max = 0;

        for (int i = 0; i < m; i++) {
            int curleft = 0;
            int curright = n;

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    left[j] = Math.max(left[j], curleft);
                } else {
                    left[j] = 0;
                    curleft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (A[i][j] == 1) {
                    right[j] = Math.min(right[j], curright);
                } else {
                    right[j] = n;
                    curright = j;
                }
            }
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }

        return max;
    }
}
