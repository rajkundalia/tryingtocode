package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {
        //System.out.println(str + " open=" + open + " close=" + close + " max=" + max);
        if (str.length() == max * 2) {
            //System.out.println("return " + str);
            list.add(str);
            return;
        }

        if (open < max) {
            //System.out.println(str + " open=" + open + " close=" + close + " max=" + max);
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            //System.out.println(str + " open=" + open + " close=" + close + " max=" + max);
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}
