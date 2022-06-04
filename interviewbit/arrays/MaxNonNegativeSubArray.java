package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        System.out.println(maxSet(List.of(1, 4, -3, 9, 5, -6)));

    }


    private static ArrayList<Integer> maxSet(List<Integer> integers) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = integers.size();
        int max_so_far = 0, max_here = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < n; i++) {
            if(integers.get(i) < 0) {
                s = i + 1;
                max_here = 0;
            } else {
                max_here += integers.get(i);
            }

            if(max_here > max_so_far) {
                max_so_far = max_here;
                start = s;
                end = i;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(integers.get(i));
        }
        return result;
    }
//    private static ArrayList<Integer> maxSet(List<Integer> integers) {
//        ArrayList<Integer> result = new ArrayList<>();
//        ArrayList<Integer> copy = new ArrayList<>();
//        int temp = 0;
//        int sum = 0;
//
//        for (int a: integers) {
//            if(a >= 0) {
//                temp += a;
//                copy.add(a);
//            } else {
//                temp = 0;
//                copy.clear();
//            }
//
//            if(temp > sum || (temp == sum && result.size() < copy.size())) {
//                sum = temp;
//                result.clear();
//                result.addAll(copy);
//            }
//        }
//        return result;
//    }


}
