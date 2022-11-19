package interviewbit.backtracking;

import java.util.ArrayList;

/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["a","a","b"]
    ["aa","b"],
  ]
Ordering the results in the answer :
Entry i will come before Entry j if :

len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR

(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))

In the given example,

   ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        backtrack(a, temp, result);
        return result;
    }

    private static void backtrack(String a, ArrayList<String> temp, ArrayList<ArrayList<String>> result) {
        if (a.length() == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < a.length(); i++) {
            String str = a.substring(0, i + 1);
            boolean palindrome = isPalindrome(str);
            if (palindrome) {
                temp.add(str);
                backtrack(a.substring(i + 1), temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
