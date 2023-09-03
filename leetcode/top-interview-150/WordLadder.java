package leetcode.topinterview150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the
shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>(); // perform BFS to find next word
        Set<String> set = new HashSet<>(wordList); // store word list as set

        // check if endWord is in set
        if (!set.contains(endWord)) return 0;

        // if both are same simply return 1
        if (beginWord.equals(endWord)) return 1;

        int count = 1; // initialize to 1 to count beginWord itself

        queue.add(beginWord);
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // for all words at this level
            for (int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();

                // traverse current word
                for (int j = 0; j < word.length; j++) {
                    // store initial character at index j
                    char temp = word[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;

                        String nextWord = new String(word);

                        if (nextWord.equals(endWord)) return count + 1;

                        if (set.contains(nextWord)) {
                            set.remove(nextWord);
                            queue.add(nextWord);
                        }
                    }
                    // reset character at index j for next iterations
                    word[j] = temp;
                }
            }

            count++;
        }
        // if no path to endWord possible return 0
        return 0;
    }
}


