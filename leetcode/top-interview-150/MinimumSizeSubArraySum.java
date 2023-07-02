package leetcode.topinterview150;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 */
public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                result = Math.min(result, i + 1 - left);
                sum -= nums[left];
                left++;
            }
        }

        return (result != Integer.MAX_VALUE) ? result : 0;
    }
}
