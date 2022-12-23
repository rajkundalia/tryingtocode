package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(10);
        a.next = b;
        ListNode c = new ListNode(20);
        b.next = c;

        ListNode d = new ListNode(4);
        ListNode e = new ListNode(11);
        d.next = e;
        ListNode f = new ListNode(13);
        e.next = f;

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(a);
        list.add(d);

        ListNode result = mergeKLists(list);
        System.out.println(result);
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        pq.addAll(a);
        ListNode result = new ListNode(-1);
        ListNode current = result;

        while (!pq.isEmpty()) {
            ListNode removed = pq.poll();
            current.next = new ListNode(removed.val);
            current = current.next;
            removed = removed.next;
            if (removed != null) {
                pq.add(removed);
            }
        }
        return result.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}