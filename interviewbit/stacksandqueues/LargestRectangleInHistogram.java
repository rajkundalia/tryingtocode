package interviewbit.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given an array of integers A .
A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000000

Input Format
The only argument given is the integer array A.

Output Format
Return the area of largest rectangle in the histogram.

Example Input
Input 1:
 A = [2, 1, 5, 6, 2, 3]
Input 2:
 A = [2]
Example Output
Output 1:
 10
Output 2:
 2

Example Explanation
Explanation 1:
The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:
Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        //System.out.println(largestRectangleArea(new ArrayList<>(List.of(2, 1, 5, 6, 2, 3))));
        System.out.println(largestRectangleArea(new ArrayList<>(List.of(62, 96, 89, 85, 64, 91, 95, 13, 73, 43, 45, 47, 59, 13, 31, 57, 35, 87, 6, 6, 46, 55, 99, 40, 54, 45, 28, 71, 49, 61, 38, 81, 36, 13, 22, 29, 41, 71, 74, 53, 60, 92, 86))));
    }

    public static int largestRectangleArea(ArrayList<Integer> A) {
        if (A.size() <= 1) {
            return A.get(0);
        }

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[A.size()];
        stack.push(0);

        // left smallest value
        for (int i = 0; i < A.size(); i++) {
            int x = -1;
            while (!stack.empty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }

            if (!stack.empty()) {
                x = stack.peek();
            }
            left[i] = x;
            stack.push(i);
        }

        int[] right = new int[A.size()];
        stack = new Stack<>();
        stack.push(A.size() - 1);
        int n = A.size();
        // right smallest value

        for (int i = n - 1; i >= 0; i--) {
            int x = n;
            while (!stack.empty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (!stack.empty()) {
                x = stack.peek();
            }
            right[i] = x;
            stack.push(i);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            left[i]++; // we don't want index of the smallest, we want next to the smallest
            right[i]--; // we don't want index of the smallest, we want next to the smallest
            // The reason for this is because, we can't take value larger than present in that particular histogram

            /*
                2 1 5 6 2 3

                for 5, next smallest on right is 2, but we can't get the height corresponding to 5 in 2,
                so we do right[i]--.
             */
            ans = Math.max(ans, (A.get(i) * (right[i] - left[i] + 1)));
        }
        return ans;
    }
}
