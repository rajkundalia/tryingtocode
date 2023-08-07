package leetcode.topinterview150;

/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:
Input: root = []
Output: 0

Example 3:
Input: root = [1]
Output: 1
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node3;

        node2.left = node4;

        node3.left = node6;

        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLevel = 1;
        TreeNode leftNode = root.left;

        while (leftNode != null) {
            leftNode = leftNode.left;
            leftLevel++;
        }

        int rightLevel = 1;
        TreeNode rightNode = root.right;

        while (rightNode != null) {
            rightNode = rightNode.right;
            rightLevel++;
        }

        if (rightLevel == leftLevel) {
            return (int) (Math.pow(2, leftLevel) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Below is O(N)
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
}
