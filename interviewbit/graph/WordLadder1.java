package interviewbit.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given two words A and B, and a dictionary C, find the length of shortest transformation sequence from A to B, such that:

You must change exactly one character in every transformation.
Each intermediate word must exist in the dictionary.
NOTE:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


Problem Constraints
1 <= length(A), length(B), length(C[i]) <= 25
1 <= length(C) <= 5000


Input Format
The first argument of input contains a string, A.

The second argument of input contains a string, B.

The third argument of input contains an array of strings, C.



Output Format
Return an integer representing the minimum number of steps required to change string A to string B.



Example Input
Input 1:

 A = "hit"
 B = "cog"
 C = ["hot", "dot", "dog", "lot", "log"]
Input 2:

 A = "cat"
 B = "bat"
 C = ["rat"]
Input 3:

 A = "bait"
 B = "pant"
 C = ["a","b"]


Example Output
Output 1:

 5
Output 2:

 2
Output 3:

 0


Example Explanation
Explanation 1:

 "hit" -> "hot" -> "dot" -> "dog" -> "cog"
Explanation 2:

 "cat" -> "bat"
Explanation 3:

 No intermediate words are present in the given dictionary so transformation is not possible. We will return 0 for this case.
 */
public class WordLadder1 {
    public static void main(String[] args) {
        System.out.println(new WordLadder1().solve("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solve(String beginWord, String endWord, String[] wordList) {
        // BFS to find the shortest path
        Queue<String> queue = new LinkedList<>();
        // HashSet constructor only accept Collections
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String cur = queue.poll();
                // reach the endWord
                if (cur.equals(endWord)) {
                    return step;
                }
                // add all its unvisited neighbor to the queue
                for (String word : wordList) {
                    if (visited.contains(word)) {
                        continue;
                    }
                    if (isNeighbour(cur, word)) {
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean isNeighbour(String w1, String w2) {
        // w1 and w2 have same length
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) diff++;
            // early stop
            if (diff > 1) return false;
        }
        return true;
    }

}
