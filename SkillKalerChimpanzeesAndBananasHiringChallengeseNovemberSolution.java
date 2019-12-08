/*

Skillenza Kaleyra Hiring Challenge: https://skillenza.com/challenge/kaleyra-hiringchallenge-sde-november
Chimpanzees and Bananas
A forest has N young chimpanzees, of varying ages waiting to be fed. Mother chimpanzee has to feed the chimpanzees with the following requirements:

Each chimpanzee should get at least one banana.
A chimpanzee with an age higher than adjacent chimpanzees should get more bananas than them.
How should mother chimpanzee distribute such that total number of bananas is minimized?

Example 1
Age of the chimpanzees: [1, 0, 2]

Explanation: 1 banana to the chimpanzee in the middle and 2 to the ones at each end.

Distribution: [2, 1, 2]

Example 2
Age of the chimpanzees: [3, 2, 1]

Explanation: 3 bananas to the first chimpanzee, 2 to the second and 1 to the third.

Distribution: [3, 2, 1]

Example 3
Age of the chimpanzees: [1, 5, 5, 5, 1]

Distribution: [1, 2, 1, 2, 1]

Input Format
First line contains single integer T denoting the number of test cases. T test cases follow.
Each test case contains two lines. The first line is the number of chimpanzees N to be fed. The second line is the space separated ages of the chimpanzees.

Output Format
For each test case, in a single line print the space separated distribution of bananas.

Constraints
1 ≤ T (number of test cases) ≤ 5

1 ≤ N (number of chimpanzees) ≤ 10^5

0 ≤ A (age of each chimpanzee) ≤ 5

Similar to https://www.programcreek.com/2014/03/leetcode-candy-java/ but with a small change.
*/



package kaleyrahiringchallengesdenovember;

import java.util.Scanner;

public class KaleyraHiringChallengeseNovemberSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] age = new int[N];
            for (int i = 0; i < N; i++) {
                age[i] = sc.nextInt();
            }
            int[] result = banana(age);
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }

    public static int[] banana(int[] age) {

        int[] banana = new int[age.length];
        banana[0] = 1;

        for (int i = 1; i < age.length; i++) {
            if (age[i] > age[i - 1]) {
                banana[i] = banana[i - 1] + 1;
            } else {
                banana[i] = 1;
            }
        }
        for (int i = age.length - 2; i >= 0; i--) {
            int cur = 1;
            if (age[i] > age[i + 1]) {
                cur = banana[i + 1] + 1;
            }
            banana[i] = Math.max(cur, banana[i]);;
        }
        return banana;
    }
}
