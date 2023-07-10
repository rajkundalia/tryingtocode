package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String s1 = strs[i];
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);
            String str = String.valueOf(arr);

            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s1);
        }

        return new ArrayList<>(map.values());
    }
}
