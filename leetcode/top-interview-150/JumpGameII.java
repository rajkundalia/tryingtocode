package leetcode.topinterview150;

/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 */
public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int jumpCount = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        // left index and right index here are the minimum and maximum where a jump can land you
        // based on the number of steps provided in nums array
        // https://youtu.be/dJ7sWiOoK7g
        // Jump Game II - Greedy - Leetcode 45 - by Neetcode
        while (rightIdx < nums.length - 1) {
            int farthestIdx = 0;
            for (int i = leftIdx; i <= rightIdx; i++) {
                farthestIdx = Math.max(farthestIdx, i + nums[i]);
            }
            leftIdx = rightIdx + 1;
            rightIdx = farthestIdx;
            jumpCount++;
        }

        return jumpCount;
    }

    public int jump1(int[] nums) {
        int n = nums.length; // length of the nums array
        int jumps = 0; // number of jumps needed to reach the end
        int curEnd = 0; // farthest index that can be reached with the current number of jumps
        int curFarthest = 0; // farthest index that can be reached from the current index

        // iterate over the nums array from 0 to n - 1
        for (int i = 0; i < n - 1; i++) {
            /* calculate the maximum number of steps that can be
             taken from the current position*/
            curFarthest = Math.max(curFarthest, i + nums[i]);
            // update curFarthest with the maximum distance that can be reached from this index

            // if i is equal to curEnd, we have reached the farthest possible index with the current number of jumps
             /* if the current position is equal to i, this means we have reached
             the end of the current jump and need to jump again*/
            if (i == curEnd) {
                jumps++; // increment jumps by 1
                curEnd = curFarthest; // update curEnd with the new farthest index
            }
        }
        return jumps;
    }
}
