package interviewbit.greedyalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of size N, find the majority element. The majority element is the element that appears
more than floor(N/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 109

Input Format
The first argument is an integer array A.

Output Format
Return the majority element.

Example Input
A = [2, 1, 2]

Example Output
2

Example Explanation
2 occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new ArrayList<>(List.of(2, 1, 2))));
    }

    public int majorityElement(final List<Integer> A) {
        int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        for (int k : map.keySet()) {
            if (map.get(k) > (A.size() / 2)) {
                ans = k;
            }
        }
        return ans;
    }

    public int majorityElementAlternate(final List<Integer> A) {
        int count = 0;
        int num = -1;
        for (Integer i : A) {
            if (count == 0) {
                num = i;
            }
            if (num == i) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
