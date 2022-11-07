package interviewbit.checkpointlevel4;

import java.util.Stack;

/*
Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

NOTE :

If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes.
So, if L = 5, the first half refers to first 2 nodes.
If the length L of linked list is even, then the first half implies at first L/2 nodes.
So, if L = 4, the first half refers to first 2 nodes.
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5

as

for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.
 */
public class Subtract {

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
        System.out.println(subtract(A));
    }

    public static int size(ListNode A) {
        ListNode temp = A;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static ListNode subtract(ListNode A) {
        Stack<Integer> st = new Stack<>();
        // A = reverse(A);
        ListNode temp = A;
        ListNode tmp = A;
        ListNode ans = A;
        int n = size(temp);
        int mid = 0;
        if (n % 2 == 0) {
            mid = (n / 2);
        } else {
            mid = (n / 2) + 1;
        }
        for (int i = 1; i <= mid; i++) {
            temp = temp.next;
            tmp = tmp.next;
        }
        ans = tmp;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        while (tmp != null) {
            tmp.val = st.pop();
            tmp = tmp.next;
        }
        ListNode an = ans;
        temp = A;

        while (ans != null) {
            st.push(ans.val);
            temp.val = ans.val - temp.val;
            temp = temp.next;
            ans = ans.next;
        }
        while (an != null) {
            an.val = st.pop();
            an = an.next;
        }
        // System.out.println(st);
        return A;
    }
}
