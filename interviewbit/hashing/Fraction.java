package interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

Problem Constraints
INTMIN <= A, B <= INTMAX

Input Format
The first integer A represents the numerator.
The second integer B represents the denominator.

Output Format
Return a string

Example Input
Input 1:
A = 1
B = 2
Input 2:
A = 2
B = 1
Input 3:
A = 2
B = 3

Example Output
Output 1:
"0.5"
Output 2:
"2"
Output 3:
"0.(6)"

Example Explanation
Explanation 1:
Given numerator = 1, denominator = 2, return "0.5"
Explanation 1:
Given numerator = 2, denominator = 1, return "2"
Explanation 1:
Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class Fraction {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 3));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            res.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        res.append(a / b + ".");

        a = (a % b) * 10;
        while (!map.containsKey(a)) {
            map.put(a, res.length());
            res.append(a / b);
            a = (a % b) * 10;
            if (a == 0) {
                return res.toString();
            }
        }
        return res.insert(map.get(a), "(").append(")").toString();
    }
}
