package interviewbit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a 2D string array A of dimensions N x 2,
where each row consists of two strings: first is the name of the student, second is their marks.
You have to find the maximum average mark. If it is a floating point,
round it down to the nearest integer less than or equal to the number.

Problem Constraints
1 <= N <= 105

Input Format
The first argument is a 2D string array A.
Output Format
Return a single integer which is the highest average mark.

Example Input
Input 1:
A = [["Bob", "80"], ["Bob", "90"], ["Alice", "90"]]
Input 2:
A = [["Bob", "80"], ["Bob", "90"], ["Alice", "90"], ["Alice", "10"]]

Example Output
Output 1:
90
Output 2:
85

Example Explanation
Explanation 1:
Alice has the highest average with 90 marks.
Explanation 2:
Bob has the highest average with 85 marks.

Question 1:
Given a 2-D String array of student-marks find the student with the highest average and output his average score.
If the average is in decimals, floor it down to the nearest integer.

Example 1:

Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
Output: 99
Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
 */
public class HighestScore {

    public static void main(String[] args) {
        String[][] arr = {{"Bob", "80"}, {"Bob", "90"}, {"Alice", "90"}};
        System.out.println(solveHighestScore(arr));
    }

    public static int solveHighestScore(String[][] scores) {
        if (scores == null || scores.length == 0) {
            return -1;
        }
        int highestAve = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            List<Integer> scoreList = map.get(scores[i][0]);
            if (scoreList == null) {
                List<Integer> currentScore = new ArrayList<>();
                currentScore.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], currentScore);
            } else {
                scoreList.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], scoreList);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int currentAverageScore = calculateAverage(entry.getValue());
            highestAve = Math.max(highestAve, currentAverageScore);
        }
        return highestAve;
    }

    private static int calculateAverage(List<Integer> value) {
        int n = value.size();
        int sum = 0;
        for (int score : value) {
            sum += score;
        }
        float average = sum / n;
        return (int) average;
    }
}
