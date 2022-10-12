package interviewbit.linkedlist;

/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
 */
public class RemoveNthNodeFromListEnd {
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
        System.out.println(removeNthFromEnd(A, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int deleteIndex = count - n;

        if (count == 1) {
            return null;
        }

        if (n >= count) {
            return head.next;
        }

        temp = head;

        for (int i = 1; i < deleteIndex; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
