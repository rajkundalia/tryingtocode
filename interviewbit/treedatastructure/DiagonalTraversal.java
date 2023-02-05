package interviewbit.treedatastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
Consider lines of slope -1 passing between nodes.
Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.

NOTE:

See Sample Explanation for better understanding.
Order does matter in the output.
To get the same order as in the output traverse the tree same as we do in pre-order traversal.

Problem Constraints
 0 <= N <= 105

Input Format
First and only Argument represents the root of binary tree A.

Output Format
Return a 1D array denoting the diagonal traversal of the tree.

Example Input
Input 1:
           1
          /  \
         4     2
        / \      \
       8   5      3
          / \    /
         9   7  6
Input 2:
             11
          /     \
         20      12
        / \       \
       1   15      13
          /  \     /
         2    17  16
          \   /
          22 34


Example Output
Output 1:
 [1, 2, 3, 4, 5, 7, 6, 8, 9]
Output 2:
 [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]

Example Explanation
Explanation 1:
 1) Diagonal 1 contains [1, 2, 3]
 2) Diagonal 2 contains [4, 5, 7, 6]
 3) Diagonal 3 contains [8, 9]

NOTE:
The order in the output matters like for Example:
6 and 7 belong to same diagonal i.e diagonal 2 but as 7 comes before 6 in pre-order traversal so 7 will be added to answer array first.

So concantenate all the array as return it as a single one.
 Final output: [1, 2, 3, 4, 5, 7, 6, 8, 9]
Explanation 2:
 1) Diagonal 1 contains [11, 12, 13]
 2) Diagonal 2 contains [20, 15, 17, 16]
 3) Diagonal 2 contains [1, 2, 22, 34]

So concantenate all the array as return it as a single one.
 Final output: [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]
 */
public class DiagonalTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);

        root.left = node4;
        root.right = node2;
        node2.left = node6;
        node4.left = node8;
        node4.right = node5;
        node5.left = node9;
        node5.right = node7;

        System.out.println(new DiagonalTraversal().solve(root));
    }

    /*
        Every node will help to generate the next diagonal.
        We will push the element in the queue only when its left is available.
        We will process the node and move to its right.
        https://youtu.be/LhXPvhrhcIk
     */
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> q = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(A);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode rem = q.remove();
                while (rem != null) {
                    result.add(rem.val);
                    if (rem.left != null) {
                        q.add(rem.left);
                    }
                    rem = rem.right;
                }
            }
        }
        return result;
    }
}
