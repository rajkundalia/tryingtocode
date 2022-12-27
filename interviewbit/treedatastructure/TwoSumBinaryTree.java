package interviewbit.treedatastructure;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
Given a binary search tree A, where each node contains a positive integer,
and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Problem Constraints
1 <= size of tree <= 100000
1 <= B <= 109

Input Format
First argument is the head of the tree A.
Second argument is the integer B.

Output Format
Return 1 if such a pair can be found, 0 otherwise.

Example Input
Input 1:
         10
         / \
        9   20
B = 19
Input 2:
          10
         / \
        9   20
B = 40

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 10 + 9 = 19. Hence 1 is returned.
Explanation 2:
 No such pair exists.
 */
public class TwoSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        System.out.println(t2Sum(root, 19));
    }

    public static int t2Sum(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        set.add(A.val);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int num = B - current.val;
            if (set.contains(num)) {
                return 1;
            }
            set.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return 0;
    }
}
