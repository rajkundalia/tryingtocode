package leetcode.topinterview150;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{2, 2, 1}));
    }

    /*
    Using Bit Manipulation -

    As we know XOR operation with 0 gives the same number
    i.e, a XOR 0 = a
    eg, for decimal no. 2=> 2 XOR 0 = 2
    in binary, 010 XOR 000 = 010

    Also we know that , XOR operation with same number gives 0
    i.e, a XOR a = 0
    eg, 2 XOR 2 = 0
    in binary, 010 XOR 010 = 000

    XOR is associative (like sum)
    i.e, (2 XOR 3) XOR 4 = 2 XOR (3 XOR 4), So the order doesn't matter in performing XOR operation.
    eg, 2^3^4^6 = 3^2^6^4 = 4^2^6^3 ......

    So, using these three properties of XOR, we will solve the question.
    We will take ans variable with 0 as initial value.
    And then for each element i in array, we will perform the XOR operation of the element with 0,
    ans will become 0 if the same number is found (as a XOR a = 0) and so after the completion of the loop,
    only element with no duplicate number will remain and will be returned as ans.
    */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
