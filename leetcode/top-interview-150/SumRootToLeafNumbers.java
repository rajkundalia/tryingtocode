package leetcode.topinterview150;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node3;

        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
        //System.out.println(new SumRootToLeafNumbers().sumNumbersRecursive(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                temp.left.val += temp.val * 10;
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                temp.right.val += temp.val * 10;
                queue.offer(temp.right);
            }

            if (temp.left == null && temp.right == null) {
                res += temp.val;
            }
        }

        return res;
    }

    /*
    It is important for beginners to understand the parameter sum in helper(TreeNode root, int sum) method.
    The sum is a local variable.
    For example,

    helper(root.left, sum)
    helper(root.right, sum)
    The both sum's value is the same.
    The method helper(root.left, sum) do not change method the sum's value in helper(root.right, sum)
     */
    int total;

    public int sumNumbersRecursive(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
