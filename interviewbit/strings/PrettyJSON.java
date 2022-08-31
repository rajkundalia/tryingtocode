package interviewbit.strings;

import java.util.ArrayList;
import java.util.Collections;

/*
Given a string A representating json object. Return an array of string denoting json object with proper indentation.

Rules for proper indentation:

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Note:
[] and {} are only acceptable braces in this case.
Assume for this problem that space characters can be done away with.

Input Format
The only argument given is the integer array A.
Output Format
Return a list of strings, where each entry corresponds to a single line. The strings should not have "\n" character in them.
For Example
Input 1:
    A = "{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}"
Output 1:
    {
        A:"B",
        C:
        {
            D:"E",
            F:
            {
                G:"H",
                I:"J"
            }
        }
    }

Input 2:
    A = ["foo", {"bar":["baz",null,1.0,2]}]
Output 2:
   [
        "foo",
        {
            "bar":
            [
                "baz",
                null,
                1.0,
                2
            ]
        }
    ]
 */
public class PrettyJSON {
    public static void main(String[] args) {
        System.out.println(prettyJSON("{A:B,C:{D:E,F:{G:H,I:J}}}"));
    }

    public static ArrayList<String> prettyJSON(String A) {
        ArrayList<String> ans = new ArrayList<>();

        int openBrace = 0;
        int closedBrace = 0;
        StringBuilder sb = new StringBuilder("");
        char[] chars = A.toCharArray();

        for (char c : chars) {
            if ("{[".indexOf(c) != -1) {
                if (sb.length() != 0) {
                    ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb);
                    sb.setLength(0);
                }
                openBrace++;
                sb.append(c);
                ans.add(String.join("", Collections.nCopies(openBrace - closedBrace - 1, "\t")) + sb);
                sb.setLength(0);
            } else if ("}]".indexOf(c) != -1) {
                if (sb.length() != 0) {
                    ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb);
                    sb.setLength(0);
                }
                closedBrace++;
                sb.append(c);
            } else if (c == ',') {
                sb.append(',');
                ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (sb.length() != 0) {
            ans.add(sb.toString());
        }

        return ans;
    }
}
