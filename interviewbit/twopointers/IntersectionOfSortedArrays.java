package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays,
find all the elements which occur in both the arrays.

Example:
Input:
    A: [1 2 3 3 4 5 6]
    B: [3 3 5]
Output: [3 3 5]

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 5]
Output: [3 5]

NOTE : For the purpose of this problem ( as also conveyed by the sample case ),
assume that elements that appear more than once in both arrays should be included multiple times in the final output.
 */
public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        System.out.println(intersect(List.of(1, 2, 3, 3, 4, 5, 6), List.of(3, 3, 5)));
    }

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            int eA = A.get(i);
            int eB = B.get(j);

            if(eA < eB) {
                i++;
            } else if (eA > eB) {
                j++;
            } else {
                result.add(eA);
                i++;
                j++;
            }
        }
        return result;
    }
}
