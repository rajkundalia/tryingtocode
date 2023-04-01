package interviewbit.dynamicprogramming;

import java.util.Arrays;

/*
Given an array A with non-negative numbers, divide the array into two parts such that the average
of both the parts is equal.

Return both parts (If exist). If there is no solution. return an empty list.
NOTE:
If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition :

numElements in A <= numElements in B
If numElements in A = numElements in B, then A is lexicographically smaller than B ( Lexicographical Order )
If multiple solutions exist, return the solution where length(A) is minimum.
If there is still a tie, return the one where A is lexicographically smallest.

The array will contain only non-negative numbers.

Problem Constraints
1 <= |A| <= 100
0 <= Ai <= 100
0 <= Σ(Ai) <= 5000

Input Format
First and only argument is an integer array A.

Output Format
Return 2D array consisting of two rows where each row denoted a partition.

Example Input
Input 1:
 A = [1 7 15 29 11 9]

Example Output
Output 1:
 [9 15] [1 7 11 29]

Example Explanation
Explanation 1:
 The average of part is (15+9)/2 = 12, average of second part elements is (1 + 7 + 11 + 29) / 4 = 12
 */
public class EqualAveragePartition {
    public static void main(String[] args) {
        System.out.println(new EqualAveragePartition().avgset(new int[]{1, 7, 15, 29, 11, 9}));
    }

    /*
        Explanation:
        make 2 arrays out of A

        s1/n1 = s2/n2
        s1/n1 = (S-s1)/(n-n1)
        s1 = S x n1/n

     */
    public int[][] avgset(int[] A) {
        int n = A.length;
        int[][] ans = new int[2][0];
        if (n == 0)
            return ans;
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }

        boolean[][][] dp = new boolean[n + 1][sum + 1][n + 1];
        dp[n][0][0] = true;

        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (A[i] == 0) {
                count++;
            }
            for (int j = 0; j <= count; j++) {
                dp[i][0][j] = true;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= sum; j++) {
                for (int k = 1; k <= n - i; k++) {
                    boolean bool = dp[i + 1][j][k];
                    if (j - A[i] >= 0)
                        bool = bool | dp[i + 1][j - A[i]][k - 1];
                    dp[i][j][k] = bool;
                }
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            int w = sum * i;
            if (w % n != 0)
                continue;
            w = w / n;
            if (dp[0][w][i]) {
                int[] a1 = new int[i];
                int[] a2 = new int[n - i];
                int l1 = 0, l2 = 0;
                for (int j = 0; j < n; j++) {
                    if (w - A[j] >= 0 && i > 0 && dp[j + 1][w - A[j]][i - 1]) {
                        a1[l1++] = A[j];
                        w -= A[j];
                        i--;
                    } else {
                        a2[l2++] = A[j];
                    }
                }
                ans[0] = a1;
                ans[1] = a2;
                return ans;
            }
        }
        return new int[0][0];
    }
}
