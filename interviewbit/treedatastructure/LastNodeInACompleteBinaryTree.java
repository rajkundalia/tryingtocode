package interviewbit.treedatastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
You are given the root of a complete binary tree A.
You have to return the value of the rightmost node in the last level of the binary tree.
Try to find a solution with a better time complexity than O(N).

Problem Constraints
1 <= Number of nodes in the binary tree <= 105

Input Format
The first argument is the root of a binary tree A.

Output Format
Return a single integer denoting the value of the rightmost node in the last level of the binary tree

Example Input
Input 1:
A =
    1
   /
  2
Input 2:
A =
    1
   / \
  2   3

Example Output
Output 1:
2
Output 2:
3

Example Explanation
Explanation 1:
There is only a single node in the last level of the binary tree.
Therefore, the answer is 2.
Explanation 2:
There a two nodes in the last level of the tree.
The rightmost nodes is 3.
 */
public class LastNodeInACompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node3;

        System.out.println(new LastNodeInACompleteBinaryTree().lastNode(root));
    }

    public LastNodeInACompleteBinaryTree() {
        list = new ArrayList<>();
    }

    ArrayList<Integer> list;

    public int lastNode(TreeNode A) {
        levelOrderTraversal(A);
        return list.get(list.size() - 1);
    }

    private void levelOrderTraversal(TreeNode a) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(a);
        list.add(a.val);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
