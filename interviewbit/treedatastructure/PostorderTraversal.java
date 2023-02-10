package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
Given a binary tree, return the Postorder traversal of its nodes values.
NOTE: Using recursion is not allowed.

Problem Constraints
 1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.

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
 [3, 2, 1]
Output 2:
 [6, 3, 2, 1]

Example Explanation
Explanation 1:
 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:
 The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        System.out.println(new PostorderTraversal().postorderTraversal(root));
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (A == null) {
            return result;
        }
        stack.push(A);
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
