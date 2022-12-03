package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string, S, and a list of words, L, that are all the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L
exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].

(order does not matter).
 */
public class SubstringConcatenation {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", List.of("foo", "bar")));
        System.out.println(findSubstring_2("barfoothefoobarman", List.of("foo", "bar")));
    }

    /*
        The fact that all words are the same length makes it easy to iterate over a string.
        For each potential substring, we make a map of the words in it and compare it with the
        map of the words of the input set
        (with the condition of an early exit, if the word is not in the input set or is present fewer times)
     */
    public static ArrayList<Integer> findSubstring(String s, final List<String> words) {
        ArrayList<Integer> indices = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        words.forEach(word -> wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1));

        int wordLength = words.get(0).length();
        int count = words.size();
        for (int index = 0; index <= s.length() - wordLength * count; ++index) {
            if (isContainsAllWords(wordsMap, s.substring(index, index + wordLength * count), wordLength))
                indices.add(index);
        }

        return indices;
    }

    private static boolean isContainsAllWords(Map<String, Integer> wordsMap, String substring, int wordLength) {
        Map<String, Integer> substringWordsMap = new HashMap<>();
        for (int i = 0; i < substring.length(); i += wordLength) {
            String word = substring.substring(i, i + wordLength);
            substringWordsMap.put(word, substringWordsMap.getOrDefault(word, 0) + 1);

            if (substringWordsMap.get(word) > wordsMap.getOrDefault(word, 0))
                return false;
        }
        return substringWordsMap.equals(wordsMap);
    }

    public static ArrayList<Integer> findSubstring_2(String a, final List<String> b) {
        int len = b.get(0).length();
        int total_len = len * b.size();
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (String str : b)
            if (map.get(str) == null)
                map.put(str, 1);
            else
                map.put(str, map.get(str) + 1);
        int j = 0;
        for (int i = 0; i <= a.length() - total_len; i++) {
            Map<String, Integer> temp = new HashMap<>();
            for (j = i; j <= total_len + i - len; j += len) {
                String sub = a.substring(j, j + len);
                if (map.get(sub) == null)
                    break;
                else {
                    if (temp.get(sub) == null)
                        temp.put(sub, 1);
                    else {
                        if (temp.get(sub) < map.get(sub))
                            temp.put(sub, temp.get(sub) + 1);
                        else
                            break;
                    }
                }
            }
            if (j == i + total_len) {
                ans.add(i);
            }
        }
        return ans;
    }
}



