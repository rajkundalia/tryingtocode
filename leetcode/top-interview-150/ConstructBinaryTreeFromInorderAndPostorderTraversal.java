package leetcode.topinterview150;

/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}
        ));
    }

    /*
        Intuition
        To construct a binary tree from inorder and postorder traversal arrays, we first need to understand
        what each of these traversals represents.

        Inorder traversal visits the nodes in ascending order of their values, i.e.,
        left child, parent, and right child. On the other hand, postorder traversal visits the nodes in
        the order left child, right child, and parent.

        Knowing this, we can say that the last element in the postorder array is the root node,
        and its index in the inorder array divides the tree into left and right subtrees.
        We can recursively apply this logic to construct the entire binary tree.

        Approach
        Start with the last element of the postorder array as the root node.
        Find the index of the root node in the inorder array.
        Divide the inorder array into left and right subtrees based on the index of the root node.
        Divide the postorder array into left and right subtrees based on the number of elements
        in the left and right subtrees of the inorder array.
        Recursively construct the left and right subtrees.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }
}
