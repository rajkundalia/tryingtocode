package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;

/*
Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
Example :

Input :
         1
        / \
       2   3

Output :
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
 */
public class RecoverSearchBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(new RecoverSearchBinaryTree().recoverTree(root));
    }

    ArrayList<Integer> result;
    TreeNode previous;
    TreeNode first;
    TreeNode second;

    public RecoverSearchBinaryTree() {
        first = null;
        second = null;
        previous = null;
        result = new ArrayList<>();
    }

    public ArrayList<Integer> recoverTree(TreeNode root) {
        recoverTreeHelper(root);
        result.add(first.val);
        result.add(second.val);
        Collections.sort(result);
        return result;
    }

    /*
    https://youtu.be/2ahCLZ3x1iI

    Maintain three-pointers, first, middle, and last.
    When the first point where the current node value is smaller than the previous node value is found,
    update the first with the previous node & the middle with the current node.

    When we find the second point where the current node value is smaller than
    the previous node value, we update the last with the current node. If the last node value is null,
    then two swapped nodes of BST are adjacent i.e. first and middle otherwise first and last
     */
    public void recoverTreeHelper(TreeNode node) {
        if (node == null) {
            return;
        } else {
            recoverTreeHelper(node.left);
            if (previous == null) {
                previous = node;
            } else {
                if (previous.val > node.val) {
                    if (first == null) {
                        first = previous;
                    }
                    second = node;
                }
                previous = node;
            }
        }
        recoverTreeHelper(node.right);
    }
}
