package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, return the zigzag level order traversal of its nodes’ values.
(ie, from left to right, then right to left for the next level and alternate between).
Example :

Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return
[
         [3],
         [20, 9],
         [15, 7]
]
 */
public class ZigZagLevelOrderTraversalBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node20.left = node15;
        node20.right = node7;
        root.left = node9;
        root.right = node20;

        System.out.println(new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(root));
    }


    /*
    Algorithm:
    An ideal approach to follow for ZigZag Level Order Traversal is the Breadth First Approach as followed in
    the Level Order Traversal. Add the root node, which is the first visited node, to a Queue whose each
    element takes a Tree Node data structure as the input.

    Iterate until the contents of the queue is empty, resetting the ‘level’ list at each level to a new empty list.
    For each level, poll the visited element from the Queue. Maintain a boolean flag variable that toggles between
    false and true for left to right and right to left traversal. For left to right traversal,
    flag is false, in which case simply add the polled node’s value to the ‘level’ list,
    used for tracking the list of values in each particular level. For right to left traversal,
    flag is true, in which case add the polled node’s value at the 0th index of the ‘level’ list.

    Once a visited node’s value has been added to level list, explore it’s neighbors, i.e.
    its left and right children, by adding them on to the queue, if they exist.

    Once an entire level of nodes have been visited, add the level list to the
    final result list. Toggle the flag’s boolean value to achieve zig zag level order traversing.
    Continue to iterate the aforementioned steps until the queue is completely empty.
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(A);

        boolean zigzag = false;

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                //check if left not null add to queue
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
            zigzag = !zigzag;
        }

        return result;
    }
}
