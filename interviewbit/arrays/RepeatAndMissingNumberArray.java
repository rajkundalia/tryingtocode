package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Repeat and Missing Number Array

There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places.
Try to verify if your solution works if number of elements is as large as 10^5

Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.
Example:
Input:[3, 1, 2, 5, 3]

Output:[3, 4]

A = 3, B = 4
 */
public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {
        System.out.println(solveRepeatAndMissingNumberArray(List.of(3, 1, 2, 5, 3)));
    }

    /*
        Explanation:
        [3, 1, 2, 5, 3] => sum1 = 14
        array that should be -> [1,2,3,4,5] => sum2 = 15
        Remove all the common elements then remaining would be:
        missing(y) i.e. 4 and repeated(x) i.e. 3
        if we think about it, sum2 - sum1 is actually missing - repeating

        how to find sum1 - sum2:
        sum = sum + (i+1) - a[i]
        This is actually y - x = sum
        here sum = 1

        Similarly, squaring all elements in array and subtracting the sum of both i.e.
        Given array square: 9,1,4,25,9
        array that should be: 1,4,9,16,25

        If we subtract the sum of all of them, we essentially would get something like 16-9 which is
        missing^2 - repeating^2 or y^2 - x^2.

        how to find sum1^2 - sum2^2
        squaresum = squaresum + (i+1)^2 - val^2
        y^2 - x^2 = squaresum
        here squaresum = 7

        we know that x2-y2 = (x-y)(x+y)
        therefore x+y = 7

        y = [y-x + y+x]/2
        since we have y-x and y+x, we can get the answer
     */
    public static ArrayList<Integer> solveRepeatAndMissingNumberArray(final List<Integer> A) {
        long sum = 0;
        long squareSum = 0;

        for (int i = 0; i < A.size(); i++) {
            sum = sum + (i + 1) - A.get(i);
            squareSum = squareSum + ((long) (i + 1) * (i + 1)) - ((long) A.get(i) *A.get(i));
        }

        long yMinusX = sum;
        long yPlusX = squareSum / sum;

        long y = (yMinusX + yPlusX) / 2;

        long x = y - sum;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) x);
        ans.add((int) y);
        return ans;
    }
}
