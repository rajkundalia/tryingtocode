package interviewbit.arrays;

import java.util.ArrayList;

/*
Given numRows, generate the first numRows of Pascal's triangle.
Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
Example:
Given numRows = 5,

Return:
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
Constraints:
0 <= numRows <= 25
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generatePascalTriangle(3));
    }

    public static ArrayList<ArrayList<Integer>> generatePascalTriangle(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == 0) {
            return result;
        }
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(nCr(i, j));
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static int nCr(int n, int r) {
        long result = 1;
        r = Math.min(r, n - r);
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int) result;
    }
}

