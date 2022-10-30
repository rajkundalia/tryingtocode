package interviewbit.stacksandqueues;

import java.util.Stack;

/*
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.

NOTE: A will be always a valid expression.

Problem Constraints
1 <= |A| <= 105

Input Format
The only argument given is string A.

Output Format
Return 1 if A has redundant braces, else return 0.

Example Input
Input 1:
 A = "((a+b))"
Input 2:
 A = "(a+(a+b))"
Input 3:
 A = "((a*b)+(c+d))"

Example Output
Output 1:
 1
Output 2:
 0
Output 3:
 0

Example Explanation:
Explanation 1:
 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:
 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
Explanation 3:
 ((a*b)+(c+d)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {
    public static void main(String[] args) {
        System.out.println(braces("((a+b))"));
        System.out.println(braces("((a*b)+(c+d))"));
    }

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        int size = A.length();
        int i = 0;

        while (i < size) {
            char c = A.charAt(i);
            if (c == '(' || c == '+' || c == '*' || c == '-' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    return 1;
                } else {
                    while (!stack.empty() && stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            }
            i++;
        }
        return 0;
    }
}
