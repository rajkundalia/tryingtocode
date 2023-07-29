package leetcode.topinterview150;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:

Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);

        root.left = node1;
        root.right = node3;


        System.out.println(new InvertBinaryTree().invertTree(root));
        System.out.println(new InvertBinaryTree().invertTree(root));
        System.out.println(new InvertBinaryTree().invertTreeIterative(root));
    }

    public TreeNode invertTree(TreeNode root) {
        // Base case: if the tree is empty...
        if (root == null) {
            return root;
        }
        // Call the function recursively for the left subtree...
        invertTree(root.left);
        // Call the function recursively for the right subtree...
        invertTree(root.right);
        // Swapping process...
        TreeNode curr = root.left;
        root.left = root.right;
        root.right = curr;
        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        // Base case: if the tree is empty...
        if (root != null) {
            // Push the root node...
            q.add(root);
        }

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }

            TreeNode curr = temp.left;
            temp.left = temp.right;
            temp.right = curr;
        }

        return root;
    }
}
