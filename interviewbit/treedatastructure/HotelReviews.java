package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Given a set of reviews provided by the customers for different hotels and a string containing
Good Words, you need to sort the reviews in descending order according to their
Goodness Value (Higher goodness value first). We define the Goodness Value of a
string as the number of Good Words in that string.

NOTE: Sorting should be stable. If review i and review j have the same Goodness Value
then their original order would be preserved.

You are expected to use Trie in an Interview for such problems

Problem Constraints
1 <= No.of reviews <= 200
1 <= No. of words in a review <= 1000
1 <= Length of an individual review <= 10,000
1 <= Number of Good Words <= 10,000
1 <= Length of an individual Good Word <= 4
All the alphabets are lower case (a - z)

Input Format
First argument is a string A containing "Good Words" separated by "_" character
Second argument is a vector B of strings containing Hotel Reviews. Review strings are also separated by "_" character.

Output Format
Return a vector of integers which contain the original indexes of the reviews in the sorted order of reviews.

Example Input
Input 1:
 A = "cool_ice_wifi"
 B = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Example Output
Output 1:
 [2, 0, 1]

Example Explanation
Explanation 1:
 sorted reviews are ["coolwifispeed", "wateriscool", "coldicedrink"]
 */
public class HotelReviews {
    public static void main(String[] args) {
        System.out.println(new HotelReviews().solve("cool_ice_wifi", new ArrayList<>(
                List.of("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
        System.out.println(new HotelReviews().solve_1("cool_ice_wifi", new ArrayList<>(
                List.of("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
    }

    public ArrayList<Integer> solve_1(String s, ArrayList<String> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr.isEmpty()) {
            return ans;
        }

        String[] str = s.split("_");
        HashSet<String> set = new HashSet<>(Arrays.asList(str));
        int count = 0;
        ArrayList<Node> node = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            count = 0;
            String[] temp = arr.get(i).split("_");
            for (String s1 : temp) {
                count += set.contains(s1) ? 1 : 0;
            }
            node.add(new Node(count, i));
        }

        Collections.sort(node, new NodeComparator());

        for (Node n : node) {
            ans.add(n.index);
        }
        return ans;
    }

    class Node {
        int match;
        int index;

        public Node(int m1, int i1) {
            match = m1;
            index = i1;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            if (n1.match == n2.match) {
                return n1.index - n2.index;
            }
            return n2.match - n1.match;
        }
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        TrieNode head = new TrieNode();
        TrieNode t = new TrieNode();

        String[] input = A.split("_");

        for (String temp : input) {
            t.insert(head, temp);
        }

        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            int count = 0;
            input = B.get(i).split("_");

            for (String temp : input) {
                if (t.search(head, temp)) {
                    count++;
                }
            }

            if (!treeMap.containsKey(count)) {
                treeMap.put(count, new ArrayList<>());
            }
            treeMap.get(count).add(i);
        }

        for (int j = treeMap.lastKey(); j >= treeMap.firstKey(); j--) {
            if (treeMap.containsKey(j)) {
                result.addAll(treeMap.get(j));
            }
        }
        return result;
    }
}

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> map;

    public TrieNode() {
        map = new HashMap<>();
        isEnd = false;
    }

    public void insert(TrieNode head, String s) {
        TrieNode cur = head;
        for (int i = 0; i < s.length(); i++) {
            if (!cur.map.containsKey(s.charAt(i))) {
                cur.map.put(s.charAt(i), new TrieNode());
            }
            cur = cur.map.get(s.charAt(i));
        }
        cur.isEnd = true;
    }

    public boolean search(TrieNode head, String s) {
        if (head == null) {
            return false;
        }
        TrieNode cur = head;
        for (int i = 0; i < s.length(); i++) {
            if (!cur.map.containsKey(s.charAt(i))) {
                return false;
            }
            cur = cur.map.get(s.charAt(i));
        }

        return cur.isEnd;
    }
}


