package interviewbit.linkedlist;

/*
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(3);
        A.next = A1;
        ListNode A2 = new ListNode(2);
        A1.next = A2;
        System.out.println(insertionSortList(A));
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode sorted = null;

        while (temp != null) {
            ListNode current = temp;
            temp = temp.next;

            if (sorted == null || sorted.val > current.val) {
                current.next = sorted;
                sorted = current;
            } else {
                ListNode s = sorted;
                while (s != null) {
                    if (s.next == null || s.next.val > current.val) {
                        current.next = s.next;
                        s.next = current;
                        break;
                    }
                    s = s.next;
                }
            }
        }
        return sorted;
    }
}
