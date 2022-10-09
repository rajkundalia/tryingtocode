package interviewbit.linkedlist;

/*
Merge two sorted linked lists and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode A = new ListNode(4);
        ListNode A1 = new ListNode(11);
        A.next = A1;
        ListNode A2 = new ListNode(15);
        A1.next = A2;

        ListNode B = new ListNode(5);
        ListNode B1 = new ListNode(8);
        B.next = B1;
        ListNode B2 = new ListNode(20);
        B1.next = B2;

        System.out.println(mergeTwoLists(A, B));
    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode tail = null;
        ListNode head = null;

        if (A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        tail = head;

        while (A != null && B != null) {
            if (A.val < B.val) {
                tail.next = A;
                tail = A;
                A = A.next;
            } else {
                tail.next = B;
                tail = B;
                B = B.next;
            }

        }
        if (A == null) {
            tail.next = B;
        } else {
            tail.next = A;
        }
        return head;
    }
}
