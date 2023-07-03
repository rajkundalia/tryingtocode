package leetcode.topinterview150;

import java.util.HashSet;

/*
Given a string s, find the length of the longest
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char ch = s.charAt(0);
        String ans = "";
        ans += ch;
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            int index = ans.indexOf(ch);
            if (index == -1) {
                ans += ch;
                max = Math.max(max, ans.length());
            } else {
                ans = ans.substring(index + 1) + ch;
                //if s="dvdf", and when we encounter 2nd d, we need the new ans as "vd" and not just "d"
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int acquire = 0;
        int release = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        while (acquire < s.length()) {
            if (!set.contains(s.charAt(acquire))) {
                set.add(s.charAt(acquire));
                acquire++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(release));
                release++;
            }
        }
        return max;
    }
}
