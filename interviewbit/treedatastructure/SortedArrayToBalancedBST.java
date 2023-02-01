package interviewbit.treedatastructure;

/*
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
of every node never differ by more than 1.

Problem Constraints
1 <= length of array <= 100000

Input Format
First argument is an integer array A.

Output Format
Return a root node of the Binary Search Tree.

Example Input
Input 1:
 A : [1, 2, 3]
Input 2:
 A : [1, 2, 3, 5, 10]

Example Output
Output 1:
      2
    /   \
   1     3
Output 2:
      3
    /   \
   1     5
    \     \
     2     10

Example Explanation
Explanation 1:

 You need to return the root node of the Binary Tree.
 */
public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        System.out.println(new SortedArrayToBalancedBST().sortedArrayToBST(new int[]{1, 2, 3, 5, 10}));
    }

    public TreeNode sortedArrayToBST(final int[] A) {
        return sortedArrayToBST(A, 0, A.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(a[mid]);

        root.left = sortedArrayToBST(a, start, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, end);

        return root;
    }
}
