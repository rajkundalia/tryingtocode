package interviewbit.treedatastructure;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers % 1003.

Problem Constraints
0 <= Node.val <= 9

Input Format
The first argument is TreeNode A, pointing to the root of the tree.
Output Format
Return an integer equal to the total sum of all root-to-leaf numbers % 1003.

Example Input
    1
   / \
  2   3

Example Output
25

Example Explanation
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
public class SumRootToLeafNumbers {

    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

    public SumRootToLeafNumbers() {
        ans = 0;
    }

    public int sumNumbers(TreeNode A) {
        if (A == null) {
            return 0;
        }
        sum(A, 0);
        return ans;
    }

    private void sum(TreeNode A, int sum) {
        if (A == null) {
            return;
        }
        sum = ((sum * 10) % 1003 + A.val);
        if (A.left == null && A.right == null) {
            ans = (ans + sum) % 1003;
            return;
        }
        sum(A.left, sum);
        sum(A.right, sum);
    }
}
