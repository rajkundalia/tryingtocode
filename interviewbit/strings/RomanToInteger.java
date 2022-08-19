package interviewbit.strings;

import java.util.HashMap;
import java.util.Map;

/*
Given a string A representing a roman numeral.
Convert A into integer.
A is guaranteed to be within the range from 1 to 3999.
NOTE: Read more details about roman numerals at Roman Numeric System

Input Format
The only argument given is string A.
Output Format
Return an integer which is the integer verison of roman numeral string.
For Example
Input 1:
    A = "XIV"
Output 1:
    14

Input 2:
    A = "XX"
Output 2:
    20
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));
    }

    public static int romanToInt(String A) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            if (i > 0 && map.get(A.charAt(i)) > map.get(A.charAt(i - 1))) {
                result += map.get(A.charAt(i)) - (2 * map.get(A.charAt(i - 1)));
            } else {
                result += map.get(A.charAt(i));
            }
        }
        return result;
    }
}
