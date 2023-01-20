package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;

/*
Given a Binary Tree A containing N nodes.
You need to find the path from Root to a given node B.

NOTE:
No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.

Problem Constraints
 1 <= N <= 105
 1 <= Data Values of Each Node <= N
 1 <= B <= N

Input Format
First Argument represents pointer to the root of binary tree A.
Second Argument is an integer B denoting the node number.

Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.

Example Input
Input 1:
 A =
           1
         /   \
        2     3
       / \   / \
      4   5 6   7
B = 5

Input 2:
 A =
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6
B = 1

Example Output
Output 1:
 [1, 2, 5]
Output 2:
 [1]

Example Explanation
Explanation 1:
 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
Explanation 2:
 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]
 */
public class PathToGivenNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(new PathToGivenNode().solve(root, 5));
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(A, B, ans);
        Collections.reverse(ans);
        return ans;
    }

    private boolean preorder(TreeNode a, int b, ArrayList<Integer> ans) {
        if (a == null) {
            return false;
        }
        if (a.val == b) {
            ans.add(a.val);
            return true;
        }
        if (preorder(a.left, b, ans)) {
            ans.add(a.val);
            return true;
        }
        if (preorder(a.right, b, ans)) {
            ans.add(a.val);
            return true;
        }
        return false;
    }
}
