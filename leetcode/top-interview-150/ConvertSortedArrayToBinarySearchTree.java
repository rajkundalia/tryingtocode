package leetcode.topinterview150;

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced binary search tree.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return constructBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructBinaryTree(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBinaryTree(nums, left, mid - 1);
        node.right = constructBinaryTree(nums, mid + 1, right);

        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
