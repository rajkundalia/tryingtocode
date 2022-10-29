package interviewbit.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a string A representing an absolute path for a file (Unix-style).
Return the string A after simplifying the absolute path.

Note:

In Unix-style file system:

A period '.' refers to the current directory.
A double period '..' refers to the directory up a level.
Any multiple consecutive slashes '//' are treated as a single slash '/'.
In Simplified Absolute path:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path doesn't end with trailing slashes '/'.

The path only contains the directories on the path from the root directory to the target file or
directory (i.e., no period '.' or double period '..')

Path will not have whitespace characters.

Input Format
The only argument given is string A.
Output Format
Return a string denoting the simplified absolute path for a file (Unix-style).
For Example
Input 1:
    A = "/home/"
Output 1:
    "/home"
Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 */
public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../c/"));
    }

    public static String simplifyPath(String A) {
        List<String> list = new ArrayList<>();
        int n = A.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String dir = "";

            while (i < n && A.charAt(i) != '/') {
                dir += A.charAt(i);
                i++;
            }

            if (dir.equals("..")) {
                if (list.size() != 0) {
                    list.remove(list.size() - 1);
                }
            } else if (dir.equals(".") || dir.equals("")) {
            } else {
                list.add(dir);
            }
        }
        for (String i : list) {
            ans += "/" + i;
        }
        if (ans == "") {
            return "/";
        }
        return ans;
    }
}
