package interviewbit.strings;

/*
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().
strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

NOTE: String A is haystack, B is needle.

Good clarification questions:

What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("nsjfksdg", "fk"));
    }

    public static int strStr(final String A, final String B) {
        int lA = A.length();
        int lB = B.length();
        if (lA == 0 || lB == 0) {
            return -1;
        }
        if (lA < lB) {
            return -1;
        }
        int j = 0;
        for (int i = 0; i < lA; i++) {
            for (j = 0; j < lB && (i + j) < lA; j++) {
                if (A.charAt(i + j) == B.charAt(j)) { // i+j to cover needle
                    continue;
                } else {
                    break;
                }
            }
            if (j == lB) {
                return i;
            }
        }
        return -1;
    }
}
