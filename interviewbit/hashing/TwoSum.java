package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.

Put both these numbers in order in an array and return the array from your function
(Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum.

If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(List.of(2, 7, 11, 15), 9));
    }

    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i))) {
                list.add(map.get(B - A.get(i)));
                list.add(i + 1);
                break;
            } else {
                if (map.containsKey(A.get(i))) {
                    continue;
                } else {
                    map.put(A.get(i), i + 1);
                }
            }
        }
        return list;
    }
}
