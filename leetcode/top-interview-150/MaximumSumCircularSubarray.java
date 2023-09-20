package leetcode.topinterview150;

/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of
nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i],
nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.


Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.

 */
public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxStraightSum = Integer.MIN_VALUE;
        int minStraightSum = Integer.MAX_VALUE;
        int arraySum = 0;

        int tempMaxSum = 0;
        int tempMinSum = 0;

        for (int i = 0; i < n; i++) {
            arraySum += nums[i];

            tempMaxSum += nums[i];
            maxStraightSum = Math.max(maxStraightSum, tempMaxSum);
            tempMaxSum = Math.max(tempMaxSum, 0);

            tempMinSum += nums[i];
            minStraightSum = Math.min(minStraightSum, tempMinSum);
            tempMinSum = Math.min(tempMinSum, 0);
        }

        if (arraySum == minStraightSum) {
            return maxStraightSum;
        }

        return Math.max(maxStraightSum, (arraySum - minStraightSum));
    }
}
