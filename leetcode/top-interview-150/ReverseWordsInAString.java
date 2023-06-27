package leetcode.topinterview150;

import java.util.Arrays;
import java.util.Collections;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("  hello world  "));
        System.out.println(new ReverseWordsInAString().reverseWords("hello world"));

        System.out.println(new ReverseWordsInAString().reverseWords1("  hello world  "));
        System.out.println(new ReverseWordsInAString().reverseWords1("hello world"));
    }

    public String reverseWords1(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public String reverseWords(String s) {
        String result = "";
        int i = 0;
        int n = s.length();

        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= n) {
                break;
            }
            int j = i + 1;

            while (j < n && s.charAt(j) != ' ') {
                j++;
            }
            String sub = s.substring(i, j);
            if (result.length() == 0) {
                result = sub;
            } else {
                result = sub + " " + result;
            }
            i = j + 1;
        }
        return result;
    }
}
