package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
Given an array ‘A’ of sorted integers and another non negative integer k,
find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
Example:
Input :
    A : [1 3 5]
    k : 4
Output : YES
as 5 - 1 = 4
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
Try doing this in less than linear space complexity.
 */
public class DiffK {
    public static void main(String[] args) {
        System.out.println(diffPossible(new ArrayList<>(List.of(1, 5, 6, 7)), 1));
    }

    public static int diffPossible(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = 1;
        int n = A.size();
        while (i < n && j < n) {
            if (i != j && (A.get(j) - A.get(i) == B)) {
                return 1;
            } else if (A.get(j) - A.get(i) < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }
}
