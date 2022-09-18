package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array A consisting of duplicate elements.
Your task is to remove all the duplicates and return the length of sorted array of
distinct elements consisting of all distinct elements present in A.

Input Format
First and only argument containing the integer array A.

Output Format
Return a single integer, as per the problem given.

Example Input
Input 1:
A = [1, 1, 2]
Input 2:
A = [1, 2, 2, 3, 3]
Example Output
Output 1:
2
Output 2:
3

Example Explanation
Explanation 1:
Updated Array: [1, 2, X] after rearranging. Note that there could be any number in place of x since we dont need it.
We return 2 here.
Explanation 2:
Updated Array: [1, 2, 3, X, X] after rearranging duplicates of 2 and 3.
We return 3 from here.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new ArrayList<>(List.of(1, 2, 2, 3, 3))));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (j == -1 || (a.get(i) - a.get(j) != 0)) {
                j++;
                a.set(j, a.get(i));
            }
        }
        return j + 1;
    }
}
