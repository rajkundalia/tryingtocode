package interviewbit.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array A of size N consisting of unique integers from 1 to N. You can swap any two integers
at most B times.

Return the largest lexicographical value array that can be created by executing atmost B swaps.

Problem Constraints
1 <= N <= 106
1 <= B <= 109

Input Format
First argument is an integer array A of size N.
Second argument is an integer B.

Output Format
Return an integer array denoting the largest lexicographical value array that can be created by executing atmost B swaps.

Example Input
Input 1:
 A = [1, 2, 3, 4]
 B = 1
Input 2:
 A = [3, 2, 1]
 B = 2

Example Output
Output 1:
 [4, 2, 3, 1]
Output 2:
 [3, 2, 1]

Example Explanation
Explanation 1:
 In one swap we can swap (1, 4) so that the array becomes : [4, 2, 3, 1].
Explanation 2:
 Array is already the largest lexicographical value array.
 */
public class LargestPermutation {
    public static void main(String[] args) {
        Arrays.stream(new LargestPermutation().solve(new int[]{1, 2, 3, 4}, 1)).forEach(System.out::print);
    }

    public int[] solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        int i = 0;
        while (B != 0 && i < A.length) {
            if (A[i] != A.length - i) {
                int tempIndex = map.get(A.length - i);
                int temp = A[i];
                // swapping value inside the array
                A[i] = A[tempIndex];
                A[tempIndex] = temp;

                // swapping value inside the map
                map.put(A.length-i, i);
                map.put(A[tempIndex], tempIndex);
                B--;
            }
            // swap the number
            i++;
        }

        return A;
    }
}
