package interviewbit.hashing;

import java.util.HashSet;
import java.util.Set;

/*
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different.

Output : 1
 */
public class ColorfulNumber {
    public static void main(String[] args) {
        System.out.println(colorful(23));
    }

    public static int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        String str = Integer.toString(A);
        for (int i = 0; i < str.length(); i++) {
            int product = 1;
            for (int j = i; j < str.length(); j++) {
                int num = str.charAt(j) - '0';
                product *= num;
                if (set.contains(product)) {
                    return 0;
                }
                set.add(product);
            }
        }
        return 1;
    }
}
