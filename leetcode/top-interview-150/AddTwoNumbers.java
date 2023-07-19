package leetcode.topinterview150;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
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

        System.out.println(new AddTwoNumbers().addTwoNumbers(A, B));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = current.next;
        }

        return temp.next;
    }
}
