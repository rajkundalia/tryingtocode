package interviewbit.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
Input Format:
The first and the only argument contains an integer, A.

Output Format:
Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:

1 <= A <= 1000
Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
 */
public class SpiralOrderMatrixII {
    public static void main(String[] args) {
        System.out.println(solveSpiralOrderMatrixII(3));
    }

    private static ArrayList<ArrayList<Integer>> solveSpiralOrderMatrixII(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(A, 0));
            result.add(temp);
        }
        int rowS = 0;
        int colS = 0;
        int rowE = A - 1;
        int colE = A - 1;
        int count = 1;
        while (rowS <= rowE && colS <= colE) {
            // 1st row
            for (int i = colS; i <= colE; i++) {
                result.get(rowS).set(i, count);
                count++;
            }
            rowS++;
//            System.out.println(result);

            // last column
            for (int i = rowS; i <= rowE; i++) {
                result.get(i).set(colE, count);
                count++;
            }
            colE--;
//            System.out.println(result);

            // last row
            if (colS <= colE) {
                for (int i = colE; i >= colS; i--) {
                    result.get(rowE).set(i, count);
                    count++;
                }
                rowE--;
            }
//            System.out.println(result);

            // 1st column
            if (rowS <= rowE) {
                for (int i = rowE; i >= rowS; i--) {
                    result.get(i).set(colS, count);
                    count++;
                }
                colS++;
            }
//            System.out.println(result);

        }
        return result;
    }
}
