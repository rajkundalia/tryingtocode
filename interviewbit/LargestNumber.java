package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of non-negative integers, arrange them such that they form the largest number.
 * <p>
 * For example:
 * <p>
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(solveLargestNumber(new ArrayList<>(List.of(3, 30, 34, 5, 9))));

    }

    private static String solveLargestNumber(ArrayList<Integer> A) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (Integer i : A) {
            list.add(String.valueOf(i));
        }

        Collections.sort(list, (X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });

        for (String s : list) {
            sb.append(s);
        }

        if (sb.charAt(0) == '0') {
            return String.valueOf(0);
        }

        return sb.toString();
    }
}
