package interviewbit.math;

import java.util.Arrays;

/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.
Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {
    public static void main(String[] args) {
        System.out.println(findSortedPermutationRank("cba"));
    }

    /*
        Explanation:
        cba
        lexicographically sorting it: abc
        Permutations of 3 letters:
        abc
        acb
        bac
        bca
        cab
        cba
        output would be 6 here.

        If we start from 'a' as the first letter then:
        a__ i.e. 2! possibilities
        b__ i.e. 2! possibilities
        ca_ i.e. 1! possibilities
        cb_ i.e. 1! possibilities
        So 2! + 2! + 1! + 1! = 6.

        We sort the string lexicographically - 's'
        We are making an array which stores all factorials from 1 to n, where n can be a maximum of 26 because no
        repetition of characters.
        We take an index for str string here i.e. cba to compare with sorted 's'
        Compare letter and add permutation numbers to a variable
        Also taking an array to maintain which character from str is already covered at its location
        For e.g.
        cab
        Let's say c and a are covered here, so if we reach b now in cab, it will compare with 'a' in 'abc' and the
        cycle will start again. So we mark the already covered items in 's'
        Because 'b' will really be the last character in cba and we don't need to start cycle again.
        https://youtu.be/gqlSxpOegoY bhaicodekaro helped me in this
     */
    public static int findSortedPermutationRank(String str) {
        String[] strArray = str.split("");
        Arrays.sort(strArray);
        String s = String.join("", strArray);
        int n = str.length();
        int[] fact = new int[n];
        factorial(fact, n);
        int index = 0;
        int[] check = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (check[i] == -1) {
                continue;
            } else if (str.charAt(index) != s.charAt(i)) {
                ans += fact[n - index - 1];
            } else {
                check[i] = -1;
                index++;
                i = -1; // so that loop starts from 0 again
            }
        }
        return ans + 1;
    }

    private static void factorial(int[] fact, int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < n; i++) {
            fact[i] = i * fact[i - 1] % 1000003;
        }
    }
}
