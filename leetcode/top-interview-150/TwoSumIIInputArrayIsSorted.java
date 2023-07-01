package leetcode.topinterview150;

import java.util.Arrays;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        Arrays.stream(new TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::println);
    }

    /*
    The approach to this question differs to that of the classic Two Sum problem in that we have some
    direction with how we want to search for our target.

    Since the array is sorted, we can make some general observations:

    Smaller sums would come from the left half of the array
    Larger sums would come from the right half of the array
    Therefore, using two pointers starting at the end points of the array, we can choose to increase or
    decrease our current sum however we like. Pay attention to the example below:

    The basic idea is that:

    If our current sum is too small, move closer to the right.
    If our current sum is too large, move closer to the left.

    That's really all there is to it! Since the array is sorted, we're guaranteed that there
    exists an answer, we have everything we need to start coding :)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
