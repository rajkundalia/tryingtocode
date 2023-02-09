package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a binary tree, return the preorder traversal of its nodes’ values.
Example :

Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        System.out.println(new PreorderTraversal().preorderTraversal(root));
    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (A == null) {
            return ans;
        }

        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ans.add(temp.val);

            // right first since it is a stack, we actually want left to come first
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return ans;
    }
}
