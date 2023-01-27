package interviewbit.treedatastructure;

/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return  0 / 1  ( 0 for false, 1 for true ) for this problem

Example :

Input :

   1       1
  / \     / \
 2   3   2   3

Output :
  1
 */
public class IdenticalBinaryTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3_1 = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node3_2 = new TreeNode(3);

        root.left = node2_1;
        root.right = node3_1;

        root2.left = node2_2;
        root2.right = node3_2;

        System.out.println(new IdenticalBinaryTrees().isSameTree(root, root2));
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if(A == null || B == null) {
            return 0;
        }

        if (A.val != B.val) {
            return 0;
        }

        return isSameTree(A.left, B.left) & isSameTree(A.right, B.right);
    }
}
