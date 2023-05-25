package interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Problem Constraints
 1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

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
 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:
 [
   [1]
   [6, 2]
   [3]
 ]

Example Explanation
Explanation 1:
 Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        root.left = node9;
        root.right = node20;
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node20.left = node15;
        node20.right = node7;

        System.out.println(Arrays.deepToString(new LevelOrder().levelOrder(root)));
    }

    public int[][] levelOrder(TreeNode A) {
        int[][] result = null;

        List<List<Integer>> levels = new ArrayList<>();
        TreeNode root = A;

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int countOnLevel = queue.size();
            List<Integer> resultOnLevel = new ArrayList<>();
            while (countOnLevel > 0) {
                TreeNode node = queue.remove();
                countOnLevel--;

                resultOnLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(resultOnLevel);
        }

        int[][] array = new int[levels.size()][];

        int i = 0;

        for (List<Integer> nestedList : levels) {
            int[] nestedArray = new int[nestedList.size()];
            int j = 0;
            for (Integer val : nestedList) {
                nestedArray[j++] = val;
            }

            array[i++] = nestedArray;
        }

        return array;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

