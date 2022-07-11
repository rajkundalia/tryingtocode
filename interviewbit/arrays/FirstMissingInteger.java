package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an unsorted integer array, find the first missing positive integer.
Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {
    public static void main(String[] args) {
        System.out.println(solveFirstMissingInteger(new ArrayList<>(List.of(1, 2, 0))));
        System.out.println(solveFirstMissingInteger(new ArrayList<>(List.of(3, 4, -1, 1))));
        System.out.println(solveFirstMissingInteger(new ArrayList<>(List.of(-8, -7, -6))));
    }


    public static int solveFirstMissingInteger(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0 && A.get(i) <= n) {
                int pos = A.get(i) - 1;
                if (A.get(pos) != A.get(i)) {
                    swap(A, i, pos);
                    i--;
                    // so that loop starts from last set element being set at current position
                    // i.e. (element - 1) after swap
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
