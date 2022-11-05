package interviewbit.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
An arithmetic expression is given by a string array A of size N.
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Problem Constraints
1 <= N <= 105

Input Format
The only argument given is string array A.

Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.

Example Input
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]

Example Output
Output 1:
    9
Output 2:
    6

Example Explanation
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        //System.out.println(evalRPN(new ArrayList<>(List.of("2", "1", "+", "3", "*"))));
        System.out.println(evalRPN(new ArrayList<>(List.of("2", "2", "/"))));
    }

    /*
        post fix

        b*b - 4*a*c
        (bb*) - 4*a*c
        bb* - 4*(ac*)
        bb* - 4(ac*)*
        bb*4ac**-


     */
    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> s = new Stack<>();

        if (A.size() < 3) {return Integer.parseInt(A.get(A.size() - 1));}

        for (int i = 0; i < A.size(); i++) {
            String str = A.get(i);

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int operand2 = s.peek();
                s.pop();
                int operand1 = s.peek();
                s.pop();
                int val = 0;
                if (str.equals("+")) {
                    val = operand1 + operand2;
                } else if (str.equals("-")) {
                    val = operand1 - operand2;
                } else if (str.equals("*")) {
                    val = operand1 * operand2;
                } else {
                    val = operand1 / operand2;
                }
                s.push(val);
            } else {
                s.push(Integer.parseInt(str));
            }
        }
        return s.peek();
    }
}
