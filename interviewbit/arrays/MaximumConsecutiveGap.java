package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow
 */
public class MaximumConsecutiveGap {
    public static void main(String[] args) {
        System.out.println(solveMaximumConsecutiveGapFirstApproach(new ArrayList<>(List.of(1, 10, 5))));
    }

    public static int solveMaximumConsecutiveGapFirstApproach(final List<Integer> A) {
        Collections.sort(A);
        if (A.size() < 2) {
            return 0;
        }
        int diff = Integer.MIN_VALUE;
        for (int i = A.size() - 1; i > 0; i--) {
            diff = Math.max(diff, (A.get(i) - A.get(i - 1)));
        }
        return diff;
    }
}
