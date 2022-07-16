package interviewbit.math;

import java.util.ArrayList;
import java.util.Collections;

/*
Given a number N, find all factors of N.
Example:
N = 6
factors = {1, 2, 3, 6}
Make sure the returned array is sorted.

Problem Approach:
VIDEO : https://www.youtube.com/watch?v=dolcMgiJ7I0
Complete code in the hint.
 */
public class AllFactors {
    public static void main(String[] args) {
        System.out.println(solveAllFactors(12));
    }

    public static ArrayList<Integer> solveAllFactors(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                result.add(i);
                if (i != Math.sqrt(A)) {
                    result.add(A/i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
