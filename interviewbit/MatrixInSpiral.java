package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class MatrixInSpiral {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();

        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        List<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(10);
        list3.add(11);
        list3.add(12);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(printSpiral(list));
    }
//https://youtu.be/siKFOI8PNKM - Print 2-D array in spiral order - mycodeschool
    public static List<Integer> printSpiral(List<List<Integer>> mat) {
        ArrayList<Integer> result = new ArrayList<>();
        int dir = 0;
        int m = mat.size() - 1;
        int n = mat.get(0).size() - 1;
        int r = 0;
        int c = 0;

        while(r <= m && c <= n) {
            if(dir == 0) {
                for (int i = c; i <= n; i++) {
                    result.add(mat.get(r).get(i));
                }
                r++;
            } else if(dir == 1) {
                for (int i = r; i <= m; i++) {
                    result.add(mat.get(i).get(n));
                }
                n--;
            } else if(dir == 2) {
                for (int i = n; i >= c; i--) {
                    result.add(mat.get(m).get(i));
                }
                m--;
            } else if(dir == 3) {
                for (int i = m; i >= r; i--) {
                    result.add(mat.get(i).get(c));
                }
                c++;
            }
            dir = (dir + 1)%4;
        }


        return result;
    }

    public static List<Integer> printInSpiral(List<List<Integer>> mat) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = mat.size();
        int k = 0;

        int n = mat.get(0).size();
        int l = 0;
        int i;

        while(k < m && l < n) {
            // print first row
            for(i = l; i < n; i++) {
                System.out.println("1st loop");
                System.out.println("i: " + i + " m: " + m + " k: " + k + " n: " + n + " l: " + l + " value: " + mat.get(k).get(i));
                result.add(mat.get(k).get(i));
            }
            k++;

            // print last column
            for(i = k; i < m; i++) {
                System.out.println("2nd loop");
                System.out.println("i: " + i + " m: " + m + " k: " + k + " n: " + n + " l: " + l + " value: " + mat.get(i).get(n - 1));
                result.add(mat.get(i).get(n - 1));
            }
            n--;

            // print last row
            if(k < m) {
                for(i = n - 1; i >= l; i--) {
                    System.out.println("3rd loop");
                    System.out.println("i: " + i + " m: " + m + " k: " + k + " n: " + n + " l: " + l + " value: " + mat.get(m - 1).get(i));
                    result.add(mat.get(m - 1).get(i));
                }
                m--;
            }

            // print first column
            if(l < n) {
                for(i = m - 1; i >= k; i--) {
                    System.out.println("4th loop");
                    System.out.println("i: " + i + " m: " + m + " k: " + k + " n: " + n + " l: " + l + " value: " + mat.get(i).get(l));
                    result.add(mat.get(i).get(l));
                }
                l++;
            }


        }
        return result;
    }
}
