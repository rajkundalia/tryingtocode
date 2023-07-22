package leetcode.topinterview150;

/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new ReverseNodesInKGroup().reverseKGroup(head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if (head.next == null) {
            return head;
        }
        if (k == 1) {
            return head;
        }

        //define pre and cur
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        //reverse the list
        while (cur != null) {
            boolean space = checkNextKSpaceAvailability(k, cur);
            if (space) {
                pre = reverse(pre, cur, k);
                cur = pre.next;
            } else {
                break;
            }
        }
        //return the head
        return dummy.next;
    }

    private boolean checkNextKSpaceAvailability(int k, ListNode cur) {
        for (int i = 1; i <= k; i++) {
            if (cur == null) return false;
            cur = cur.next;
        }
        return true;
    }

    private ListNode reverse(ListNode pre, ListNode cur, int k) {
        for (int i = 0; i < k - 1; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return cur;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
