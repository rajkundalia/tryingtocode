package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are
all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation
of any permutation of words. Return the starting indices of all the concatenated substrings in s.
You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
The output order does not matter. Returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
We return an empty array.
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 */
//https://youtu.be/EVHQ48RM5tw
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman",
                new String[]{"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - (len * words.length); i++) {
            Map<String, Integer> copyMap = new HashMap<>(map);

            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * len, i + j * len + len);

                if (copyMap.containsKey(str)) {
                    int count = copyMap.get(str);
                    if (count == 1) {
                        copyMap.remove(str);
                    } else {
                        copyMap.put(str, count - 1);
                    }

                    if (copyMap.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
