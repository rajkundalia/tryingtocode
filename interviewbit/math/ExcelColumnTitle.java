package interviewbit.math;

/*
Given a positive integer A, return its corresponding column title as appear in an Excel sheet.

Problem Constraints
1 <= A <= 1000000000

Input Format
First and only argument is integer A.

Output Format
Return a string, the answer to the problem.

Example Input
Input 1:
 A = 1
Input 2:
 A = 28

Example Output
Output 1:
 "A"
Output 2:
 "AB"
 */
public class ExcelColumnTitle {
    public static void main(String[] args) {
        System.out.println(solveExcelColumnTitle(943566));
    }

    public static String solveExcelColumnTitle(int A) {
        String result = "";
        while (A != 0) {
            A--;
            int rem = A % 26;
            char c = (char) (rem + 'A');
            result = c + result;
            A /= 26;
        }
        return result;
    }
}
