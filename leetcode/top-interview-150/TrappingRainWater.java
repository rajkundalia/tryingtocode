package leetcode.topinterview150;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
https://youtu.be/UZG3-vZlFM4
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int n = height.length;

        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        rMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int water = Math.min(lMax[i], rMax[i]) - height[i];
            ans += Math.max(water, 0);
        }

        return ans;
    }

    /*https://leetcode.com/problems/trapping-rain-water/solutions/3387829/cjavapythonjavascript-brute-force-optimized-code-easy-to-understand-for-begineers/ */

    /*
    Initialize left, right pointers to the first and last bars of the height array, respectively.
    Initialize variables left_max and right_max to zero.
    While the left pointer is less than or equal to the right pointer,
    compare the heights of the bars pointed to by the left and right pointers.

    If the height of the left bar is less than or equal to the height of the
    right bar, check if the height of the left bar is greater than the left_max variable.

    If it is, update left_max, otherwise, add left_max - height[left] to the "water" variable.
    Move the left pointer to the next bar.

    If the height of the right bar is less than the height of the left bar,
    check if the height of the right bar is greater than the right_max variable.

    If it is, update right_max, otherwise, add right_max - height[right] to the "water" variable.
    Move the right pointer to the previous bar.

    Return the value of the "water" variable.
     */
    public int trap1(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, left_max = 0, right_max = 0, water = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    water += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    water += right_max - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
