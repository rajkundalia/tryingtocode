package interviewbit.treedatastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree A, flatten it to a linked list in-place.
The left child of all nodes should be NULL.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of tree A.

Output Format
Return the linked-list after flattening.

Example Input
Input 1:
     1
    / \
   2   3
Input 2:
         1
        / \
       2   5
      / \   \
     3   4   6

Example Output
Output 1:
1
 \
  2
   \
    3
Output 2:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

Example Explanation
Explanation 1:
 Tree flattening looks like this.
Explanation 2:
 Tree flattening looks like this.
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node3;

        System.out.println(new FlattenBinaryTreeToLinkedList().flatten(root));
    }
    // https://youtu.be/sWf7k1x9XR4
    //L38. Flatten a Binary Tree to Linked List | 3 Approaches | C++ | Java
    public TreeNode prev;

    public FlattenBinaryTreeToLinkedList() {
        prev = null;
    }

    public TreeNode flatten(TreeNode a) {
        helper(a);
        return a;
    }

    private void helper(TreeNode a) {
        if (a == null) {
            return;
        }
        flatten(a.right);
        flatten(a.left);

        a.right = this.prev;
        a.left = null;
        this.prev = a;
    }
}
