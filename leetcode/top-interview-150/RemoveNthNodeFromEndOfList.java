package leetcode.topinterview150;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */
public class RemoveNthNodeFromEndOfList {
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

        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2));
    }


    /*
        A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward,
        to maintain a gap of n between the two pointers and then move both at the same speed.
        Finally, when the fast pointer reaches the end, the slow pointer will be n+1 places behind -
        just the right spot for it to be able to skip the next node.

        Since the question gives that n is valid, not too many checks have to be put in place.
        Otherwise, this would be necessary.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode fast = start;
        ListNode slow = start;
        slow.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

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
