/*

Binary Madness
Given a non-negative integer, find the count of substrings with an odd number of 1s in its binary representation.

Input Format
First line of input t denotes the number of test cases. Next t lines follow each containing a non-negative integer n.

Output Format
For each test case print the count of substrings which satisfy the condition.

Sample Input
12
0
1
2
10
32
33
127
341
455
496
992
1000
Sample Output
0
1
2
6
6
10
16
25
24
21
24
28
Constraints
1 <= t <= 100

0 <= n <= 10200

Explanation
For the number 33, the binary representation is 100001. Of all the substrings possible, the following 10 substrings have odd number of 1s.

1
10
100
1000
10000
00001
0001
001
01
1
Hence answer is 10.


*/

import java.math.BigInteger;
import java.util.*;

public class solution {

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (scanner.hasNext()) {
            values.add(String.valueOf(scanner.next()));
        }
        scanner.close();
        for (int i = 0; i < n; i++) {
            BigInteger num = new BigInteger(values.get(i));
            subString(num.toString(2));
        }
    }

    public static void oddCount(List<String> values) {
        int count = 0;
        for (int i = 0; i < values.size(); i++) {
            long countOne = values.get(i).chars().filter(ch -> ch == '1').count();
            if (countOne % 2 == 1)
                count++;
        }
        System.out.println(count);
    }

    public static void subString(String str) {
        List<String> temp = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) {
                String s = str.substring(i, j);
                if (s.contains("1")) {
                    temp.add(s);
                }
            }
        oddCount(temp);
    }
}
