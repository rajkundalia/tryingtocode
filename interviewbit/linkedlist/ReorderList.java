package interviewbit.linkedlist;

/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,

Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
        System.out.println(reorderList(A));
    }

    /* Divide linked list in 2 parts(from mid-element)
       reverse the second part
       add element of 2nd list after each element of 1st list

       middle
       reverse
       merge alternative
     */
    public static ListNode reorderList(ListNode head) {
        ListNode required = middleHead(head);
        required = reverse(required);
        return mergeAlternate(head, required);
    }

    private static ListNode mergeAlternate(ListNode t1, ListNode t2) {
        ListNode head = t1;
        ListNode previous = t1;
        t1 = t1.next;

        while (t1 != null && t2 != null) {
            previous.next = t2;
            t2 = t2.next;
            previous = previous.next;

            previous.next = t1;
            t1 = t1.next;
            previous = previous.next;
        }

        if (t1 != null) {
            previous.next = t1;
        }

        if (t2 != null) {
            previous.next = t2;
        }

        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode further = head;

        while (further != null) {
            further = further.next;
            current.next = previous;
            previous = current;
            current = further;
        }
        return previous;
    }

    private static ListNode middleHead(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }
}
