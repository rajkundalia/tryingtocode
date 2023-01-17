package interviewbit.treedatastructure;

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
NOTE: The path has to end on a leaf node.

Input Format
The first argument is a TreeNode, pointing to the root of the binary tree.

Output Format
Return an integer equal to the minimum depth of the tree.

Example Input
  1
 /
2

Example Output
2

Example Explanation
Minimum Depth is 2, which is from 1 -> 2.
 */
public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;

        System.out.println(new MinDepthOfBinaryTree().minDepth(root));
    }

    public int minDepth(TreeNode A) {
        return depth(A, 0);
    }

    public int depth(TreeNode node, int level) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return level + 1;
        }

        int left = depth(node.left, level + 1);
        int right = depth(node.right, level + 1);

        return Math.min(left, right);
    }
}
