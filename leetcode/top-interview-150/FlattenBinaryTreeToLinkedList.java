package leetcode.topinterview150;

import java.util.Stack;

/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next
node in the list and the left child pointer is always null.

The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:
Input: root = []
Output: []
Example 3:
Input: root = [0]
Output: [0]
 */
public class FlattenBinaryTreeToLinkedList {
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

        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root);


        TreeNode root1 = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node5_1 = new TreeNode(5);
        TreeNode node6_1 = new TreeNode(6);

        root1.left = node2_1;
        root1.right = node5_1;

        node2_1.left = node3_1;
        node2_1.right = node4_1;

        node5_1.right = node6_1;

        new FlattenBinaryTreeToLinkedList().flatten1(root1);
    }

    TreeNode previous;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = this.previous;
        root.left = null;
        this.previous = root;
    }

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }

            if (!stack.isEmpty()) {
                temp.right = stack.peek();
            } else {
                break;
            }
            temp.left = null;
        }
    }
}
