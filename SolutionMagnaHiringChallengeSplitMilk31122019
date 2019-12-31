/*

Spilt Milk
You’re given containers lined up in a certain order holding certain volumes of milk. The milk in each container is poured into the successive container and this is continued till the last, given a total pours of one less than the number of containers. If the volume of milk poured into a container is greater than available volume it gets spilt. Find the volume of milk collected in the last container and also the volume of milk spilt during the pours.

Input Format
The first line of input consists of an integer t denoting the number of test cases. Each test case consists of three lines. The first line of each test case consists of an integer n denoting the number of containers. The second line consists of n space separated integers each (v) denoting the maximum volume of milk the container at that position can hold. The third line consists of n space separated integers each (i) denoting the initial volume of milk present in the container at that position.

Output Format
For each test case output the final the volume of milk collected in the last container and the volume of milk spilt separated by space.

Sample Input
3
3
2 3 4
1 2 3
3
1 2 3
0 0 0
4
1 2 3 4
1 1 1 1
Sample Output
4 2
0 0
4 0
Constraints
1 <= t <= 1000
2 <= n <= 1000
1 <= v <= 1000
0 <= i <= 1000
i <= v


*/


import java.util.Scanner;

public class solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] capacity = new int[n];
            int[] present = new int[n];

            for (int i = 0; i < n; i++) {
                capacity[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                present[i] = sc.nextInt();
            }

            int spill = 0;
            for (int i = 1; i < n; i++) {
                present[i] = present[i] + present[i - 1];
                if (present[i] > capacity[i]) {
                    spill += present[i] - capacity[i];
                    present[i] = capacity[i];
                }
            }
            System.out.println(present[n-1] + " " + spill);
        }
    }
}
