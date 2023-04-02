package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string A and a dictionary of words B, add spaces in A to construct a sentence where
each word is a valid dictionary word.

Return all such possible sentences.
Note : Make sure the strings are sorted in your result.
Input Format:
The first argument is a string, A.
The second argument is an array of strings, B.
Output Format:
Return a vector of strings representing the answer as described in the problem statement.
Constraints:
1 <= len(A) <= 50
1 <= len(B) <= 25
1 <= len(B[i]) <= 20
Examples:
Input 1:
    A = "b"
    B = ["aabbb"]
Output 1:
    []
Input 1:
    A = "catsanddog",
    B = ["cat", "cats", "and", "sand", "dog"]
Output 1:
    ["cat sand dog", "cats and dog"]
 */
public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("catsanddog",
                new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"))));
    }

    public ArrayList<String> wordBreak(String s, ArrayList<String> dict) {
        //create an array of ArrayList<String>
        Set<String> foo = new HashSet<>(dict);
        ArrayList<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null)
                continue;

            for (String word : foo) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        if (dp[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);
        Collections.sort(result);
        return result;
    }


    private void dfs(List<String> dp[], int end, List<String> result, ArrayList<String> tmp) {
        if (end <= 0) {
            String path = tmp.get(tmp.size() - 1);
            for (int i = tmp.size() - 2; i >= 0; i--) {
                path += " " + tmp.get(i);
            }

            result.add(path);
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}




