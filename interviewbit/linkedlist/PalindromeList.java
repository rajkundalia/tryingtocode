package interviewbit.linkedlist;

import java.util.List;

/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if it's
a palindrome or not, respectively.

Notes:
Expected solution is linear in time and constant in space.

For example:
List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
 */
public class PalindromeList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(1);
        A2.next = A3;
        ListNode A4 = new ListNode(1);
        A3.next = A4;
        System.out.println(lPalin(A));
    }

    public static int lPalin(ListNode A) {
        ListNode middle = middleElement(A);
        ListNode tempHead = middle.next;
        middle.next = null;
        tempHead = reverse(tempHead);

        while (tempHead != null && A != null) {
            if (tempHead.val != A.val) {
                return 0;
            }
            tempHead = tempHead.next;
            A = A.next;
        }
        return 1;
    }

    public static ListNode middleElement(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode a) {
        ListNode prev = null;
        ListNode current = a;
        ListNode further = a;

        while (further != null) {
            further = further.next;
            current.next = prev;
            prev = current;
            current = further;
        }
        return prev;
    }
}
