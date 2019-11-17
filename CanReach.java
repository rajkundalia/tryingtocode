import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
      https://massivealgorithms.blogspot.com/2019/03/leetcode-780-reaching-points.html
      
      Reaching points on leetcode
      operations allowed are x,x+y or x+y,y
    
     * Complete the 'canReach' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER y1
     *  3. INTEGER x2
     *  4. INTEGER y2
     */

    public static String canReach(int x1, int y1, int x2, int y2) {
    // Write your code here
        if(reachingPoints(x1, y1, x2, y2)){
            return "Yes";
        } else {
            return "No";
        }

    }

    public static boolean reachingPoints(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return false;
        if (x1 == x2 && (y2 - y1) % x1 == 0) return true;
        if (y1 == y2 && (x2 - x1) % y1 == 0) return true;
        return reachingPoints(x1, y1, x2 % y2, y2 % x2);
    }

}

public class Solution {
