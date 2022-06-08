package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted.
If A is already sorted, output -1.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000

Input Format
First and only argument is an array of non-negative integers of size N.

Output Format
Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.

Example Input
Input 1:
A = [1, 3, 2, 4, 5]
Input 2:
A = [1, 2, 3, 4, 5]

Example Output
Output 1:
[1, 2]
Output 2:
[-1]
 */
public class MaximumUnsortedArray {
    public static void main(String[] args) {
        System.out.println(solveMaximumUnsortedArray(new ArrayList<>(List.of(1, 3, 2, 4, 5))));
    }

    public static ArrayList<Integer> solveMaximumUnsortedArray(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<>(A);
        Collections.sort(B);
        ArrayList<Integer> result = new ArrayList<>();
        int l = -1;
        int r = -1;
        int n = A.size();

        // find index of non-matching from start to end
        for (int i = 0; i < n; i++) {
            if (A.get(i) != B.get(i)) {
                l = i;
                break;
            }
        }
        if (l == -1) {
            result.add(-1);
            return result;
        }

        // find index of non-matching from end to start
        for (int i = n - 1; i >= 0; i--) {
            if (A.get(i) != B.get(i)) {
                r = i;
                break;
            }
        }
        if (r == -1) {
            result.add(-1);
            return result;
        }

        result.add(l);
        result.add(r);
        return result;
    }
}
