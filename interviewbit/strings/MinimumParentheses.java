package interviewbit.strings;

/*
Given a string A of parantheses  ‘(‘ or ‘)’.
The task is to find minimum number of parentheses ‘(‘ or ‘)’ (at any positions) we must add to make the
resulting parentheses string valid.

A string is valid if:
Open brackets must be closed by the corresponding closing bracket.
Open brackets must be closed in the correct order.


Problem Constraints
1 <= |A| <= 105
A[i] = '(' or A[i] = ')'

Input Format
First and only argument is a string A.

Output Format
Return a single integer denoting the minimum number of parentheses ‘(‘ or ‘)’ (at any positions)
we must add in A to make the resulting parentheses string valid.

Example Input
Input 1:
 A = "())"
Input 2:
 A = "((("

Example Output
Output 1:
 1
Output 2:
 3

Example Explanation
Explanation 1:
 One '(' is required at beginning.
Explanation 2:
 Three ')' is required at end.
 */
public class MinimumParentheses {
    public static void main(String[] args) {
        System.out.println(solveMinimumParentheses("(("));
    }

    public static int solveMinimumParentheses(String A) {
        int openingBraces = 0, closingBraces = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                // 1. Count opening braces as encountered
                openingBraces++;
            } else if (openingBraces > 0) {
                // 2. decrease the count only if opening braces have been encountered in the past
                openingBraces--;
            }
            else {
                // 3. Count the closing braces
                closingBraces++;
            }
        }
        return Math.abs(openingBraces + closingBraces);
    }

    /*
    Stack<Character> st = new Stack<>();
        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(ch == '('){
                st.push('(');
            }else if(ch == ')'){
                if(st.size()>0 && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        return st.size();
     */
}
