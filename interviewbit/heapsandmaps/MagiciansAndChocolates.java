package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In one unit of time, kid chooses a random bag i, eats Bi chocolates,
then the magician fills the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that kid can eat in A units of time.
NOTE:
floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7

Problem Constraints
1 <= A <= 105
1 <= |B| <= 105
1 <= Bi <= INT_MAX

Input Format
First argument is an integer A.
Second argument is an integer array B of size N.

Output Format
Return an integer denoting the maximum number of chocolates that kid can eat in A units of time.

Example Input
Input 1:
 A = 3
 B = [6, 5]
Input 2:
 A = 5
 b = [2, 4, 6, 8, 10]

Example Output
Output 1:
 14
Output 2:
 33

Example Explanation
Explanation 1:
 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
 so, total number of chocolates eaten are 6 + 5 + 3 = 14
 */
public class MagiciansAndChocolates {
    public static void main(String[] args) {
        System.out.println(nchoc(5, new ArrayList<>(List.of(2, 4, 6, 8, 10))));
    }

    public static int nchoc(int A, ArrayList<Integer> B) {
        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(B);
        long ans = 0;
        while (A-- != 0) {
            int n = pq.poll();
            ans += n;
            ans %= mod;
            pq.add(n / 2);
        }
        return (int) ans;
    }
}
