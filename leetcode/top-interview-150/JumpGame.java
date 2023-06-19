package leetcode.topinterview150;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        // Take curr variable to keep the current maximum jump
        int current = 0;
        // Traverse all elements through loop
        for(int i = 0; i < nums.length; i++) {
            // if the current index i is less than current maximum jump 'current'
            // it means that there is no way to jump to current index
            // so we should return false
            if(i > current) {
                return false;
            }
            // update current maximum jump
            current = Math.max(current, i + nums[i]);
        }
        return true;
    }
}
