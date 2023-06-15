package leetcode.topinterview150;

/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1, 2, 2, 2, 3}));
    }

    /*
    Check if the length of the array "nums" is less than or equal to 2.
    If true, return the length as there are no duplicates to remove.

    Initialize two pointers: "prev" points to the position where the next unique element will be placed,
    and "curr" points to the current element being checked.

    Iterate through the array starting from the third element (index 2) until the end.

    Check if the current element "nums[curr]" is equal to the previous two elements "nums[prev]" and "nums[prev - 1]".
    If true, it means there are more than two occurrences of this element, so increment "curr" to skip it.

    If the current element is not a duplicate, move the "prev" pointer forward, update "nums[prev]" with the current element,
    and increment both "prev" and "curr".

    Repeat steps 4 and 5 until all elements have been checked.

    Return "prev + 1" as the new length of the modified array.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int previous = 1;
        int current = 2;

        while (current < nums.length) {
            if (nums[current] == nums[previous] && nums[current] == nums[previous - 1]) {
                current++;
            } else {
                previous++;
                nums[previous] = nums[current];
                current++;
            }
        }
        return previous + 1;
    }
}
