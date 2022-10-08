package interviewbit.linkedlist;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(2);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
        System.out.println(deleteDuplicates(A));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode previous = tempHead;

        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (previous.next == head) {
                previous = previous.next;
            } else {
                previous.next = head.next;
            }
            head = head.next;
        }
        return tempHead.next;
    }
}
