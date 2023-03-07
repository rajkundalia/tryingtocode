package interviewbit.dynamicprogramming;

import java.util.Arrays;

/*
Find out the number of N digit numbers, whose digits on being added equals to a given number S.
Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

 N = 2, S = 4
 Valid numbers are {22, 31, 13, 40}
 Hence output 4.
 */
public class NDigitNumbersWithDigitSumS {
    public static void main(String[] args) {
        System.out.println(new NDigitNumbersWithDigitSumS().solve(2, 4));
    }

    int M = 1000000007;

    public int solve(int N, int S) {
        //dp[i][j] will mean, possible numbers with i digits and j sum
        int[][] dp = new int[N + 1][S + 1];

        //initialize with -1
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        //initialize answer 0
        int ans = 0;

        //The first digit cannot be 0 so we are looping from 1 to 9 here
        //Then we are calling our helper function to find the count of numbers with digits (A-1) and sum (B-i)
        for (int i = 1; i <= 9; i++) {
            ans = (ans % M + calcHelper(N - 1, S - i, dp) % M) % M;
        }

        return ans;

    }

    //return count of numbers with N digits which sum up to "sum"
    private int calcHelper(int n, int sum, int[][] dp) {
        //If sum becomes less than 0, return 0
        if (sum < 0) {
            return 0;
        }

        //If number of remaining digits is 0, check if remaining sum is 0
        if (n == 0) {
            //if sum is 0, return 1
            if (sum == 0) {
                return 1;
            }
            //else return 0
            else {
                return 0;
            }
        }

        //dp[n][sum] has not been calculated
        if (dp[n][sum] == -1) {

            //initialize count to 0
            int count = 0;
            //Loop from 0 to 9 this time because we have already handled the first digit in the main method
            //The other digits can be from [0-9]
            for (int i = 0; i <= 9; i++) {
                //For each digit, call helper function recursively with one digit less,
                // and sum less by i which is the current digit being chosen
                count = (count % M + calcHelper(n - 1, sum - i, dp) % M) % M;
            }
            dp[n][sum] = count;

        }

        return dp[n][sum];
    }

}

/*
DP is made for two important elements in a problem - Optimal Substructure and Overlapping Subproblems.
First we try to express our problem in a subproblem. If we observe that in a N-digit number if you fix the first digit to be x,
then we have to solve for solution of problem where we have (N-1) digits and (SUM - x) to be sum of the rest of the digits.

In these way we can express our solution as,
SOLUTION(N, SUM) = SUM OF SOLUTION(N-1, SUM - x),
for 0 <= x <= N.
Here, SUM is sum of the digits.
Clearly we can use recursion to solve the above problem but solution for same number of digits with the same sum would be repeated.
One way to verify this is to draw a recursion tree. Now we can see that we have an optimal substructure from above equation and overlapping subproblems too.

Also notice that, for any N-digit number with SUM = 0 we can have one number as its solution, that is SOLUTION(N, 0) = 1, N >= 0.
We would never have any 0-digit number with SUM > 0, therefore,
SOLUTION(0, SUM) = 0, SUM > 0.
Now we can decide to use DP. In DP we can either tabulate the results or memoized them. I am using the first approach, you can have a table/2D array of size
N + 1, SUM + 1, to accomodate above two corner cases and intermediate solutions. In my code I am ignoring the case to fix the leading 0 in our N-digit number,
clearly a leading 0 with rest of the N-1 digits would be considered as N - 1 digit number instead of N-digit number.
 */