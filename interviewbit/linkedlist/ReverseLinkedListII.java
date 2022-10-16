package interviewbit.linkedlist;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

Note 2:
Usually the version often seen in the interviews is reversing the whole
linked list which is obviously an easier version of this question.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(14);
        A.next = A1;
        ListNode A2 = new ListNode(6);
        A1.next = A2;
        ListNode A3 = new ListNode(16);
        A2.next = A3;
        ListNode A4 = new ListNode(4);
        A3.next = A4;
        System.out.println(reverseBetween(A, 2, 4));
    }

    // to be pasted to github


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        head = newNode;
        ListNode temp = head;

        while (temp != null) {
            if (m == 1) {
                ListNode prev = null;
                ListNode further = temp.next;
                ListNode current = temp.next;
                ListNode before = temp.next;

                while (n > 0) {
                    further = further.next;
                    current.next = prev;
                    prev = current;
                    current = further;
                    n--;
                }
                before.next = further;
                temp.next = prev;
            }
            temp = temp.next;
            m--;
            n--;
        }
        return head.next;
    }
}
