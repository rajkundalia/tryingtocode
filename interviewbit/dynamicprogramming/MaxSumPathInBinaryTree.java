package interviewbit.dynamicprogramming;

/*
Given a binary tree T, find the maximum path sum.
The path may start and end at any node in the tree.

Problem Constraints
1 <= Number of Nodes <= 7e4
-1000 <= Value of Node in T <= 1000

Input Format
 The first and the only argument contains a pointer to the root of T, A.

Output Format
Return an integer representing the maximum sum path.

Example Input
Input 1:
    1
   / \
  2   3
Input 2:
       20
      /  \
   -10   20
        /  \
      -10  -50

Example Output
Output 1:
 6
Output 2:
 40

Example Explanation
Explanation 1:
     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:
     The path with maximum sum is: 20 -> 20
 */
public class MaxSumPathInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new MaxSumPathInBinaryTree().maxPathSum(root));
    }

    /*
        path should be continuous
        path may or may not go through root
        path can have one node minimum

        using post order

        3 cases:
        current node is in path of max sum
        current node is root of max sum
        current node is not in path of max sum

        3 variables
        ms - case1
        m21 i.e. compare with MS - case 2
        result - compare ms and m21

        ms = max (max(left, right) + root.val, root.val)
        m21 = max(ms, left + right + root.val)
        result = max(m21, result)
     */

    /*
      A node can be part of the maximum path in four ways.

        It is the only node in the path.
        The maximum path through left child + node.
        The maximum path through the right child + node.
        The maximum path through the left child + node + maximum path through the right child.
        Perform a postorder traversal and consider the above four cases for each node and update the answer.

        Note: The recursive function should return the maximum path sum starting from that node such that at
        most one child of the node is considered in the path.
     */
    int maximumPath;
    public MaxSumPathInBinaryTree() {
        maximumPath = 0;
    }

    public int maxPathSum(TreeNode A) {
        maximumPath = Integer.MIN_VALUE;
        getMaxPathSum(A);
        return maximumPath;
    }

    private int getMaxPathSum(TreeNode a) {
        if (a == null) {
            return 0;
        }
        int leftSum = getMaxPathSum(a.left);
        int rightSum = getMaxPathSum(a.right);
        int maxPathWithOneChild = Math.max(a.val, Math.max(leftSum, rightSum) + a.val);
        maximumPath = Math.max(maximumPath, Math.max(maxPathWithOneChild, leftSum + rightSum + a.val));
        return maxPathWithOneChild;
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

