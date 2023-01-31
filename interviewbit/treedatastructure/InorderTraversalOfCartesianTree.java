package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.List;

/*
Given an inorder traversal of a cartesian tree, construct the tree.

Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.

Note: You may assume that duplicates do not exist in the tree.

Example :

Input : [1 2 3]

Return :
          3
         /
        2
       /
      1
 */
public class InorderTraversalOfCartesianTree {
    public static void main(String[] args) {
        System.out.println(new InorderTraversalOfCartesianTree().buildTree(new ArrayList<>(List.of(1, 2, 3))));
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        return constructInorderTree(A, 0, A.size() - 1);
    }

    public TreeNode constructInorderTree(ArrayList<Integer> A, int start, int end) {
        if (start > end) {
            return null;
        }

        int index = findMax(A, start, end);
        TreeNode root = new TreeNode(A.get(index));

        root.left = constructInorderTree(A, start, index - 1);
        root.right = constructInorderTree(A, index + 1, end);

        return root;
    }

    private int findMax(ArrayList<Integer> A, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (max < A.get(i)) {
                max = A.get(i);
                index = i;
            }
        }
        return index;
    }
}
