package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1,
such that sum of all the elements in submatrix is maximum.

Input Format:
First arguement is an 2D integer matrix A.

Second argument is an integer B.

Output Format:
Return a single integer denoting the maximum sum of submatrix of size B x B.

Example Input
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:
 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2

Example Output
Output 1:
 48
Output 2:
 8

Example Explanation
Explanation 1:

    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:

 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8
 */

// This is taken from the tutorial and understood and not coded by myself.
// This is a DP problem
public class MaximumSumSquareSubMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(List.of(2, 2, 2, 2));

        ArrayList<Integer> list2 = new ArrayList<>(List.of(8, 6, 7, 3));

        ArrayList<Integer> list3 = new ArrayList<>(List.of(4, 4, 4, 4));

        ArrayList<Integer> list4 = new ArrayList<>(List.of(5, 5, 5, 5));

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(solveMaximumSumSquareSubMatrix(list, 2));
    }

    private static int res = Integer.MIN_VALUE;

    public static int solveMaximumSumSquareSubMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int startB = 0;
        int endB = B - 1;
        int[] sums = new int[A.size()];
        for (int i = 0; i < A.size(); ++i) {
            int sum = 0;
            for (int j = startB; j <= endB; ++j) {
                sum += A.get(i).get(j);
            }
            sums[i] = sum;
        }
        while (endB < A.size()) {
            calculateMax(sums, B);
            if (endB != A.size() - 1)
                for (int i = 0; i < A.size(); ++i) {
                    sums[i] -= A.get(i).get(startB);
                    sums[i] += A.get(i).get(endB + 1);
                }
            startB++;
            endB++;
        }
        calculateMax(sums, B);
        return res;

    }

    private static void calculateMax(int[] sums, int B) {
        int possible = 0;
        for (int i = 0; i < B; ++i) {
            possible += sums[i];
        }
        int i = 0;
        while (i < sums.length - B) {
            res = Math.max(res, possible);
            possible -= sums[i];
            possible += sums[i + B];
            i++;
        }
        res = Math.max(res, possible);
    }

}
