package interviewbit.dynamicprogramming;

/*
Given an integer A, how many structurally unique BST’s (binary search trees) exist that can store values 1…A?
Input Format:
The first and the only argument of input contains the integer, A.
Output Format:
Return an integer, representing the answer asked in problem statement.
Constraints:
1 <= A <= 18
Example:

Input 1:
    A = 3
Output 1:
    5

Explanation 1:
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesII().numTrees(3));
    }

    // https://youtu.be/iqv-qo_6xvE
    public int numTrees(int A) {
        if (A <= 2) {
            return A;
        }

        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= A; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                int n1 = dp[j - 1];
                int n2 = dp[i - j];
                sum += n1 * n2;
            }
            dp[i] = sum;
        }

        return dp[A];
    }
}
