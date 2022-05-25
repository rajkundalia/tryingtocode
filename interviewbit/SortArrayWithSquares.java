package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayWithSquares {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(-4, -1, 0, 3, 10));
        System.out.println(solve(a));
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Integer[] list = new Integer[A.size()];
        int left = 0;
        int right = A.size() - 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            if (Math.abs(A.get(left)) > Math.abs(A.get(right))) {
                list[i] = A.get(left) * A.get(left);
                left++;
            } else {
                list[i] = A.get(right) * A.get(right);
                right--;
            }
        }
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(list));
        return result;
    }
}
