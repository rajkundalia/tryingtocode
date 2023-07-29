package leetcode.topinterview150;

import java.util.Stack;

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode node1_2 = new TreeNode(9);
        TreeNode node1_3 = new TreeNode(20);

        root1.left = node1_2;
        root1.right = node1_3;

        TreeNode root2 = new TreeNode(3);
        TreeNode node2_2 = new TreeNode(9);
        TreeNode node2_3 = new TreeNode(20);

        root2.left = node2_2;
        root2.right = node2_3;

        System.out.println(new SameTree().isSameTree(root1, root2));
        System.out.println(new SameTree().isSameTreeDFS(root1, root2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both p and q are null, then they are the same tree
        if (p == null && q == null) return true;

        // If only one of p and q is null, then they are not the same tree
        if (p == null || q == null) return false;

        // If the values of p and q are different, then they are not the same tree
        if (p.val != q.val) return false;

        // Recursively check the left and right subtrees of p and q
        // If both the left and right subtrees are the same, then p and q are the same tree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.add(p);
        stackQ.add(q);

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode tmpP = stackP.pop();
            TreeNode tmpQ = stackQ.pop();
            if (tmpP.val != tmpQ.val) {
                return false;
            }

            if (tmpP.left != null && tmpQ.left != null) {
                stackP.push(tmpP.left);
                stackQ.push(tmpQ.left);
            } else if (tmpP.left == null && tmpQ.left == null) {
            } else {
                return false;
            }

            if (tmpP.right != null && tmpQ.right != null) {
                stackP.push(tmpP.right);
                stackQ.push(tmpQ.right);
            } else if (tmpP.right == null && tmpQ.right == null) {
            } else {
                return false;
            }
        }

        return stackP.isEmpty() && stackQ.isEmpty();
    }

}
