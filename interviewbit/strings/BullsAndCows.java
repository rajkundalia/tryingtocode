package interviewbit.strings;

import java.util.HashMap;
import java.util.Map;

/*
You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is.
When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
Note that both secret and guess may contain duplicate digits.

Problem Constraints
1 <= secret.length, guess.length <= 100000
secret.length == guess.length
secret and guess consist of digits only.

Input Format
First argument is string denoting secret string
Second argument is string denoting guess string
Output Format
Return the hint for you friend's guess.

Example Input
Input 1:
secret = "1807", guess = "7810"
Input 2:
secret = "1123", guess = "0111"

Example Output
Ouput 1:
"1A3B"
Ouput 2:
"1A1B"

Example Explanation
Explanation 1:
Bulls are connected with a '|':
"1807"
  |
"7810"
Explanation 2:
Bulls are connected with a '|'
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since
the non-bull digits can only be rearranged to allow one 1 to be a bull.

 */
public class BullsAndCows {
    public static void main(String[] args) {
        System.out.println(solve("6020943525972", "7157627311068"));
    }

    /*
    So, condition for bulls counting is pretty clear and simple. More interesting part is related to solving cows counting part.
    So, my solution is to use arrays for both strings of size 10 for digits (0 - 9).

    That means when two letters on the same index are not equal, then I increase the cell which corresponds to that number in both arrays respectively. Let me give an example:
    Assume that char s equals to '2' and char g equals to '4'. Then I do the next in alphabetS array:

    alphabetS[s - '0']++;
    Here, s - '0' => '2' - '0' => 50 - 48 => 2. In ASCII '2' is equal to 50 and '0' equals to 48.
    Thus, I increment alphabetS[2].
    The same applied to alphabetG.

    Finally, I just find minimal number of times a digit appeared in both strings by finding

    Math.min(alphabetS[i], alphabetG[i])
     */
    public static String solve(String secret, String guess) {
        int[] alphabetS = new int[10];
        int[] alphabetG = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) {
                bulls++;
                continue;
            } else {
                alphabetS[s - '0']++;
                alphabetG[g - '0']++;
            }
        }
        for (int i = 0; i < alphabetS.length; i++) {
            cows += Math.min(alphabetS[i], alphabetG[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
