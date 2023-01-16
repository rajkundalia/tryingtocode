package interviewbit.treedatastructure;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding
up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);

        node11.left = node7;
        node11.right = node2;
        node4.left = node11;
        root.left = node4;
        root.right = node8;

        System.out.println(new PathSum().hasPathSum(root, 22));
    }

    public int hasPathSum(TreeNode A, int B) {
        if (solve(A, B)) return 1;
        return 0;
    }

    public boolean solve(TreeNode root, int B) {
        if (root == null) {
            return false;
        }
        if (root.val == B && root.left == null && root.right == null) {
            return true;
        }

        B -= root.val;

        if (root.left != null) {
            if (solve(root.left, B)) {
                return true;
            }
        }

        if (root.right != null) {
            if (solve(root.right, B)) {
                return true;
            }
        }
        B += root.val;
        return false;
    }
}
