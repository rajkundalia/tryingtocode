package leetcode.topinterview150;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("leetcode", "leeto"));
    }

    /*
    Two Pointer Approach.
    Take 2 pointers Left and Right, left poining to start of the string(index 0) and
    Right pointing to the length of needle (needle.length) :

    If the length of needle and haystack is same (they are either the same string or not)
    1.(a) If they are same string, return 0
    1.(b) Else, return -1
    If length of needle is greater than haystack, then you definitely won't find the needle in haystack. Hence, return -1
    Iterate the loop till the Right reaches the end of the haystack. Create a substring of
    Haystack from Left to Right and compare it with needle,
    3.(a) If both are same return Left index
    3.(b) Else Increment Left and Right both by 1
    If at the end of the loop, you still haven't found the needle in the Haystack, return -1
     */
    public int strStr(String haystack, String needle) {
        int nl = needle.length();
        int i = 0;
        int j = i + nl;
        int hl = haystack.length();

        if (nl == hl) {
            if (needle.equals(haystack)) {
                return 0;
            }
            return -1;
        } else if (nl > hl) {
            return -1;
        }

        while (j <= hl) {
            if (needle.equals(haystack.substring(i, j))) {
                return i;
            }

            i++;
            j++;
        }
        return -1;
    }
}
