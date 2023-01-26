package interviewbit.treedatastructure;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is the root node of the binary tree.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ).

Example Input
Input 1:
    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:
    1
   / \
  2   2
   \   \
   3    3

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The above binary tree is symmetric.
Explanation 2:
The above binary tree is not symmetric.
 */
public class SymmetryBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node4_2 = new TreeNode(4);

        root.left = node2_1;
        root.right = node2_2;

        node2_1.left = node3_1;
        node2_1.right = node4_1;

        node2_2.left = node4_2;
        node2_2.right = node3_2;

        System.out.println(new SymmetryBinaryTree().isSymmetric(root));
    }

    public int isSymmetric(TreeNode A) {
        if (isMirrorUtil(A, A)) {
            return 1;
        }
        return 0;
    }

    private boolean isMirrorUtil(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return (isMirrorUtil(root1.left, root2.right)
                    && isMirrorUtil(root1.right, root2.left));
        }
        return false;
    }
}
