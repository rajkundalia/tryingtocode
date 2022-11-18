package interviewbit.backtracking;

import java.util.ArrayList;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.

1-1
2-abc
3-def
4-ghi
5-jkl
6-mno
7-pqrs
8-tuv
9-wxyz
0-0

The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
 */
public class LetterPhone {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static ArrayList<String> letterCombinations(String a) {
        String[] str = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder store = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        if (a.length() == 0) {
            return result;
        }
        backtrack(0, a, result, store, str);
        return result;
    }

    private static void backtrack(int i, String a, ArrayList<String> result, StringBuilder store, String[] str) {
        if (i == a.length()) {
            result.add(store.toString());
            return;
        }

        int tempI = a.charAt(i) - '0';
        String tempS = str[tempI];

        for (int j = 0; j < tempS.length(); j++) {
            char c = tempS.charAt(j);
            store.append(c);
            backtrack(i + 1, a, result, store, str);
            store.deleteCharAt(store.length() - 1);
        }
    }
}
