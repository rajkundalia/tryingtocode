package RecursionPepCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://youtu.be/hMJAlbJIS7E
public class GetStairsPathRecursion {
    public static void main(String[] args) {
        List<String> result = getStairsPath(4);
        System.out.println(result);
    }

    /*
        Three types of jump, 1, 2 & 3.
     */
    private static List<String> getStairsPath(int n) {
        if(n == 0) {
            List<String> pathZero = new ArrayList<>();
            pathZero.add("");
            return pathZero;
        } else if(n < 1) {
            List<String> pathLTZero = new ArrayList<>();
            return pathLTZero;
        }
        List<String> path1 = getStairsPath(n - 1);
        List<String> path2 = getStairsPath(n - 2);
        List<String> path3 = getStairsPath(n - 3);
        List<String> path = new ArrayList<>();

        for(String p: path1) {
            path.add(1 + p);
        }
        for(String p: path2) {
            path.add(2 + p);
        }
        for(String p: path3) {
            path.add(3 + p);
        }
        return path;
    }
}
