package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given a binary tree A consisting of N nodes, return a 2-D array denoting the vertical order traversal of A.
Go through the example and image for more details.
NOTE:

If 2 or more Tree Nodes shares the same vertical level then the one with earlier occurrence in the level-order
traversal of tree comes first in the output.
Row 1 of the output array will be the nodes on leftmost vertical line similarly last row of the output
array will be the nodes on the rightmost vertical line.

Problem Constraints
0 <= N <= 104

Input Format
First and only argument is an pointer to root of the binary tree A.

Output Format
Return a 2D array denoting the vertical order traversal of A.

Example Input
Input 1:
      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:
           1
         /   \
        2     3
       / \
      4   5

Example Output
Output 1:
 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:
 [
    [4],
    [2],
    [1, 5],
    [3]
 ]

Example Explanation
Explanation 1:
 Nodes on Vertical Line 1: 2
 Nodes on Vertical Line 2: 3
 Nodes on Vertical Line 3: 6, 5
    As 6 and 5 are on the same vertical level but as 6 comes first in the level-order traversal of the tree
    so we will output 6 before 5.
 Nodes on Vertical Line 4: 7
 Nodes on Vertical Line 5: 9

Explanation 2:
 Nodes on Vertical Line 1: 4
 Nodes on Vertical Line 2: 2
 Nodes on Vertical Line 3: 1, 5
 Nodes on Vertical Line 4: 3
 */
// problem with the question is that it should be level order traversal
public class VerticalOrderTraversalOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        root.left = node3;
        root.right = node7;
        node3.left = node2;
        node3.right = node5;
        node7.right = node9;

        System.out.println(new VerticalOrderTraversalOfBinaryTree().verticalOrderTraversal(root));
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> levelNodeMap = new HashMap<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.offer(A);
        levels.offer(0);

        Integer minLevel = 0;
        Integer maxLevel = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levels.poll();

            minLevel = Math.min(level, minLevel);
            maxLevel = Math.max(maxLevel, level);

            if (!levelNodeMap.containsKey(level)) {
                levelNodeMap.put(level, new ArrayList<>());
            }

            levelNodeMap.get(level).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                levels.offer(level - 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                levels.offer(level + 1);
            }
        }

        for (int level = minLevel; level <= maxLevel; ++level) {
            if (levelNodeMap.containsKey(level)) {
                result.add(levelNodeMap.get(level));
            }
        }

        return result;
    }
}
