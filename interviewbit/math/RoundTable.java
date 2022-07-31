package interviewbit.math;

/*
There is a party at Ram's house, he will be inviting A friends to his party.
There is round table at his house which has A+1 seats.
Among all those friends Shyam is Ram's best friend and Ram wants to sit with him.
Find the number of ways to sit such that Ram and Shayam will sit together.
Since this number can be very large take modulo 109 + 7.

Problem Constraints
1 <= A <= 105

Input Format
Given an integer A.

Output Format
Return an integer.

Example Input
Input 1:
A = 1
Input 2:
A = 2

Example Output
Output 1:
2
Output 2:
4

Example Explanation
Explanation 1:
Let the two people be
1 -> Ram
2 -> Shyam
Then the possible arrangements are {1, 2}, {2, 1}
Explanation 2:

Let the three people be
1 -> Ram
2 -> Shyam
3 -> Third friend
Then the possible arrangements are {1, 2, 3}, {3, 1, 2}, {2, 1, 3}, {3, 2, 1}
 */
public class RoundTable {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    /*
        2*A! -> 2 because 2 friends can be arranged among each other and A! since there A+1 friends.
     */

    public static int solve(int A) {
        long ans = 2;
        for (int i = 2; i <= A; ++i) {
            ans *= i;
            ans %= 1000000007;
        }
        return (int) ans;
    }
}
