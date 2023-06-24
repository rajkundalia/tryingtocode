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
}
