package interviewbit.linkedlist;

/*
Given a singly linked list and an integer K, reverses the nodes of the list K at a time and returns modified linked list.

NOTE : The length of the list is divisible by K

Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
Try to solve the problem using constant extra space.
 */
public class KReverseLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
//        ListNode A4 = new ListNode(4);
//        A3.next = A4;
//        ListNode A5 = new ListNode(10);
//        A4.next = A5;

        System.out.println(reverseList(A, 2));
    }

    public static ListNode reverseList(ListNode A, int B) {
        ListNode currentHead = A;
        ListNode previous;
        ListNode current = A;
        ListNode further = A;
        ListNode previousTail = A;

        boolean check = true;

        while (further != null) {
            currentHead = current;
            previous = null;
            int count = 0;
            while (count < B) {
                further = further.next;
                current.next = previous;
                previous = current;
                current = further;
                count++;
            }

            if (check) {
                A = previous;
                check = false;
            } else {
                previousTail.next = previous;
                previousTail = currentHead;
            }
        }
        return A;
    }
}
