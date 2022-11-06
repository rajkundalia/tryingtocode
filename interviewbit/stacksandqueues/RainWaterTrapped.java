package interviewbit.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

Problem Constraints
1 <= |A| <= 100000

Input Format
The only argument given is integer array A.

Output Format
Return the total water it is able to trap after raining.

Example Input
Input 1:
 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:
 A = [1, 2]

Example Output
Output 1:
 6
Output 2:
 0

Example Explanation
Explanation 1:
 In this case, 6 units of rain water (blue section) are being trapped.
Explanation 2:

 No water is trapped.
 */
public class RainWaterTrapped {
    public static void main(String[] args) {
        System.out.println(trap(List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
    }

    public static int trap(final List<Integer> A) {
        int n = A.size();
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], A.get(i));
        }

        rmax[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], A.get(i));
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(lmax[i], rmax[i]) - A.get(i);
            ans += water > 0 ? water : 0;
        }

        return ans;
    }
}
