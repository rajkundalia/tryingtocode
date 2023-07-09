package leetcode.topinterview150;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        // O(n) time | O(n) space
        HashMap<Character, String> myMap = new HashMap<>();
        String[] words = s.split(" ");

        // pattern = " a b c" && s = "mice cat dog chicken" then return false directly
        if (pattern.length() != words.length) return false;

        // update myMap in for-loop
        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);

            if (!myMap.containsKey(ch)) {
                // we need to check the case that, we dont' have such a key in map but value already exists
                // for example, pattern = "abab" && s = "dog dog dog dog"
                if (myMap.containsValue(words[i])) {
                    return false;
                }

                myMap.put(ch, words[i]);
            } else if (!myMap.get(ch).equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
