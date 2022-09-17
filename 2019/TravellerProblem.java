package check;

import java.util.ArrayList;
import java.util.List;

/**
 * A traveler visits multiple cities. He can work daily and make some money. He also spends some money on each day. An array is given depicting his daily savings (earnings – expenses) over the course of his journey. How much minimum money he should start with in order to have at least some saving ( > 0) at the end of each day.
 * Examples:-
 * Input : arr[] = { 10, -5, 7, -8, 5, -9 }
 * Let’s say he starts with x.
 * At the end of:-
 * Day 1, he has a saving of(x + 10)
 * Day 2, he has a saving of(x + 5)
 * Day 3, he has a saving of(x + 12)
 * Day 4, he has a saving of(x + 4)
 * Day 5, he has a saving of(x + 9)
 * Day 6, he has a saving of(x + 0)
 * So, the minimum value of x to satisfy the given condition is 1 (one).
 *
 *
 *
 */

public class TravellerProblem {
    public static void main(String[] args) {

        List<Integer> netSaving = new ArrayList<>();
        netSaving.add(4);
        netSaving.add(2);
        netSaving.add(-3);
        int result = requiredAmountAtStart(netSaving);

        System.out.println(result);
    }

    public static int requiredAmountAtStart(List<Integer> netSaving) {
//        int sum = netSaving.stream().mapToInt(Integer::intValue).sum();
//        if(sum >= 0){
//            return 0;
//        } else {
//            return 0 - sum;
//        }

        int initialMinAmount = 0;
        int currentAmount = 0;
        boolean flag = false;
        for (Integer netAmount : netSaving) {
            currentAmount += netAmount;

            if (currentAmount <= 0) {
                initialMinAmount += Math.abs(currentAmount) + 1;
                currentAmount = 1;
                flag = true;
            }
        }
        return (flag == false) ? 0 : initialMinAmount;
    }

}
