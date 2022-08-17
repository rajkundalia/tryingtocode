package interviewbit.strings;

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11. 11 is read off as two 1s or 21.
21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.

Example:
if n = 2, the sequence is 11.
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int A) {
        int count = 1;
        String str1 = "1";
        String temp = "";
        int i;
        int j;
        int s1;

        if (A <= 1) {
            return str1;
        }

        for (i = 2; i <= A; i++) {
            count = 1;
            j = 0;
            s1 = str1.length();

            while (j < s1) {
                // Keeping count of the current character
                if (j + 1 < s1 && str1.charAt(j) == str1.charAt(j + 1)) {
                    count++;
                    j++;
                } else {
                    // Append the count and current character
                    temp += count;
                    temp += String.valueOf(str1.charAt(j));
                    count = 1;
                    j++;
                }
            }
            // Store the current result.
            str1 = temp;
            temp = "";
        }
        return str1;
    }
}
