package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
You are given an array of N non-negative integers, A0, A1 ,…, AN-1.

Considering each array element Ai as the edge length of some line segment, count the
number of triangles which you can form using these array values.

Notes:
You can use any value only once while forming each triangle. Order of choosing the edge
lengths doesn’t matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,
A = [1, 1, 1, 2, 2]
Return: 4

1,3,4,6,12,13,16,20
return 12
//https://youtu.be/XGzCUpy_aFk
 */
public class CountingTriangles {
    public static void main(String[] args) {
        System.out.println(nTriangle(new ArrayList<>(List.of(1, 3, 4, 6, 12, 13, 16, 20))));
    }

    //https://youtu.be/XGzCUpy_aFk
    public static int nTriangle(ArrayList<Integer> A) {
        long ans = 0;
        // a,b,c
        // a+b>c - only condition to check
        // where a,b,c are sorted

        Collections.sort(A);

        // fix c and try to find a,b that satisfy a+b>c
        // c+a>b, c+b>a satisfied by default when c is largest

        int n = A.size();
        for (int c = n - 1; c >= 2; c--) {
            int a = 0;
            int b = c - 1;
            while (a < b) {
                if (A.get(a) + A.get(b) > A.get(c)) {
                    ans += ((b - a) % 1000000007);
                    b--;
                } else {
                    a++;
                }
            }
        }
        return (int) (ans % 1000000007);
    }
}
