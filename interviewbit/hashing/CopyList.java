package interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

/*
A linked list is given such that each node contains an additional random pointer which could point to
any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list,
but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
public class CopyList {
    public static void main(String[] args) {

    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;

        while (current != null) {
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }

        current = head;

        while (current != null) {
            RandomListNode copy = map.get(current);
            if (current.next != null) {
                copy.next = map.get(current.next);
            }
            copy.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
