package interviewbit.strings;

/*
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.
Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Note : This question has a lot of scope of clarification from the interviewer.
Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output”

For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations.

Input Format
The only argument given is integer A.
Output Format
Return a string denoting roman numeral version of A.

Constraints
1 <= A <= 3999
For Example

Input 1:
    A = 5
Output 1:
    "V"

Input 2:
    A = 14
Output 2:
    "XIV"
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }


    // I = 1
    // V = 5
    // X = 10
    // L = 50
    // C = 100
    // D = 500
    // M = 1000

    //CM = 900      3DIGITS
    //DC = 600
    //CD = 400
    //XC = 90

    // XL = 40      2 DIGITS

    // IX = 9       1 DIGIT
    // IV =4

    public static String intToRoman(int A) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[A / 1000] +
                hundreds[(A % 1000) / 100] +
                tens[(A % 100) / 10] +
                units[A % 10];
    }
}
