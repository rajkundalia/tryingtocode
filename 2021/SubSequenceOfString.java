package RecursionPepCode;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfString {
    public static void main(String[] args) {
        List<String> list = listAllSubsequence("abc");
        System.out.println(list);
    }

    private static List<String> listAllSubsequence(String str) {
        if(str.length() == 0) {
            List<String> tempR = new ArrayList<>();
            tempR.add("");
            return tempR;
        }
        char fc = str.charAt(0);
        String subStr = str.substring(1);
        List<String> rr = listAllSubsequence(subStr);

        List<String> mr = new ArrayList<>();
        for(String s: rr) {
            mr.add("" + s);
        }
        for(String s: rr) {
            mr.add(fc + s);
        }
        return mr;
    }


}
