package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
You are given an array of variable pairs equations and an array of real numbers values,
where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find
the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by
zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be
determined for them.

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],
["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

Constraints:
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));
        equations.add(List.of("bc", "cd"));

        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("c", "b"));
        queries.add(List.of("bc", "cd"));
        queries.add(List.of("cd", "bc"));
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, new double[]{1.5, 2.5, 5.0}, queries)));
    }
    //     //    //https://youtu.be/oJsBJf8KzKE?si=YyVRoFnetvoDfBvm
    //https://www.youtube.com/watch?v=oJsBJf8KzKE&ab_channel=TheAnalyticGuy

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> varToDestToQuotient = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String varA = equations.get(i).get(0);
            String varB = equations.get(i).get(1);
            double quotient = values[i];

            varToDestToQuotient.putIfAbsent(varA, new HashMap<>());
            varToDestToQuotient.putIfAbsent(varB, new HashMap<>());
            varToDestToQuotient.get(varA).put(varB, quotient);
            varToDestToQuotient.get(varB).put(varA, 1 / quotient);
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String queryVarA = queries.get(i).get(0);
            String queryVarB = queries.get(i).get(1);

            answer[i] = compute(queryVarA, queryVarB, varToDestToQuotient, new HashSet<>(), 1);
        }
        return answer;
    }

    private double compute(String queryVarA, String queryVarB, Map<String, Map<String, Double>> varToDestToQuotient,
                           HashSet<Object> seen, double productSoFar) {
        if (!varToDestToQuotient.containsKey(queryVarA)) {
            return -1;
        }
        if (queryVarA.equals(queryVarB)) {
            return productSoFar;
        }

        seen.add(queryVarA);
        for (Map.Entry<String, Double> entry : varToDestToQuotient.get(queryVarA).entrySet()) {
            if (seen.contains(entry.getKey())) {
                continue;
            }
            double compute = compute(entry.getKey(), queryVarB, varToDestToQuotient, seen,
                    productSoFar * entry.getValue());
            if (compute != -1) {
                return compute;
            }
        }
        return -1;
    }
}
