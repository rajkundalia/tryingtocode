package leetcode.topinterview150;

import java.util.HashMap;
import java.util.Map;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
// Explanation: https://youtu.be/O39qED_LghU Eric Programming
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
//        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
//                new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}
//        ));
//
//        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree1(
//                new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}
//        ));

        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[]{3, 9, 1, 2, 20, 15, 7}, new int[]{1, 9, 2, 3, 15, 20, 7}
        ));

        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree1(
                new int[]{3, 9, 1, 2, 20, 15, 7}, new int[]{1, 9, 2, 3, 15, 20, 7}
        ));
    }

    Map<Integer, Integer> map = new HashMap<>();
    int[] preOrder;
    int[] inOrder;
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;

        // map to put inorder value to index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int left, int right) {
        int currentVal = preOrder[index++];
        int currentIndex = map.get(currentVal); //in inorder array

        TreeNode root = new TreeNode(currentVal);

        if (left < currentIndex) {
            root.left = dfs(left, currentIndex - 1);
        }

        if (right > currentIndex) {
            root.right = dfs(currentIndex + 1, right);
        }

        return root;
    }


    /*
        Explanation for Nick White's video

    In the example in the graphic above, where P = [8,2,7,1,9,3,6] and I = [7,2,1,8,3,9,6], the root would be 8, so we know
    that imid (its location in I) is 3, and since we still are using the full array, ileft = 0 and iright = I.length-1, or 6.
    This means that the left subtree is imid - ileft = 3 elements long ([7,2,1] to the left of 8 in I) and the right subtree is iright - imid = 3
    elements long ([3,9,6] to the right of 8 in I).

    We can apply those dimensions from I to figure out the ranges of those subtrees in P, as well. The left subtree will start right after the root in
    P (pix + 1), and the right subtree will start once the left subtree ends (pix + 1 + (imid - ileft).

    At each recursion, if imid = ileft, then there are no nodes in the left subtree, so we shouldn't call a recursion for that side.
    The same applies to the right side if imid = iright.
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }
        System.out.println(inIndex - inStart);
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        // explanation in comment for preStart + inIndex - inStart + 1

        return root;
    }
}
