package interviewbit.treedatastructure;

import java.util.Stack;

/*
Given a binary search tree, write a function to find the kth smallest element in the tree.
NOTE: You may assume 1 <= k <= Total number of nodes in BST

Input Format
The first argument is the root node of the binary tree.
The second argument B is an integer equal to the value of k.

Output Format
Return the value of the kth smallest node.

Example Input
  2
 / \
1   3
and k = 2

Example Output
2
Example Explanation
As 2 is the second-smallest element in the tree.
 */
public class KthSmallestElementInTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        node3.left = node4;
        node3.right = node1;
        root.left = node3;
        root.right = node2;
        KthSmallestElementInTree kthSmallestElementInTree = new KthSmallestElementInTree();
        System.out.println(kthSmallestElementInTree.kthsmallest(root, 3));
        System.out.println(kthSmallestElementInTree.kthsmallest_UsingStack(root, 3));
    }

    /*
    Note the property of the binary search tree.
All elements smaller than root will be in the left subtree, and all elements greater than root will be in the right subtree.
This means we need not even explore the right subtree till we have explored everything in the left subtree. Or in other words, we go to the right subtree only when the size of left subtree + 1 ( root ) < k.

With that in mind, we can come up with an easy recursive solution which is similar to inorder traversal :

Step 1: Find the kth smallest element in left subtree decrementing k for every node visited. If answer is found, return answer.
Step 2: Decrement k by 1. If k == 0 ( this node is the kth node visited ), return node’s value
Step 3: Find the kth smallest element in right subtree.
     */
    public int kthsmallest(TreeNode root, int i) {
        TreeNode result = kthsmallestNode(root, i);
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

        while(n != null){
            nodes.push(n);
            n = n.left;
        }

        while(!nodes.isEmpty()){
            n = nodes.pop();
            k--;
            if(k == 0){
                return n.val;
            }
            if(n.right != null){
                n = n.right;
                while(n != null){
                    nodes.push(n);
                    n = n.left;
                }
            }

        }
        return -1;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
