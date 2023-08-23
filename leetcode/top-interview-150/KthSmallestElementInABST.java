package leetcode.topinterview150;

import java.util.Stack;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value
(1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node6;

        node2.left = node1;
        node2.right = node3;

        //System.out.println(new KthSmallestElementInABST().kthSmallest(root, 5));
        System.out.println(new KthSmallestElementInABST().kthsmallest_UsingStack(root, 5));
    }

    /*
    Note the property of the binary search tree.
    All elements smaller than root will be in the left subtree, and all elements greater than root will be in the
    right subtree.
    This means we need not even explore the right subtree till we have explored everything in the left subtree.
    Or in other words, we go to the right subtree only when the size of left subtree + 1 ( root ) < k.

    With that in mind, we can come up with an easy recursive solution which is similar to inorder traversal :

    Step 1: Find the kth smallest element in left subtree decrementing k for every node visited.
    If answer is found, return answer.
    Step 2: Decrement k by 1. If k == 0 ( this node is the kth node visited ), return node’s value
    Step 3: Find the kth smallest element in right subtree.

     */
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = kthsmallestNode(root, k);
        return result.val;
    }

    int count = 0;

    private TreeNode kthsmallestNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = kthsmallestNode(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return kthsmallestNode(root.right, k);
    }

    public int kthsmallest_UsingStack(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode n = root;

        while (n != null) {
            nodes.push(n);
            n = n.left;
        }

        while (!nodes.isEmpty()) {
            n = nodes.pop();
            k--;
            if (k == 0) {
                return n.val;
            }
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    nodes.push(n);
                    n = n.left;
                }
            }

        }
        return -1;
    }
}
