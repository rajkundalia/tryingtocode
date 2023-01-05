package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 */
public class ShortestUniquePrefix {

    //ArrayList<String> result;

    public static void main(String[] args) {
        System.out.println(new ShortestUniquePrefix().prefix(new ArrayList<>(List.of("zebra", "dog", "duck", "dove"))));
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String s : A) {
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                countMap.merge(sub, 1, Integer::sum);
                /*
                    merge function does the below thing

                    if(countMap.get(sub)==null){
                        countMap.put(sub,1);
                    }
                    else{
                        countMap.put(sub,countMap.get(sub)+1);
                    }
                 */
            }
        }
        ArrayList<String> ans = new ArrayList<>();

        for (String s : A) {
            for (int j = 1; j <= s.length(); ++j) {
                String sub = s.substring(0, j);
                if (countMap.get(sub) == 1) {
                    ans.add(sub);
                    break;
                }
            }
        }
        return ans;
    }

}

//    public ArrayList<String> prefix(ArrayList<String> A) {
//        TrieNodeSUP root = new TrieNodeSUP();
//        for (String s : A) {
//            insert(root, s);
//        }
//        getShortestPrefix(root, "");
//        return result;
//    }
//
//    public ShortestUniquePrefix() {
//        result = new ArrayList<>();
//    }
//
//    public void insert(TrieNodeSUP root, String word) {
//        TrieNodeSUP current = root;
//        for (char c : word.toCharArray()) {
//            current.child.putIfAbsent(c, new TrieNodeSUP());
//            current.child.get(c).frequency++;
//            current = current.child.get(c);
//        }
//    }
//
//    public void getShortestPrefix(TrieNodeSUP root, String wordSoFar) {
//        if (root == null) {
//            return;
//        }
//        if (root.frequency == 1) {
//            result.add(wordSoFar);
//            return;
//        }
//        for (Map.Entry<Character, TrieNodeSUP> child : root.child.entrySet()) {
//            getShortestPrefix(child.getValue(), wordSoFar + child.getKey());
//        }
//    }
//}
//
//class TrieNodeSUP {
//    Map<Character, TrieNodeSUP> child = new HashMap<>();
//    int frequency = 0;
//}
