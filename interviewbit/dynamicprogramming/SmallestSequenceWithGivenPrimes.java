package interviewbit.dynamicprogramming;

import java.util.ArrayList;

/*
Given three prime numbers A, B and C and an integer D.

You need to find the first(smallest) D integers which only have A, B, C or a combination of them as their prime factors.

Input Format
First argument is an integer A.
Second argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer D.

Output Format
Return an array of size D denoting the first smallest D integers which only have
A, B, C or a combination of them as their prime factors.

NOTE: You need to return the array sorted in ascending order.

Example Input
Input 1:
 A = 2
 B = 3
 C = 5
 D = 5

Example Output
Output 1:
 [2, 3, 4, 5, 6]

Example Explanation
Explanation 1:
 4 = A * A i.e ( 2 * 2 )
 6 = A * B i.e ( 2 * 3 )
 */
public class SmallestSequenceWithGivenPrimes {
    public static void main(String[] args) {
        System.out.println(new SmallestSequenceWithGivenPrimes().solve(2, 3, 5, 5));
    }

    public ArrayList<Integer> solve(int A, int B, int C, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);

        int i = 0;
        int j = 0;
        int k = 0;

        while (n-- > 0) {
            int x = Math.min(result.get(i) * A, Math.min(result.get(j) * B, result.get(k) * C));
            result.add(x);

            if (x == result.get(i) * A) {
                i++;
            }
            if (x == result.get(j) * B) {
                j++;
            }
            if (x == result.get(k) * C) {
                k++;
            }
        }
        result.remove(0);

        return result;
    }
}
