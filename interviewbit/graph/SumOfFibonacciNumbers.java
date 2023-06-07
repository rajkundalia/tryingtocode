package interviewbit.graph;

import java.util.TreeSet;

/*
How many minimum numbers from the Fibonacci series are required such that the sum of numbers
should be equal to a given Number A?

Note: repetition of numbers is allowed.

Problem Constraints
1 <= A <= 109

Input Format
The first argument is an integer A.

Output Format
Return an integer equal to the minimum number of Fibonacci numbers whose sum is equal to A

Example Input
Input 1:
A = 4
Input 2:
A = 7

Example Output
Output 1:
2
Output 2:
2

Example Explanation
Explanation 1:
Two numbers are required, A = 4 which is equal to (2 + 2)
Explanation 2:
Two numbers are required, A = 7 which is equal to (2 + 5)
 */

// First store all fibonacci numbers less than or equal to A in a treeSet
//increment move in ech iteration and check if set contains A //
//otherwise A=A-fib.lower()

public class SumOfFibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(new SumOfFibonacciNumbers().fibsum(4));
    }

    public int fibsum(int A) {
        if (A == 1) {
            return 1;
        }
        if (A == 0) {
            return 0;
        }

        int a = 1;
        int b = 1;
        int c = 1;
        TreeSet<Integer> fib = new TreeSet<>();

        fib.add(1);
        while (c + b <= A) {
            a = c + b;
            b = c;
            c = a;
            fib.add(a);
        }

        if (fib.contains(A)) {
            return 1;
        }
        int move = 1;
        while (A > 1) {
            move++;
            if (fib.lower(A) != null) {
                A = A - fib.lower(A);
                // subtracts greatest lower element than A in tree set from A
            }
            if (fib.contains(A))
                return move;
        }
        return move;
    }
}
