package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated
sequence of one or more dictionary words.

Problem Constraints
1 <= len(A) <= 6500
1 <= len(B) <= 10000
1 <= len(B[i]) <= 20

Input Format
The first argument is a string, A.
The second argument is an array of strings, B.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
Input 1:
 A = "myinterviewtrainer",
B = ["trainer", "my", "interview"]
Input 2:
A = "a"
B = ["aaa"]

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
Explanation 2:
Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("myinterviewtrainer",
                new ArrayList<>(List.of("trainer", "my", "interview"))));
    }

    Map<String, Integer> map = new HashMap<>();

    public int wordBreak(String A, ArrayList<String> B) {
        if (B.contains(A)) {
            return 1;
        }
        if (map.containsKey(A)) {
            return map.get(A);
        }
        for (int i = 1; i <= A.length(); i++) {
            String left = A.substring(0, i);
            if (B.contains(left) && wordBreak(A.substring(i), B) == 1) {
                map.put(A, 1);
                return 1;
            }
        }
        map.put(A, 0);
        return 0;
    }
}
