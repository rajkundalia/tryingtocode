package leetcode.topinterview150;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }

    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] output = new int[N];
        output[0] = 1;

        for (int i = 1; i < N; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R = R * nums[i];
        }

        return output;
    }

    public int[] productExceptSelf1(int[] nums) {
        int N = nums.length;

        int[] leftProduct = new int[N];
        int[] rightProduct = new int[N];

        int[] output = new int[N];

        leftProduct[0] = 1;
        rightProduct[N - 1] = 1;

        /*
            nums - 1 2 3 4
            leftProduct - 1 1 2 6
            rightProduct - 24 12 4 1
            output - 24 12 8 6
        */
        for (int i = 1; i < N; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            rightProduct[i] = nums[i + 1] * rightProduct[i + 1];
        }

        for (int i = 0; i < N; i++) {
            output[i] = leftProduct[i] * rightProduct[i];
        }

        return output;
    }
}
