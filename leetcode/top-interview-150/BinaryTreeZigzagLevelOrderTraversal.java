package leetcode.topinterview150;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;

        node20.left = node15;
        node20.right = node7;

        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        boolean normalOrder = false;

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();

            normalOrder = !normalOrder;

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                int valueOnTop = queue.poll().val;
                if (normalOrder) {
                    subList.add(valueOnTop);
                } else {
                    subList.addFirst(valueOnTop);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
