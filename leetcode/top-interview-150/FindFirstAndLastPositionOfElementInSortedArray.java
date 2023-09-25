package leetcode.topinterview150;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending
position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target, 0, nums.length - 1);
        ans[1] = findLast(nums, target, 0, nums.length - 1);
        return ans;
    }

    private int findFirst(int[] nums, int target, int start, int end) {
        int position = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                position = mid;
            }
        }
        return position;
    }

    private int findLast(int[] nums, int target, int start, int end) {
        int position = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                position = mid;
            }
        }
        return position;
    }
}
