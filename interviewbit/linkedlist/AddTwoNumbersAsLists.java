package interviewbit.linkedlist;

/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddTwoNumbersAsLists {

    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        ListNode A1 = new ListNode(4);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;

        ListNode B = new ListNode(5);
        ListNode B1 = new ListNode(6);
        B.next = B1;
        ListNode B2 = new ListNode(4);
        B1.next = B2;

        System.out.println(addTwoNumbers(A, B));
    }

    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        int carry = 0;
        ListNode tempHead = new ListNode(-1);
        ListNode temp = tempHead;

        while (h1 != null || h2 != null || carry > 0) {
            int num = 0;

            if (h1 != null) {
                num += h1.val;
            }

            if (h2 != null) {
                num += h2.val;
            }

            num += carry;

            ListNode node = new ListNode(num % 10);
            carry = num / 10;

            temp.next = node;
            temp = temp.next;

            if (h1 != null) {
                h1 = h1.next;
            }

            if (h2 != null) {
                h2 = h2.next;
            }
        }

        temp = reverse(tempHead.next);

        while (temp != null && temp.val == 0) {
            temp = temp.next;
        }

        temp = reverse(temp);

        return temp;
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
}
