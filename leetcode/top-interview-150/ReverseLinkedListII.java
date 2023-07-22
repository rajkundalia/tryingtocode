package leetcode.topinterview150;

/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse
the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 */
public class ReverseLinkedListII {

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

        System.out.println(new ReverseLinkedListII().reverseBetween(head, 2, 4));

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);

        // create a dummy node to mark of the head of this list.
        dummy.next = head;

        // make a pointer pre as a marker for the node before left pointer before
        // reversing
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // pointer to the beginning of the sub list that will be reversed
        ListNode start = pre.next;

        // a pointer to a node that will be reversed
        ListNode then = start.next;

        // 1 -> 2 -> 3 -> 4 -> 5  left = 2, right = 4
        // pre = 1, start = 2, then = 3

        // dummy->1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
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


