package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find the largest continuous sequence in a array which sums to zero.
Example:

Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}
NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class LargestContinuousSequenceZeroSum {
    public static void main(String[] args) {
        System.out.println(lszero(new ArrayList<>(List.of(1, 2, -2, 4, -4))));
    }

    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > maxLen) {
                    start = map.get(sum);
                    end = i;
                }
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start + 1; i <= end; i++) {
            result.add(A.get(i));
        }
        return result;
    }
}
