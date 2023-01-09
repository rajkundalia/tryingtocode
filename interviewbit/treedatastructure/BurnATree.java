package interviewbit.treedatastructure;

/*
Given a binary tree denoted by root node A and a leaf node B from this tree.

It is known that all nodes connected to a given node (left child, right child and parent) get burned in 1 second.
Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on.

You need to find the minimum time required to burn the complete binary tree.

Problem Constraints
2 <= number of nodes <= 105
1 <= node value, B <= 105
node value will be distinct

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B denoting the node value of leaf node.

Output Format
Return an integer denoting the minimum time required to burn the complete binary tree.

Example Input
Input 1:
 Tree :      1
            / \
           2   3
          /   / \
         4   5   6
 B = 4
Input 2:
 Tree :      1
            / \
           2   3
          /     \
         4       5
 B = 5

Example Output
Output 1:
 4
Output 2:
 4

Example Explanation
Explanation 1:
 After 1 sec: Node 4 and 2 will be burnt.
 After 2 sec: Node 4, 2, 1 will be burnt.
 After 3 sec: Node 4, 2, 1, 3 will be burnt.
 After 4 sec: Node 4, 2, 1, 3, 5, 6(whole tree) will be burnt.

Explanation 2:
 After 1 sec: Node 5 and 3 will be burnt.
 After 2 sec: Node 5, 3, 1 will be burnt.
 After 3 sec: Node 5, 3, 1, 2 will be burnt.
 After 4 sec: Node 5, 3, 1, 2, 4(whole tree) will be burnt.
 */
public class BurnATree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node2.left = node4;
        node3.right = node5;

        root.left = node2;
        root.right = node3;

        System.out.println(new BurnATree().solve(root, 5));
    }

    public int solve(TreeNode A, int B) {
        int[] max = new int[1];
        find(A, B, max);
        return max[0];
    }

    private int find(TreeNode root, int b, int[] max) {
        if (root == null) {
            return -1;
        }
        if (root.val == b) {
            maxTime(root, null, 0, max);
            return 1;
        }
        int lc = find(root.left, b, max);
        if (lc != -1) {
            maxTime(root, root.left, lc, max);
            return lc + 1;
        }
        int rc = find(root.right, b, max);

        if (rc != -1) {
            maxTime(root, root.right, rc, max);
            return rc + 1;
        }

        return -1;

    }

    private void maxTime(TreeNode root, Object block, int count, int[] max) {
        if (root == null || root == block) {
            return;
        }
        max[0] = Math.max(max[0], count);
        maxTime(root.left, block, count + 1, max);
        maxTime(root.right, block, count + 1, max);
    }
}
