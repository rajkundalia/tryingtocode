package leetcode.topinterview150;

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node2_2 = new ListNode(2);

        head.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node2_2;

        System.out.println(new PartitionList().partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftTail = left;
        ListNode rightTail = right;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;

        return left.next;
    }
}
