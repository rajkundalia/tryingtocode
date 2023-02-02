package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.List;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= |A| <= 105
|A| == |B|

Input Format
The first argument is an integer array A representing the preorder traversal.
The second argument is an integer array B representing the inorder traversal.

Output Format
Return the pointer to the root node of the tree.

Example Input
Preorder : [1, 2, 3] root left right
Inorder  : [2, 1, 3] left root right
Example Output
            1
           / \
          2   3
 */
public class ConstructBinaryTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromInorderAndPreorder().buildTree(new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(2, 1, 3))));
    }

    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        return build(in, pre, 0, in.size() - 1, 0, pre.size() - 1);
    }
    // in - inorder, pre - preorder, is - inorder start, ie - inorder end, ps - preorder start, pe - preorder pe

    private TreeNode build(ArrayList<Integer> in, ArrayList<Integer> pre, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }

        int rootData = pre.get(ps);
        int index = -1;

        for (int i = is; i <= ie; i++) {
            if (rootData == in.get(i)) {
                index = i;
                break;
            }
        }

        // preorder - root left right
        // inorder - left root right

        int len = index - is;

        TreeNode root = new TreeNode(rootData);
        root.left = build(in, pre, is, index - 1, ps + 1, ps + len);
        root.right = build(in, pre, index + 1, ie, ps + len + 1, pe);

        return root;
    }
}
