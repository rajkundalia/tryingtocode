package interviewbit.treedatastructure;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

NOTE:
You may only use constant extra space.
Recursion has memory overhead and does not qualify for constant space.
The tree need not be a perfect binary tree.

Input Format
The first argument is TreeNode A, pointing to the root of the tree.

Output Format
Update the given TreeNode A.

Example Input
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

Example Output
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

    4
   2 5
  1 3
 */
public class PopulateNextRightPointersTree {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(4);
        TreeLinkNode node1 = new TreeLinkNode(3);
        TreeLinkNode node2 = new TreeLinkNode(5);
        TreeLinkNode node3 = new TreeLinkNode(2);
        TreeLinkNode node4 = new TreeLinkNode(1);
        node3.left = node4;
        node3.right = node1;
        root.left = node3;
        root.right = node2;
        new PopulateNextRightPointersTree().connect(root);
        System.out.println(root);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeLinkNode current = q.poll();
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
                TreeLinkNode temp = null;
                if (size != 0) {
                    temp = q.peek();
                }
                current.next = temp;
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}