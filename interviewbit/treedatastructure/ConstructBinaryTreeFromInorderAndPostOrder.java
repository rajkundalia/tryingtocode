package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.List;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note: You may assume that duplicates do not exist in the tree.

Example :

Input :
        Inorder : [2, 1, 3] left root right
        Postorder : [2, 3, 1] left right root

Return :
            1
           / \
          2   3
 */
public class ConstructBinaryTreeFromInorderAndPostOrder {
    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromInorderAndPostOrder().buildTree(new ArrayList<>(List.of(2, 1, 3)),
                new ArrayList<>(List.of(2, 3, 1))));
    }

    public TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> pos) {
        return buildTree(in, pos, 0, in.size() - 1, 0, pos.size() - 1);
    }
    // in - inorder, pos - post order, is - inorder start, ie - inorder end, ps - post order start, pe - post order end

    private TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> pos, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }

        int rootData = pos.get(pe);
        int index = -1;

        for (int i = is; i <= ie; i++) {
            if (rootData == in.get(i)) {
                index = i;
                break;
            }
        }

        int len = index - is;
        TreeNode root = new TreeNode(rootData);
        root.left = buildTree(in, pos, is, index - 1, ps, ps + len - 1);
        root.right = buildTree(in, pos, index + 1, ie, ps + len, pe - 1);

        return root;
    }
}
