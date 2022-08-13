package interviewbit.strings;

/*
Given a string A consisting of lowercase characters.
You have to find the number of substrings in A which starts with vowel and end with consonants or vice-versa.
Return the count of substring modulo 10^9 + 7.

Problem Constraints
1 <= |A| <= 105
A consists only of lower-case characters.

Input Format
First argument is an string A.

Output Format
Return a integer denoting the number of substrings in A which starts with vowel and end with
consonants or vice-versa with modulo 10^9 + 7.

Example Input
Input 1:
 A = "aba"
Input 2:
 A = "a"

Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:
 Substrings of S are : [a, ab, aba, b, ba, a]
 Out of these only 'ab' and 'ba' satisfy the condition for special Substring. So the answer is 2.
Explanation 2:
 No possible substring that start with vowel and end with consonant or vice-versa.
 */
public class VowelAndConsonantSubstrings {
    public static void main(String[] args) {
        System.out.println(solve("aba"));
    }

    /*
        Approach:
        Example: “aba”
        Take the count of both vowel and consonants using a for loop.
        Now iterate over each char of string, whenever you find a vowel, the number of substrings that can be formed is
        equal to the number of consonants.
        So add count of consonants to answer. similarly, when you get consonants add the count of vowels to the answer.

        explanation:
        In “aba”, count of vowel=2, count of consonants=1,answer=0;
        for iteration i=0, we found ‘a’, which is a vowel so we need consonant to make substring.
        Here there is only one consonant so we will add 1 to the answer and decrease the count of vowel by 1 as it is used.
        count of vowel=1,count of consonants=1, answer=1;

        for iteration i=1, we found ‘b’, which is consonant so add count of vowel to the answer,
        and decrease the count of consonants by 1;
        count of vowel=1, count of consonants=0,answer=2;

        for the last iteration, we will again get vowel but the answer remains the same as the count of consonants is 0,
        so final answer is 2;
     */
    public static int solve(String A) {
        long count = 0;
        int n = A.length();

        if (n == 1 || n == 0) {
            return 0;
        }

        long vowels = 0;
        long consonants = 0;

        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            vowels += isVowel(c);
        }

        consonants = n - vowels;

        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (isVowel(c) == 1) {
                vowels--;
                count += consonants;
            } else {
                consonants--;
                count += vowels;
            }
        }

        return (int) (count % 1000000007);
    }

    public static int isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1;
        }
        return 0;
    }
}
