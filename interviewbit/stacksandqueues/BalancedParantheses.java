package interviewbit.stacksandqueues;

import java.util.LinkedList;

/*
Given a string A consisting only of '(' and ')'.
You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.

Problem Constraints
1 <= |A| <= 105

Input Format
First argument is an string A.

Output Format
Return 1 if parantheses in string are balanced else return 0.

Example Input
Input 1:
 A = "(()())"
Input 2:
 A = "(()"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Given string is balanced so we return 1
Explanation 2:
 Given string is not balanced so we return 0
 */
public class BalancedParantheses {
    public static void main(String[] args) {
        System.out.println(solve("(()"));
    }

    public static int solve(String A) {
        LinkedList<String> list = new LinkedList<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            String c = A.substring(i, i + 1);
            if (c.equals("(")) {
                list.push(c);
            } else {
                String s;
                if (!list.isEmpty()) {
                    s = list.pop();
                    if (!(s.equals("(") && c.equals(")"))) {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
        if (!list.isEmpty()) {
            return 0;
        }
        return 1;
    }
}

/*
Stack<Character> st=new Stack<>();
        for(int i=0;i<A.length();i++)
        {
            char ch=A.charAt(i);
            if(st.empty())
            {
                st.push(ch);
            }
            else
            {
                if(ch=='(')
                st.push(ch);
                else
                {
                    if(st.peek()==')')
                    return 0;
                    else st.pop();
                }
            }
        }
        if(st.empty())
        return 1;
        else return 0;
 */
