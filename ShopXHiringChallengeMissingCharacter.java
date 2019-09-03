/* Base 64 table is given
* Every alternate character is multiplied by 2, if it forms a 2 character string, add both of them and a final string is created
*
* 
* st = {String[13]@821} 
 0 = "Q"
 1 = "n"
 2 = "b"
 3 = "e"
 4 = "X"
 5 = "p"
 6 = "L"
 7 = "a"
 8 = "P"
 9 = "e"
 10 = "b"
 11 = "a"
 12 = "X"


Q
n
b
e
X
p
L
a
P
e
b
a
X

QnBaeBWpBKaBOBaaBW
QnbeXpLaPebaX

FO + phi 
phi = y

I could not complete the question but could reach upto finding FO.
* 
*
*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {

    final static String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            System.out.println(solve(Integer.valueOf(br.readLine()), br.readLine()));
        }
        //System.out.println(toCustomBase(90));
    }

    public static String solve(Integer len, String str) {
        String[] st = str.split("");
        for (int i = 0; i < st.length; i = i + 2) {
            st[i] = toCustomBase(base.indexOf(st[i]) * 2);
            if (st[i].length() > 1) {
                int a = 0;
                String[] s = st[i].split("");
                for (int j = 0; j < st[i].length(); j++) {
                    a += base.indexOf(s[j]);
                }
                st[i] = toCustomBase(a);
            }
        }
        int res = 0;
        for (String a : st) {
            res += base.indexOf(a);
        }
//        String[] c = toCustomBase(res).split("");
//        if (c.length > 1) {
//            int w = 0;
//            for (int j = 0; j < c.length; j++) {
//                w += base.indexOf(c[j]);
//            }
//            return toCustomBase(w);
//        } else {
//            return toCustomBase(res);
//        }
        return toCustomBase(-res);
    }

    public static String toCustomBase(final int num) {
        final int baseSize = base.length();
        if (num < baseSize) {
            return String.valueOf(base.charAt(num));
        } else {
            return toCustomBase(num / baseSize) + base.charAt(num % baseSize);
        }
    }
}
