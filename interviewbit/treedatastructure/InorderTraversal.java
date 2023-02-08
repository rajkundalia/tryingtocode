package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes values.
NOTE: Using recursion is not allowed.

Problem Constraints
 1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

Example Input
Input 1:
   1
    \
     2
    /
   3
Input 2:
   1
  / \
 6   2
    /
   3

Example Output
Output 1:
 [1, 3, 2]
Output 2:
 [6, 1, 3, 2]

Example Explanation
Explanation 1:
 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:
 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node6;
        root.right = node2;
        node2.left = node3;

        System.out.println(new InorderTraversal().inorderTraversal(root));
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (A != null) {
            stack.push(A);
            A = A.left;
        }
        while (!stack.isEmpty()) {
            TreeNode removed = stack.pop();
            list.add(removed.val);
            TreeNode right = removed.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return list;
    }
}
