package interviewbit.math;

import java.util.ArrayList;

/*
Given a number N, find all prime numbers upto N ( N included ).
Example:
if N = 7, all primes till 7 = {2, 3, 5, 7}
Make sure the returned array is sorted.

Problem Approach:
Complete code in the hint.
Java Program for Sieve of Eratosthenes
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println(sieve(7));
    }

    public static ArrayList<Integer> sieve(int A) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] array = new boolean[A + 1];

        for (int i = 2; i < array.length; i++) {
            array[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (array[i] == true) {
                for (int j = 2; i * j <= A; j++) {
                    array[i * j] = false;
                }
            }
        }

        for (int i = 2; i <= A; i++) {
            if (array[i] == true) {
                result.add(i);
            }
        }

        return result;
    }

}
