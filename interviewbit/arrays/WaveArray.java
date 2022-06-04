package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers,  sort the array into a wave like array and return it,
 * <p>
 * In other words, arrange the elements into a sequence such that  a1 >= a2 <= a3 >= a4 <= a5.....
 * <p>
 * Example
 * <p>
 * Given [1, 2, 3, 4]
 * <p>
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 * <p>
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    public static void main(String[] args) {
        System.out.println(solveWaveArray(new ArrayList<>(List.of(1, 2, 3, 4))));
    }

    private static ArrayList<Integer> solveWaveArray(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size() - 1; i++) {
            int temp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1, temp);
            i++;
        }
        return A;
    }
}
