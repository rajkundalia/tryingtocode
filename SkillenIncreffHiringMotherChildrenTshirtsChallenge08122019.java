/*
Mother, Children and T-Shirts
A mother has children of varying ages in need of t-shirts. The mother has to distribute t-shirts with the following requirements:

Each child should get at least one t-shirt.
A child with an age higher than adjacent children should get more t-shirts than them.
How should the mother distribute such that total number of t-shirts is minimized?

Example 1
Age of the children: [1, 0, 2]

Explanation: 1 t-shirt to the child in the middle and 2 to the ones at each end.

Distribution: [2, 1, 2]

Example 2
Age of the children: [3, 2, 1]

Explanation: 3 t-shirts to the first child, 2 to the second and 1 to the third.

Distribution: [3, 2, 1]

Example 3
Age of the children: [1, 5, 5, 5, 1]

Distribution: [1, 2, 1, 2, 1]

Input Format
First line contains single integer T denoting the number of test cases. T test cases follow.
Each test case contains two lines. The first line is the number of children N. The second line is the space separated ages of the children.

Output Format
For each test case, in a single line print the space separated distribution of t-shirts.

Sample Input
3
3
1 0 2
3
3 2 1
5
1 5 5 5 1
Sample Output
2 1 2
3 2 1
1 2 1 2 1
Constraints
1 ≤ T (number of test cases) ≤ 5

1 ≤ N (number of children) ≤ 10^5

0 ≤ A (age of each child) ≤ 5
*/

import java.util.Scanner;

public class solution{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] age = new int[N];
            for (int i = 0; i < N; i++) {
                age[i] = sc.nextInt();
            }
            int[] result = distribute(age);
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }

    public static int[] distribute(int[] age) {

        int[] tshirt = new int[age.length];
        tshirt[0] = 1;

        for (int i = 1; i < age.length; i++) {
            if (age[i] > age[i - 1]) {
                tshirt[i] = tshirt[i - 1] + 1;
            } else {
                tshirt[i] = 1;
            }
        }
        for (int i = age.length - 2; i >= 0; i--) {
            int cur = 1;
            if (age[i] > age[i + 1]) {
                cur = tshirt[i + 1] + 1;
            }
            tshirt[i] = Math.max(cur, tshirt[i]);;
        }
        return tshirt;
    }
}
