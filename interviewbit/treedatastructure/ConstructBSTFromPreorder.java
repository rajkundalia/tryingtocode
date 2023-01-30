package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array A with distinct elements, which represents the preorder traversal of a binary search tree,
construct the tree and return its root.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value
strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first,
then traverses Node.left, then traverses Node.right. [root left right]

**Problem Constraints**
1 <= |A| <= 105
1 <= A.val <= 109
The given array is a valid preorder traversal of a BST.

**Input Format**
The first argument is an integer array denoting the preorder traversal.

**Output Format**
Return the root of the Binary Search Tree.

**Example Input**
Input 1:
A = [2, 1, 4, 3, 5]
Input 2:
A = [1, 2, 3]
**Example Output**
Output 1:
    2
   / \
  1   4
     / \
    3   5
Output 2:
      1
     /
    2
   /
  3


**Example Explanation**
Explanation 1:
We can see that is the tree created by the given pre order traversal.
Explanation 2:
We can see that is the tree created by the given pre order traversal.
 */
public class ConstructBSTFromPreorder {
    public static void main(String[] args) {
        System.out.println(new ConstructBSTFromPreorder().constructBST(new ArrayList<>(List.of(2, 1, 4, 3, 5))));
    }

    public TreeNode constructBST(ArrayList<Integer> A) {
        return constructBST(A, Integer.MAX_VALUE);
    }

    int i = 0;

    public ConstructBSTFromPreorder() {
        i = 0;
    }

    public TreeNode constructBST(ArrayList<Integer> list, int upperBound) {
        if (i == list.size() || list.get(i) > upperBound) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(i++));
        root.left = constructBST(list, root.val);
        root.right = constructBST(list, upperBound);
        return root;
    }
}
