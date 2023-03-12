package interviewbit.dynamicprogramming;

import java.util.Stack;

/*
Given a string A containing just the characters ’(‘ and ’)’.
Find the length of the longest valid (well-formed) parentheses substring.

Input Format:
The only argument given is string A.
Output Format:
Return the length of the longest valid (well-formed) parentheses substring.
Constraints:
1 <= length(A) <= 750000
For Example:
Input 1:
    A = "(()"
Output 1:
    2
    Explanation 1:
        The longest valid parentheses substring is "()", which has length = 2.

Input 2:
    A = ")()())"
Output 2:
    4
    Explanation 2:
        The longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParentheses().longestValidParenthesesOptimized(")()())"));
    }

    /*
        Algorithm: Primary Approach

        create a stack with -1 as left end point.
        Iterate over all the characters of string from left to right.
        if current character is opening bracket push its index to stack.
        if current character is closing bracket.
        - pop from stack
        - if stack is empty then push current index as new left end point
        - else we found a valid expression between current index and left end point which is top element of stack
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    //https://medium.com/@rohitverma_87831/longest-valid-parentheses-86aa17690fb0

    /*
        Optimized:

        “(()())()”
        A key observation is at any given index, no of opening brackets is greater than or equal
        to no of closing brackets.

        So if we just maintains a count of opening parenthesis and closing parenthesis at every point.

        At any point if we get no of closing greater than no of opening than we need to reset our
        counters as its impossible to create a valid expression now.

        For example “)()()” at first index no of closing is greater than no of opening than this index cannot be a
        part of valid expression.

        Also we can do that same opening closing parenthesis counter using single variable which just
        maintains difference of opening and closing bracket

        Condition will be diff should always be ≥ 0

        int maxLen = 0;
        int diff = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')diff++;
            else diff--;

            if(diff < 0) {diff = 0; start=i+1;}
            if(diff == 0) {
                maxLen = Math.max(maxLen, i-start+1);
            }
        }

        But there is a problem with this solution. Consider example “((()” in this diff == 0 condition will never
        hit so we get 0 as output.

        Whats the fix for this? We can again do the same thing from right to left and this time no of closing
        bracket ≥ no of opening bracket.
     */
    public int longestValidParenthesesOptimized(String s) {
        int maxLen = 0;
        int diff = 0;
        int start = 0;

        // left to right scan
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                diff++;
            } else {
                diff--;
            }

            // reset start and diff
            if (diff < 0) {
                diff = 0;
                start = i + 1;
            }

            if (diff == 0) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }

        diff = 0;
        int end = s.length() - 1;
        // right to left scan
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                diff++;
            } else {
                diff--;
            }

            // reset start and diff
            if (diff < 0) {
                diff = 0;
                end = i - 1;
            }

            if (diff == 0) {
                maxLen = Math.max(maxLen, end - i + 1);
            }
        }

        return maxLen;
    }

}
