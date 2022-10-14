package interviewbit.linkedlist;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
        ListNode A4 = new ListNode(5);
        A3.next = A4;

        System.out.println(rotateRight(A, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int n = 1;
        ListNode current = head;

        while (current.next != null) {
            current = current.next;
            n++;
        }

        current.next = head;

        if (k > n) {
            k = k % n;
        }

        for (int i = 0; i < (n - k); i++) {
            current = current.next;
        }

        ListNode ans = current.next;
        current.next = null;
        return ans;
    }
}
