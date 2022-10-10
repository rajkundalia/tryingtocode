package interviewbit.linkedlist;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.

Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(1);
        A.next = A1;
        ListNode A2 = new ListNode(2);
        A1.next = A2;
        ListNode A3 = new ListNode(2);
        A2.next = A3;
        ListNode A4 = new ListNode(2);
        A3.next = A4;
        ListNode A5 = new ListNode(4);
        A4.next = A5;
        System.out.println(deleteDuplicates(A));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
