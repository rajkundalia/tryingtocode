package interviewbit.math;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given a number A in a form of string.
You have to find the smallest number that has same set of digits as A and is greater than A.
If A is the greatest possible number with its set of digits, then return -1.

Problem Constraints
 1 <= A <= 10100000
 A doesn't contain leading zeroes.

Input Format
First and only argument is an numeric string denoting the number A.

Output Format
Return a string denoting the smallest number greater than A with same set of digits,
if A is the largest possible then return -1.

Example Input
Input 1:
 A = "218765"
Input 2:
 A = "4321"

Example Output
Output 1:
 "251678"
Output 2:
 "-1"

Example Explanation
Explanation 1:
 The smallest number greater then 218765 with same set of digits is 251678.
Explanation 2:
 The given number is the largest possible number with given set of digits so we will return -1.
 */
// Refer NextPermutation of Array in Interviewbit for explanation.
//https://github.com/rajkundalia/tryingtocode/blob/master/interviewbit/arrays/NextPermutation.java
public class NextSimilarNumber {

    public static void main(String[] args) {
        System.out.println(solveNextSimilarNumber("1734965109968348499255"));
        System.out.println(solveNextSimilarNumber("903885770893074783710083450145620356667677191627276513995926532"));
    }

    public static String solveNextSimilarNumber(String A) {
        int n = A.length();
        int[] numbers = new int[n];
        String[] text = A.split("");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(text[i]);
        }
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return "-1";
        }

        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        for (int i = index + 1; i < n; i++) {
            // There is a difference off = or equal to in condition below when compared with Next Permutation of array section
            // and that is because if the last 2 digits are similar in the example 1734965109968348499255
            // find next smallest but greater element of deep position number
            if (numbers[i] > numbers[index] && numbers[i] - numbers[index] <= minDiff) {
                minDiff = numbers[i] - numbers[index];
                minDiffIndex = i;
            }
        }
        swap(numbers, index, minDiffIndex);
        int x = index + 1;
        int y = n - 1;
        while (x < y) {
            swap(numbers, x, y);
            x++;
            y--;
        }
        String ans = "";
        for (int i : numbers) {
            ans += i;
        }
        return ans;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
