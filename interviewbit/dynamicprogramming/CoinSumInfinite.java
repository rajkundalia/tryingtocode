package interviewbit.dynamicprogramming;

/*
You are given a set of coins A. In how many ways can you make sum B assuming you have an infinite amount of
each coin in the set.
Note: Coins in set A will be unique. The expected space complexity of this problem is O(B).
Note that the answer can overflow. So, give us the answer % 1000007

Problem Constraints
1 <= |A| <= 500
1 <= B <= 5 * 104

Input Format
The first argument is an integer array A.
The second argument is an integer B.

Output Format
Return the answer % 1000007

Example Input
A = [1, 2, 3]
B = 4

Example Output
4

Example Explanation
The 4 possible ways are
{1, 1, 1, 1}
{1, 1, 2}
{2, 2}
{1, 3}
 */
public class CoinSumInfinite {
    public static void main(String[] args) {
        System.out.println(new CoinSumInfinite().coinchange2(new int[]{1, 2, 3}, 4));
        System.out.println(new CoinSumInfinite().coinchange2Recursion(new int[]{1, 2, 3}, 4));
    }

    int mod = 1000007;

    public int coinchange2(int[] a, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int x : a) {
            for (int i = 0; i <= k; i++) {
                if (i - x >= 0) {
                    dp[i] = dp[i] + dp[i - x];
                    dp[i] %= mod;
                }
            }
        }
        return dp[k] % mod;
    }

        public int coinchange2_1( int[] A, int B){
            return coinchange2Helper(A, A.length, B);
        }

        private int coinchange2Helper(int[] a, int size, int sum){
            int[][] dp = new int[sum + 1][size];

            // 1st row would be all 1's for sum 0
            for (int i = 0; i < size; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < sum + 1; i++) {
                for (int j = 0; j < size; j++) {
                    int option1 = 0;
                    // if count is greater than sum
                    if (i >= a[j]) {
                        option1 = dp[i - a[j]][j];
                    }

                    int option2 = 0;
                    // if coins are present
                    if (j > 0) {
                        option2 = dp[i][j - 1];
                    }
                    dp[i][j] = (option1 + option2) % 1000007;
                }
            }
            return (dp[sum][size - 1]) % 1000007;
        }

        public int coinchange2Recursion ( int[] A, int B){
            return coinchange2RecursionHelper(A, A.length, B);
        }

        private int coinchange2RecursionHelper ( int[] a, int size, int b){
            if (b == 0) {
                return 1;
            }
            if (b < 0) {
                return 0;
            }
            if (size <= 0 && b >= 1) {
                return 0;
            }

            return coinchange2RecursionHelper(a, size - 1, b) +
                    coinchange2RecursionHelper(a, size, b - a[size - 1]);
        }


    }
