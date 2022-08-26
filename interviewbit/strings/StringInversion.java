package interviewbit.strings;

/*
Given a string A. Change the cases of all the characters.
If the character is lowercase convert it to uppercase and if the character is uppercase convert it to lowercase.
Note: All the characters in the string are latin uppercase or lowercase letters.

Problem Constraints
1 <= |A| <= 105

Input Format
Given a string A.

Output Format
Return a string.

Example Input
Input 1:
A = 6 = "InterviewBit"
Input 2:
A = "Scaler"

Example Output
Output 1:
"iNTERVIEWbIT"
Output 2:
"sCALER"
 */
public class StringInversion {
    public static void main(String[] args) {
        System.out.println(solve("InterviewBit"));
    }

    public static String solve(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            if (Character.isLowerCase(cc)) {
                ans.append(Character.toUpperCase(cc));
            } else {
                ans.append(Character.toLowerCase(cc));
            }
        }
        return ans.toString();
    }
}
