package interviewbit.strings;

/*
There are certain questions where the interviewer would intentionally frame the question vague.

The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.

Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

Questions:

Q1. Does string contain whitespace characters before the number?

A. Yes

Q2. Can the string have garbage characters after the number?

A. Yes. Ignore it.

Q3. If no numeric character is found before encountering garbage characters, what should I do?

A. Return 0.

Q4. What if the integer overflows?

A. Return INT_MAX if the number is positive, INT_MIN otherwise.

Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.

If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class ATOI {
    public static void main(String[] args) {
        System.out.println(atoi("9 2704"));
    }

    public static int atoi(final String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        String a = A.trim();

        double result = 0.0;
        int flag = 0;
        int i = 0;
        if (a.charAt(0) == '-') {
            flag = 1;
            i++;
        } else if (a.charAt(0) == '+') {
            i++;
        }

        while (i < a.length() && a.charAt(i) >= '0' && a.charAt(i) <= '9') {
            result = result * 10 + (a.charAt(i) - '0');
            i++;
        }

        if (flag == 1) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
