package interviewbit.treedatastructure;

/*
Given two Binary Trees A and B, you need to merge them in a single binary tree.
The merge rule is that if two nodes overlap, then sum of node values is the new value of the merged node.
Otherwise, the non-null node will be used as the node of new tree.

Problem Constraints
1 <= Number of Nodes in A , B <= 105

Input Format
First argument is an pointer to the root of binary tree A.
Second argument is an pointer to the root of binary tree B.

Output Format
Return a pointer to the root of new binary tree.

Example Input
Input 1:
 A =   2

      / \

     1   4

    /

   5

B =   3
      / \
      6  1
      \   \
       2   7

Input 2:
 A =   12

      / \

     11  14

B =   3
      / \
      6  1

Example Output
Output 1:

     5
    / \
   7   5
  / \   \
 5   2   7
Output 2:
   15
  / \
 17  15


Example Explanation
Explanation 1:
 After merging both the trees you get:
     5
    / \
   7   5
  / \   \
 5   2   7
Explanation 2:
 After merging both the trees we get:
   15
  / \
 17  15
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(12);
        TreeNode node11 = new TreeNode(11);
        TreeNode node14 = new TreeNode(14);

        root1.left = node11;
        root1.right = node14;

        TreeNode root2 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);

        root2.left = node6;
        root2.right = node1;

        System.out.println(new MergeTwoBinaryTrees().solve(root1, root2));
    }

    public TreeNode solve(TreeNode A, TreeNode B) {
        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }

        TreeNode result = new TreeNode(A.val + B.val);
        result.left = solve(A.left, B.left);
        result.right = solve(A.right, B.right);

        return result;
    }
}
