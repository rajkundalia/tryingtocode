package interviewbit.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
You are given an integer A. You have to find the smallest multiple of A which consists of digits 0 and 1 only.
Since this multiple could be large, return it in form of a string.
Note: Returned string should not contain leading zeroes.

Problem Constraints
1 <= A <= 105

Input Format
The first argument is an integer A.

Output Format
Return a string equal to the smallest multiple of A which consists of digits 0 and 1 only

Example Input
Input 1:
55
Input 2:
2

Example Output
Output 1:
110
Output 2:
10

Example Explanation
Explanation 1:
110 is the smallest integer which is divisible by 55 and contains 0 and 1 only
Explanation 2:
10 is the smallest integer which is divisible by 2 and contains 0 and 1 only
 */
public class SmallestWithMultiple0And1 {
    public static void main(String[] args) {
        System.out.println(new SmallestWithMultiple0And1().multiple(55));
    }

    public String multiple(int A) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node("1", 1 % A));
        boolean[] visited = new boolean[A];
        visited[1 % A] = true;

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            if (node.modN == 0) {
                return node.value;
            }

            int s1 = (node.modN * 10) % A;
            int s2 = (node.modN * 10 + 1) % A;

            if (!visited[s1]) {
                deque.addLast(new Node(node.value + "0", s1));
                visited[s1] = true;
            }

            if (!visited[s2]) {
                deque.addLast(new Node(node.value + "1", s2));
                visited[s2] = true;
            }
        }

        return "";
    }

    public static class Node {
        String value;
        int modN = -1;

        public Node(String x, int y) {
            value = x;
            modN = y;
        }
    }

    // time exceeded
//    public String multiple(int A) {
//        String s = "1";
//        Set<Integer> set = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.add(s);
//
//        while (!queue.isEmpty()) {
//            String val = queue.poll();
//            int remainder = getMod(val, A);
//            if (remainder == 0) {
//                return val;
//            } else if(!set.contains(remainder)) {
//                set.add(remainder);
//                queue.add(val + "0");
//                queue.add(val + "1");
//            }
//        }
//        return "";
//    }
//
//    private int getMod(String s, int A) {
//        int r = 0;
//        for (int i = 0; i < s.length(); i++) {
//            r = r * 10 + s.charAt(i) - 48;
//            r = r % A;
//        }
//        return r;
//    }
}
