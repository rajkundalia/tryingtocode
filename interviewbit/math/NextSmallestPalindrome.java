package interviewbit.math;

import java.math.BigInteger;

/*
Given a numeric string A representing a large number you need to find the next smallest palindrome greater than this number.

Problem Constraints
1 <= |A| <= 100

A doesn't start with zeroes and always contain digits from 0-9.

Input Format
First and only argument is an string A.

Output Format
Return a numeric string denoting the next smallest palindrome greater than A.

Example Input
Input 1:
 A = "23545"
Input 2:
 A = "999"
Example Output
Output 1:
 "23632"
Output 2:
 "1001"

 https://youtu.be/pBYTiYyckGA
 https://chaudhary1337.com/next-smallest-palindrome-solution-explained-in-detail/
 */
public class NextSmallestPalindrome {
    public static void main(String[] args) {
        System.out.println(solveNextSmallestPalindrome("184963788291359953192887369481"));
    }

    public static String solveNextSmallestPalindrome(String a) {
        if (isPalindrome(a)) {
            a = addOne(a);
        }
        if (isPalindrome(a)) {
            return a;
        }
        int n = a.length();
        if (n % 2 != 0) {
            return handleOddCase(a);
        } else {
            return handleEvenCase(a);
        }
    }

    // The first thing we note from the example “99” is that we need to be able to detect palindromes,
    // so that we can find the next one – we don’t want to return the same number again!
    public static boolean isPalindrome(String a) {
        return new StringBuilder(a).reverse().toString().equals(a);
    }

    // If we have a palindrome, we need to be able to add 1 to the number,
    // so that we can then treat it as a normal number.
    public static String addOne(String a) {
        return String.valueOf(new BigInteger(a).add(BigInteger.ONE));
    }

    public static int compare(String x, String y) {
        BigInteger l = new BigInteger(x);
        BigInteger r = new BigInteger(y);
        return (l.compareTo(r));
    }

/*  Odd Cases:
    “23545” –> “23632”, since we can go to 600s (the mid position) instead of 500s and
    repeat the flipped 23 substring.

    “97531” –> “97579”, since we don’t need to go to 600s and we can stay at 500s and
    repeat the left substring, flipped to the right.
    It looks like flipping the left substring is a common pattern.

    To formalize:
    get the right and left substrings (middle not included).
    check if the left substring is greater than right substring.
    True: copy paste the reversed left substring in-place of right
    False: increase the middle value by 1 and then do the same as above:
    return the new string

    With the example:
    “23545” –> left = “23”, mid = “5”, right = “45”
    “23” > “45”?
    False: mid = “5” –> mid = “6”. Then, “23” + “6” + “32” (“23” reversed)

    Edge case:
    What if the mid digit is 9? like in “23945″. In that case, we need to add 1, but the 9 will become 10.
    So, the number becomes “24045”.
    We can then proceed as usual, but this becomes an important point – increasing
    the middle by 1 can have consequences that affect the left substring.
    Perhaps we can consider merging the left substring and the mid character?

    Done? I’ll show you one: “53545”.

    “53545” –> left = “53”, mid = “5”, right = “45”
    is left > right? === “53” > “45”?
    True: so, the answer is “53” + “5” + “35” = “53535”
    Something does look off!
    The number we returned is lesser than the one we started.
    That’s because of one big flaw. We don’t compare left with right, but reversed left with right.
    That’s because when returning, we have left + mid + reversed(left) kind of logic.
    So, it only makes sense to compare right with the reversed left.
 */

    public static String handleOddCase(String a) {
        int n = a.length();
        int mid = n / 2;
        String left = a.substring(0, mid);
        String midNum = a.substring(mid, mid + 1);
        String right = a.substring(mid + 1);
        String leftReverse = new StringBuilder(left).reverse().toString();

        if (compare(leftReverse, right) == 1) { // left > right
            return left + midNum + leftReverse;
        } else {
            left = left + midNum;
            left = addOne(left);
            return left + new StringBuilder(left).reverse().substring(1);
        }
    }

    /*  Even Case:
        Examples:
        “2363” –> “2442”
        “3428” –> “3443”
        These look pretty much the same as the odd cases. To formalize:

        find the left and right substrings
        reversed(left) > right?
        True: return left + reversed(left)
        False: add 1 to left and do the same as above
        */
    public static String handleEvenCase(String a) {
        int n = a.length();
        int mid = n / 2;
        String left = a.substring(0, mid);
        String right = a.substring(mid);

        String leftReverse = new StringBuilder(left).reverse().toString();

        if (compare(leftReverse, right) == -1) {
            left = addOne(left);
            return left + new StringBuilder(left).reverse();
        } else {
            return left + leftReverse;
        }
    }

    /* Edge Case:
    We are almost done, but there’s one teeny tiny case that still remains.
    This case wasn’t obvious to me the first time. The case is that of single digits.
    See, with our logic, if we get an input like “5”, we will see it's a palindrome
    (yes we still check for that!) and then add 1 to it. Now “6” is an odd length case,
    so we extract the left = “”, right= “”. Since they are the same, we go to the else condition and add 1 more.
    Now, we finally return “7”.
    Incorrect! We should have returned at “6” itself.
    So, we will add just one more line in the implementation.
    If the number after adding one to it, is also a palindrome, we can return early.
     */
}















