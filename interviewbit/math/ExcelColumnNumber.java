package interviewbit.math;

/*
Given a column title A as appears in an Excel sheet, return its corresponding column number.
Problem Constraints
1 <= |A| <= 100

Input Format
First and only argument is string A.

Output Format
Return an integer

Example Input
Input 1:
 "A"
Input 2:
 "AB"

Example Output
Output 1:
 1
Output 2:
 28


Example Explanation
Explanation 1:
 A -> 1
Explanation 2:
A  -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
 */
public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(solveExcelColumnNumber("AB"));
    }

    /*
        A->1
        ..
        Z->26
        ..
        AA->26x1+1
        AB->26x1+2
        ..
        CZ->26x3(C=3)+26(Z=26)
        ..
        ZZ->26x26(Z=26)+26(Z=26)
        ..
        AAA->26x26x1(A=1) + 26x1 + 1
        ..
        AAZ->26x26x1(A=1) + 26x1 + 26

     */
    public static int solveExcelColumnNumber(String A) {
        int result = 0;
        // Process is similar to Binary String to decimal conversion
        for (int i = 0; i < A.length(); i++) {
            result += Math.pow(26, A.length() - 1 - i) * (A.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
