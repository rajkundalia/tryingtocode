package interviewbit.treedatastructure;

import java.util.ArrayDeque;
import java.util.Queue;

/*
You are given the root of a binary tree A.
You have to find out the number of parent - child relationship whose values are consecutive numbers.

Problem Constraints
1 <= Number of nodes in the tree <= 105

Input Format
The first argument is the root of the binary tree A.

Output Format
Return a single integer denoting the number of consecutive parent - child relationships.

Example Input
Input 1:
A =  2
    / \
   1   3
Input 2:
A =  5
    / \
   1   3
      / \
     1   4

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
(2, 1) and (2, 3) are the consecutive parent - child relationships.
Explanation 2:
(3, 4) is the only consecutive parent - child relationship.
 */
public class ConsecutiveParentChild {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        root.left = node1;
        root.right = node3;

        System.out.println(new ConsecutiveParentChild().consecutiveNodes(root));
    }

    public int consecutiveNodes(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int val = curr.val;
            if (curr.left != null) {
                queue.add(curr.left);
                int diff = Math.abs(val - curr.left.val);
                if (diff == 1) {
                    count++;
                }
            }

            if (curr.right != null) {
                queue.add(curr.right);
                int diff = Math.abs(val - curr.right.val);
                if (diff == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
