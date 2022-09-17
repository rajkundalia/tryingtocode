package interviewbit.strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255.
The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)

 */
public class ValidIPAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ipAddress = new ArrayList<>();
        int[] path = new int[4];
        snapShotIp(ipAddress, s, 0, path, 0);
        return ipAddress;
    }

    private static void snapShotIp(ArrayList<String> ipAddress, String s, int buildIndex, int[] path, int segment) {
        // Base case <-> Goal -> 1 catch answer 2 kill overshoots
        if (segment == 4 && buildIndex == s.length()) {
            ipAddress.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            return;
        } else if (segment == 4 || buildIndex == s.length()) {
            return;
        }
        //----
        for (int len = 1; len <= 3 && buildIndex + len <= s.length(); len++) {
            String snapshot = s.substring(buildIndex, buildIndex + len);
            int value = Integer.parseInt(snapshot);
            // constraints
            if (value > 255 || len >= 2 && s.charAt(buildIndex) == '0') {
                break;
            }
            // our choice: Choose, Explore, Un-choose
            path[segment] = value;
            snapShotIp(ipAddress, s, buildIndex + len, path, segment + 1);
            path[segment] = -1;
        }
    }

//    public static ArrayList<String> restoreIpAddresses(String s) {
//        ArrayList<String> ans = new ArrayList<>();
//        if (s.length() > 12) {
//            return ans;
//        }
//        helper(s, ans, 0, "", 0);
//        return ans;
//    }
//
//    public static void helper(String s, List<String> ans, int indx, String curr, int dots) {
//        if (dots == 4 && indx == s.length()) {
//            ans.add(curr.substring(0, curr.length() - 1));
//            return;
//        }
//        if (dots > 4 || (dots < 4 && indx == s.length())) {
//            return;
//        }
//        for (int i = indx; i < indx + 3 && i < s.length(); i++) {
//            if (Integer.parseInt(s.substring(indx, i + 1)) < 256 && (indx == i || s.charAt(indx) != '0')) {
//                helper(s, ans, i + 1, curr + s.substring(indx, i + 1) + ".", dots + 1);
//            }
//        }
//    }
}
