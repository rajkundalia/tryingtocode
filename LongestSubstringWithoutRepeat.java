package interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

/*
Given a string,
find the length of the longest substring without repeating characters.
Example:
The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String A) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int n = A.length();
        Map<Character, Integer> map = new HashMap<>();

        while (end < n) {
            char c = A.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.put(A.charAt(start), map.get(A.charAt(start)) - 1);
                start++;
            }
            end++;
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}
