package interviewbit.strings;

import java.util.Arrays;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR

Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as
A....C
...B....D
and hence the answer would be ACBD.
 */
public class ZigzagString {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 2));
    }

    public static String convert(String A, int B) {
        if (B >= A.length() || B == 1) {
            return A;
        }
        String[] splitA = A.split("");
        String[] result = new String[B];
        Arrays.fill(result, "");
        int k = 0;
        int flag = 0;

        // One thing for sure we know that we have to take only one character from each column,
        // So we can iterate it by rows and will take character one by one.
        for (int i = 0; i < A.length(); i++) {
            result[k] += splitA[i];

            // The real problem here is that from the start the rows are getting incremented by 1,
            // and once it reached end, then it will get decremented by 1, and so on.

            // To keep that in check we can use flag variable, that tells us to whether we should increment the row or not.
            if (k == B - 1) { // If you reach the end, then start decrementing the row
                k--;
                flag = 1;
            } else if (k == 0) { // If you are at the start, then keep incrementing the row
                k++;
                flag = 0;
            } else if (flag == 1) {
                k--;
            } else {
                k++;
            }
        }
        String ans = "";
        for (int i = 0; i < B; i++) {
            ans += result[i];
        }
        return ans;
    }
}
