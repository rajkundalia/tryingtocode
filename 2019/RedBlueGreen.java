/*

Red, Green and Blue
Given a pixel sequence consisting of red, green and blue pixels find the count of all contiguous subsequences such that each subsequence has a minimum length of 3 and the sequence cycles between red r, green g and blue b. For eg. if the sequence starts with g then the next character in the sequence should be b and the next should be r and so on.

Input Format
First line of test case consists of an integer t denoting the number of test cases. Next t test cases follow. Each test case consists of two lines. First line of each test case is the length of the pixel sequence. Second line is the pixel sequence.

Sample Input
5
3
rgb
4
brgb
2
rg
1
b
16
rgbrbbrgbgbrgrgb
Sample Output
1
3
0
0
10
Constraints
1 <= t <= 1000

1 <= |s| <= 1000

character set of s - rgb

Explanation
For the character sequence rgbrbbrgbgbrgrgb, there are 10 possible contiguous subsequences viz. rgb, rgbr, gbr, brg, brgb, rgb, gbr, gbrg, brg, rgb which satisfy the condition.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int len = sc.nextInt();
            System.out.println(subStr(sc.next(), len));
        }
    }

    private static int subStr(String str, int n) {
        List<String> st = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j <= n; j++) {
                String temp = str.substring(i, j);
                if (temp.length() >= 3 && isOk(temp)) {
                    st.add(temp);
                }
            }
        }
        return st.size();
    }

    private static boolean isOk(String temp) {
        int len = temp.length();
        boolean check = false;
        for (int i = 0; i < len - 1; i++) {
            if (temp.charAt(i) == 'r' && temp.charAt(i + 1) == 'g') {
                check = true;
            } else if (temp.charAt(i) == 'g' && temp.charAt(i + 1) == 'b') {
                check = true;
            } else if (temp.charAt(i) == 'b' && temp.charAt(i + 1) == 'r') {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }
}

