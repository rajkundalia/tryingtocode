package interviewbit.backtracking;

import java.util.ArrayList;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 */
/*
Forn = 2, the recursion tree will be something like this,

								   	(0, 0, '')
								 	    |
									(1, 0, '(')
								   /           \
							(2, 0, '((')      (1, 1, '()')
							   /                 \
						(2, 1, '(()')           (2, 1, '()(')
						   /                       \
					(2, 2, '(())')                (2, 2, '()()')
						      |	                             |
					res.append('(())')             res.append('()()')
 */
public class GenerateAllParenthesesII {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, 0, 0, "", n);
        return result;
    }

    /*
    The idea is to add ')' only after valid '('
    We use two integer variables left & right to see how many '(' & ')' are in the current string
    If left < n then we can add '(' to the current string
    If right < left then we can add ')' to the current string
     */
    private static void backtrack(ArrayList<String> result, int left, int right, String s, int n) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        if (left < n) {
            backtrack(result, left + 1, right, s + "(", n);
        }

        if (right < left) {
            backtrack(result, left, right + 1, s + ")", n);
        }
    }

}
