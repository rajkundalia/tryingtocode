package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a Binary Tree A consisting of N nodes.
You need to find all the cousins of node B.

NOTE:
Siblings should not be considered as cousins.
Try to do it in single traversal.
You can assume that Node B is there in the tree A.
Order doesn't matter in the output.

Problem Constraints
 1 <= N <= 105
 1 <= B <= N

Input Format
First Argument represents the root of binary tree A.
Second Argument is an integer B denoting the node number.

Output Format
Return an integer array denoting the cousins of node B.
NOTE: Order doesn't matter.

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
 [6, 7]
Output 2:
 []

Example Explanation
Explanation 1:
 Cousins of Node 5 are Node 6 and 7 so we will return [6, 7]
 Remember Node 4 is sibling of Node 5 and do not need to return this.
Explanation 2:
 Since Node 1 is the root so it doesn't have any cousin so we will return an empty array.


 Two nodes of a binary tree are cousins if they have the same depth with different parents.
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        root.left = node2;
        root.right = node3;
        System.out.println(new CousinsInBinaryTree().solve(root, 5));
    }

    public ArrayList<Integer> solve(TreeNode root, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root.val == B) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        boolean found = false;
        int size;
        TreeNode p;
        q.add(root);

        // the following loop runs until found is not true, or q is not empty.
        // if found has become true => we have found the level in
        // which the node is present and the present queue will contain all the cousins of that node
        while (!q.isEmpty() && !found) {
            size = q.size();

            while (size-- > 0) {
                p = q.peek();
                q.remove();

                // if current node's left or right child is the same as the node to find, then make found = true,
                // and don't push any of them into the queue, as we don't have to print the siblings
                if ((p.left != null && p.left.val == B) || (p.right != null && p.right.val == B)) {
                    found = true;
                } else {
                    if (p.left != null)
                        q.add(p.left);
                    if (p.right != null)
                        q.add(p.right);
                }
            }
        }

        // if found == true then the queue will contain the cousins of the given node
        if (found) {
            size = q.size();
            if (size == 0) {
                return result;
            }
            for (int i = 0; i < size; i++) {
                p = q.peek();
                q.poll();
                result.add(p.val);
            }
        }

        return result;
    }
}
