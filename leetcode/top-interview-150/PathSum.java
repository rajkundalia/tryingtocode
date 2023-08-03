package leetcode.topinterview150;

/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        System.out.println(new PathSum().hasPathSum(root, 7));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        boolean left = false;
        boolean right = false;

        if (root.left != null) {
            left = dfs(root.left, targetSum);
        }

        if (root.right != null) {
            right = dfs(root.right, targetSum);
        }

        return left || right;
    }
}
