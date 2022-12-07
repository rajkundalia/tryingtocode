package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings, return all groups of strings that are anagrams.
Represent a group by a list of integers representing the index in the original list.
Look at the sample case for clarification.

Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
Note:  All inputs will be in lower-case.
Example :
Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4.
dog and god are another set of anagrams which correspond to index 2 and 3.

The indices are 1 based ( the first element has index 1 instead of index 0).
Ordering of the result : You should not change the relative ordering of the words / phrases within the group.
Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 */
public class Anagrams {
    public static void main(String[] args) {
        System.out.println(anagrams(List.of("cat", "dog", "god", "tca")));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            String str = sortIt(A.get(i));
            if (map.get(str) != null) {
                map.get(str).add(i + 1);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                map.put(str, temp);
            }
        }
        for (ArrayList<Integer> e : map.values()) {
            ans.add(e);
        }
        return ans;
    }

    private static String sortIt(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
