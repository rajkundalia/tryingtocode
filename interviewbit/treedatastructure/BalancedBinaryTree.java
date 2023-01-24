package interviewbit.treedatastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the
two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only  argument is the root of the tree A.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
Input 1:
    1
   / \
  2   3
Input 2:
       1
      /
     2
    /
   3

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
It is a complete binary tree.
Explanation 2:
Because for the root node, left subtree has depth 2 and right subtree has depth 0.
Difference = 2 > 1.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node3;

        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }

    public int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (Math.abs(getHeight(current.left) - getHeight(current.right)) > 1) {
                return 0;
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return 1;
    }

    private int getHeight(TreeNode a) {
        if (a == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(a.left), getHeight(a.right));
        }
    }
}
