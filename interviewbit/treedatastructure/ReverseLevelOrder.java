package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, return the reverse level order traversal of its nodes values.
(i.e, from left to right and from last level to starting level).

Problem Constraints
1 <= number of nodes <= 5 * 105
1 <= node value <= 105

Input Format
First and only argument is a pointer to the root node of the Binary Tree, A.

Output Format
Return an integer array denoting the reverse level order traversal from left to right.

Example Input
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:
   1
  / \
 6   2
    /
   3


Example Output
Output 1:
 [15, 7, 9, 20, 3]
Output 2:
 [3, 6, 2, 1]

Example Explanation
Explanation 1:
 Nodes as level 3 : [15, 7]
 Nodes at level 2: [9, 20]
 Nodes at level 1: [3]
 Reverse level order traversal will be: [15, 7, 9, 20, 3]
Explanation 2:
 Nodes as level 3 : [3]
 Nodes at level 2: [6, 2]
 Nodes at level 1: [1]
 Reverse level order traversal will be: [3, 6, 2, 1]
 */
public class ReverseLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node20.left = node15;
        node20.right = node7;
        root.right = node20;
        root.left = node9;
        System.out.println(new ReverseLevelOrder().solve(root));
    }

    /*
        The idea is to use a deque(double-ended queue) to get the reverse level order.
        A deque allows insertion and deletion at both ends.
        If we do normal level order traversal and instead of printing a node, push the node to a stack
        and then print the contents of the deque, we get “5 4 3 2 1” for the above example tree,
        but the output should be “4 5 2 3 1”. So to get the correct sequence (left to right at every level),
        we process the children of a node in reverse order, we first push the right subtree to the deque,
        then process the left subtree.
     */
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> S = new Stack();
        Queue<TreeNode> Q = new LinkedList();

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        Q.add(A);

        while (!Q.isEmpty()) {
            /* Dequeue node and make it root */
            A = Q.peek();
            Q.remove();
            S.push(A);

            /* Enqueue right child */
            if (A.right != null) {
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(A.right);
            }

            /* Enqueue left child */
            if (A.left != null) {
                Q.add(A.left);
            }
        }

        // Now pop all items from stack one by one and print them
        while (!S.empty()) {
            A = S.peek();
            result.add(A.val);
            S.pop();
        }
        return result;
    }
}
