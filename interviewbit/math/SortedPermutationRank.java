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

Approach 2 seems better.
 */
public class SortedPermutationRank {
    public static void main(String[] args) {
        System.out.println(findSortedPermutationRank("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv"));
        System.out.println(findSortedPermutationRankApproach2("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv"));
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
        if (n == 1) {
            return 1;
        }
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
        return (ans + 1) % 1000003;
    }

    private static void factorial(int[] fact, int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < n; i++) {
            fact[i] = i * fact[i - 1] % 1000003;
        }
    }

    /*
        Explanation:
            ibytes -> 6! = 720 possibilities
            sorted order = beisty
            b_____ 5!
            e_____ 5!

            ibe___ 3!
            ibs___ 3!
            ibt___ 3!

            ibye__ 2!
            ibys__ 2!

            then comes ibytes position

            approach in code:
            We take an array of size 256 i.e. it should be in range of ascii values of characters
            We are making an array which stores all factorials from 1 to n, where n can be a maximum of 26 because no
            repetition of characters.
            We fill the array with size 256 based on ascii values of characters as the index.
            Now b and e are smaller than i, so 2*5! and then in array of size 256, arr['i'] = 0;
            We move on to the letter b. It is the smallest.
            Now we move on to the letter y. e,s,t are smaller, so 3*3! is added.
            We move on to letter t, e and s are smaller so 2*2!.
            We move on to letter e, is smaller now.
            We move on to letter s, smallest among remaining.
            o/p:263

            Debug the code, you'd understand the logic
            https://youtu.be/uUN8fVPrJn0
     */
    public static int findSortedPermutationRankApproach2(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[256];
        int[] fact = new int[n];
        factorial(fact, n);
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)]++;
        }
        int numberOfLetterSmaller;
        int output = 0;
        for (int i = 0; i < n; i++) {
            numberOfLetterSmaller = 0;
            for (int j = 0; j < 256; j++) {
                if (j == s.charAt(i)) {
                    break;
                }
                if (arr[j] == 1) {
                    numberOfLetterSmaller++;
                }
            }
            arr[s.charAt(i)] = 0;
            output += numberOfLetterSmaller * fact[n - i - 1] % 1000003;
        }
        return (output + 1) % 1000003;
    }
}
