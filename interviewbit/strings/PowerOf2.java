package interviewbit.strings;

/*
Find if Given number is power of 2 or not.
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:
number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:
return 1 if the number is a power of 2 else return 0

Example:
Input : 128
Output : 1
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(power1("128"));
    }

    public static int power(String s) {

        if (s.equals("2")) return 1;
        String[] dividend = s.split("");
        if (Integer.parseInt(dividend[dividend.length - 1]) % 2 != 0) return 0;

        String quotient = "";
        String remainder = "";

        // think of this as the division that you'd do on pen and paper.
        for (String a : dividend) {
            int x = Integer.parseInt(a);
            if (quotient.length() == 0) {
                if (x % 2 != 0) {
                    remainder += x % 2;
                }
                quotient += x / 2;
            } else if (remainder.length() != 0) {
                remainder += x;
                int r = Integer.parseInt(remainder);
                quotient += r / 2;
                if (r % 2 == 0) {
                    remainder = "";
                } else {
                    remainder = String.valueOf(r % 2);
                }
            } else if (quotient.length() != 0 && remainder.length() == 0) {
                quotient += x / 2;
                if (x % 2 != 0) {
                    remainder = String.valueOf(x % 2);
                }
            }
        }
        if (quotient.charAt(0) == '0') {
            quotient = quotient.substring(1);
        }
        return power(quotient);
    }

    public static int power1(String A) {
        if (A.equals("1") || A.equals("0")) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < A.length(); i++) {
            n = n * 10 + A.charAt(i) - '0';
        }
        //The powers of 2 have only one set bit in their Binary representation
        //If we subtract 1 from a power of 2 what we get is 1s till the last unset bit and if we
        // apply Bitwise AND operator we should get only zeros
        if ((n & (n - 1)) == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    if(A.equals("1") || A.equals("0"))
        return 0;
        int n=0;
        for(int i=0;i<A.length();i++)
        n=n*10+A.charAt(i)-'0';
        if((n&(n-1))==0)
        return 1;
        else
        return 0;
     */
}
