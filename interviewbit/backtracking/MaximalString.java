package interviewbit.backtracking;

/*
Given a string A and integer B, what is maximal lexicographical string that can be made from A if you do at most B swaps.

Problem Constraints
1 <= |A| <= 9
A contains only digits from 0 to 9.
1 <= B <= 5

Input Format
First argument is string A.
Second argument is integer B.

Output Format
Return a string, the naswer to the problem.

Example Input
Input 1:
A = "254"
B = 1
Input 2:
A = "254"
B = 2

Example Output
Output 1:
 524
Output 2:
 542

Example Explanation
Explanation 1:
 Swap 2 and 5.
Explanation 2:
Swap 2 and 5 then swap 4 and 2.
 */
public class MaximalString {
    static String ans = "";

    public static void main(String[] args) {
        System.out.println(solve("254", 2));
    }

    public static String solve(String A, int B) {
        ans = A;
        char[] str = A.toCharArray();
        backtracking(str, B);
        return ans;
    }

    private static void backtracking(char[] str, int b) {
        if (b <= 0) {
            return;
        }

        for (int i = 0; i < str.length; i++) {
            int n1 = Integer.parseInt(str[i] + "");
            for (int j = i + 1; j < str.length; j++) {
                int n2 = Integer.parseInt(str[j] + "");
                if (n2 > n1) {
                    // swap
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;

                    String probableAns = "";
                    for (int k = 0; k < str.length; k++) {
                        probableAns += str[k];
                    }
                    // comparing
                    if (Integer.parseInt(ans) < Integer.parseInt(probableAns)) {
                        ans = probableAns;
                    }
                    // calling with new string
                    backtracking(str, b - 1);
                    //bactracking the string
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }
}
