package leetcode.topinterview150;

import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode1_4 = new ListNode(4);
        ListNode listNode1_5 = new ListNode(5);
        listNode1.next = listNode1_4;
        listNode1_4.next = listNode1_5;

        ListNode listNode2 = new ListNode(1);
        ListNode listNode2_3 = new ListNode(3);
        ListNode listNode2_4 = new ListNode(4);
        listNode2.next = listNode2_3;
        listNode2_3.next = listNode2_4;

        ListNode listNode3 = new ListNode(2);
        ListNode listNode3_6 = new ListNode(6);
        listNode3.next = listNode3_6;

        System.out.println(new MergeKSortedLists().mergeKLists(new ListNode[]{listNode1, listNode2, listNode3}));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.add(node);
//            System.out.println(queue);
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                queue.add(node.next);
            }
//            System.out.println(queue);
        }
        return dummy.next;
    }
}
