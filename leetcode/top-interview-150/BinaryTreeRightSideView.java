package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 */
// https://youtu.be/KV4mRzTjlAk
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.right = node5;

        node3.right = node4;

        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
        System.out.println(new BinaryTreeRightSideView().leftSideView(root));
    }

    // last node of every level is the right side view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode current, List<Integer> result, int currentDepth) {
        if(current == null) {
            return;
        }

        if(currentDepth == result.size()) {
            result.add(current.val);
        }

        // since helper with right is called first, currentDepth + 1 == result.size() -> true will happen only once in
        // the same depth
        helper(current.right, result, currentDepth + 1);
        helper(current.left, result, currentDepth + 1);
    }


    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helperLeft(root, result, 0);
        return result;
    }

    private void helperLeft(TreeNode current, List<Integer> result, int currentDepth) {
        if(current == null) {
            return;
        }

        if(currentDepth == result.size()) {
            result.add(current.val);
        }

        helperLeft(current.left, result, currentDepth + 1);
        helperLeft(current.right, result, currentDepth + 1);
    }
}
