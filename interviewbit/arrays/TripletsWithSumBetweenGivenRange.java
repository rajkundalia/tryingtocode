package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripletsWithSumBetweenGivenRange {
    public static void main(String[] args) {
        System.out.println(solveTripletsWithSumBetweenGivenRange(new ArrayList<>(List.of("0.6", "0.7", "0.8", "1.2", "0.4"))));
    }

    //https://youtu.be/XoWPmK9B_hg

    /*
        we take 3 markers, start, middle and end, after sorting the given array.
        if element at start + middle + end > 2, then we know larger element has to be replaced, so we do end--;
        if element at start + middle + end < 1, then we know smaller element has to be replaced, so we do start++;
     */
    private static int solveTripletsWithSumBetweenGivenRange(ArrayList<String> list) {
        Collections.sort(list);
        int start = 0, end = list.size() - 1;
        while (end - start >= 2) {
            int mid = (start + end) / 2;
            double a = Double.parseDouble(list.get(start));
            double b = Double.parseDouble(list.get(mid));
            double c = Double.parseDouble(list.get(end));

            double comp = (a + b + c);

            if (comp < 1)
                start++;
            else if (comp > 2)
                end--;
            else return 1;
        }

        return 0;
    }
}
