package interviewbit.math;

import java.util.ArrayList;

/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s  conjecture
Example:
Input : 4
Output: 2 + 2 = 4

If there are more than one solution possible, return the lexicographically smaller solution.
If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then
[a, b] < [c, d]
If a < c OR a==c AND b < d.

Java Program for Sieve of Eratosthenes
 */
public class PrimeSum {
    public static void main(String[] args) {
        System.out.println(solvePrimeSum(10));
    }

    public static ArrayList<Integer> solvePrimeSum(int A) {
        boolean[] markPrime = new boolean[A + 1];
        for (int i = 2; i < markPrime.length; i++) {
            markPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (markPrime[i]) {
                for (int j = 2; i * j <= A; j++) {
                    markPrime[i * j] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i < markPrime.length; i++) {
            if (markPrime[i] && markPrime[A - i]) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }
        return result;
    }
}
