package interviewbit.strings;

/*
 Given a password as a character array A.
Check if it is valid or not.
Password should have at least one numerical digit(0-9).
Password's length should be in between 8 to 15 characters.
Password should have at least one lowercase letter(a-z).
Password should have at least one uppercase letter(A-Z).
Password should have at least one special character ( @, #, %, &, !, $, *).

Problem Constraints
1 <= |A| <= 20

Input Format
Given a character array A.

Output Format
Return an integer.

Example Input
Input 1:
A = ['S', 'c', 'a', 'l', 'e', 'r', '@', '1']
Input 2:
A = ['I', 'n', 't', 'e', 'r', 'v', 'i', 'e', 'w', 'B', 'i', 't']

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
All the characteristic required for password are present in given password.
Explanation 2:
The password given does not have any special character and also it does not have any numerical digit.
 */
public class ValidPassword {
    public static void main(String[] args) {
        System.out.println(solve("Scaler@1"));
    }

    public static int solve(String A) {
        int n = A.length();
        boolean f1 = false, f2 = false, f3 = false, f4 = false, f5 = false;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                f1 = true;
            } else if (A.charAt(i) >= 'A' && A.charAt(i) <= 'Z') {
                f2 = true;
            } else if (A.charAt(i) >= '0' && A.charAt(i) <= '9') {
                f3 = true;
            } else if (A.charAt(i) == '@' || A.charAt(i) == '#' || A.charAt(i) == '%' || A.charAt(i) == '&'
                    || A.charAt(i) == '!' || A.charAt(i) == '$' || A.charAt(i) == '*') {
                f4 = true;
            }
        }

        if (n >= 8 && n <= 15) {
            f5 = true;
        }

        if (f1 && f2 && f3 && f4 && f5) {
            return 1;
        }
        return 0;
    }
}