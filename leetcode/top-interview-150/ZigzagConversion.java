package leetcode.topinterview150;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        int len = s.length();

        if (len <= numRows || numRows <= 1) {
            return s; // such condition cannot form a zigzag route
        }

        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        //Traverse zig zag
        while (index < n) {
            // go down
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }

            // go up before start
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(arr[index++]);
            }
        }

        // Combine all stringbuilders into one
        StringBuilder res = sbs[0];

        for (int i = 1; i < numRows; i++) {
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
