package leetcode.topinterview150;

/*
Given an integer array nums where every element appears three times except for one, which appears exactly once.
Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 */
public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{2, 2, 3, 2}));
    }

    /*
        The idea of this solution is that we find the count of sets bits in every postion from bit 1 to bit 32
        for the whole array. If for bit position 1 we get count which is not multiple of 3 then it means the
        result has bit set in 1st position.

        Similiary we check count of bits in whole array for all position.
        Note: The advantage for this approach is that it can be easily handle situation when other numbers repeat
        3 times, 4 times or any N times. We can just replace count % 3 with count % N.
     */

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            int count = getCount(i, nums);
            if (count % 3 != 0) {
                result = result + (1 << i);
            }
        }
        return result;
    }

    private int getCount(int position, int[] arr) {
        int count = 0;
        for (int j : arr) {
            if ((j & 1 << position) != 0) {
                count++;
            }
        }
        return count;
    }
}
