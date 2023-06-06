package interviewbit.graph;

import java.util.ArrayList;

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the
two subtrees of every node never differ by more than 1.

Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(a));
    }

    public TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> list = new ArrayList<>();
        while (a != null) {
            list.add(a.val);
            a = a.next;
        }

        if (list.isEmpty()) {
            return null;
        }

        return bst(list, 0, list.size() - 1);
    }

    private TreeNode bst(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = bst(list, start, mid - 1);
        root.right = bst(list, mid + 1, end);
        return root;
    }

}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
