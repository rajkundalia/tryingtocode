package interviewbit.math;

import java.math.BigInteger;
import java.util.Arrays;

/*
// No understanding
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
Look at the example for more details.
Example :
Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' :
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003
NOTE: 1000003 is a prime number
NOTE: Assume the number of characters in string < 1000003
 */
public class SortedPermutationRankWithRepeats {
    public static void main(String[] args) {
        System.out.println(findSortedPermutationRankWithRepeats("google"));
    }

    /*
        Note: I could not sole the code and understood it from different sources
        
        Idea of Logic: https://youtu.be/kuW9BnT0e28
        google
        sorted: eggloo

        e(ggloo) -> 5!/2!*2! = 30
        ge(gloo) -> 4!/2! = 12
        gg(eloo) -> 4!/2! = 12
        gl(egoo) -> 4!/2! = 12
        goe(glo) -> 3! = 6
        gog(elo) -> 3! = 6
        gol(ego) -> 3! = 6
        gooe(gl) -> 2! = 2
        googe(l) -> 1
        google -> 1
        total = 88

        The below code works like this:

        5!/2!*2! + 3*(4!/2!) + 3*3! + 2! + 1 + 1= 88
        3 - count of 4!/2!
        3 - count of 3!

        Here e is smaller than g and there are repetition of characters, so 5!/2!*2!
        You can refer SortedPermutationRank.java for some more understanding of this; the new thing is repetition
        which has to be divided based on number of characters
     */
    public static int findSortedPermutationRankWithRepeats(String A) {
        int n = A.length();
        char[] chars = A.toCharArray();
        byte[] ascii = new byte[256];

        BigInteger[] factors = new BigInteger[n + 1];
        factors[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factors[i] = factors[i - 1].multiply(new BigInteger(String.valueOf(i)));
        }
        factors[0] = BigInteger.ZERO;

        BigInteger rank = BigInteger.ONE;
        BigInteger denominator, numerator;
        BigInteger MOD = new BigInteger(String.valueOf(1000003));
        for (int i = 0; i < n; i++) {
            long count = 0;
            Arrays.fill(ascii, (byte) 0); // clear
            ascii[chars[i]]++;
            for (int j = i + 1; j < n; j++) {
                if (chars[j] < chars[i]) {
                    count++;
                }
                ascii[chars[j]]++;
            }
            numerator = factors[n - i - 1].multiply(new BigInteger(String.valueOf(count)));

            denominator = BigInteger.ONE;
            for (int j = 0; j < 256; j++) {
                if (ascii[j] > 0) {
                    denominator = denominator.multiply(factors[ascii[j]]);
                }
            }

            rank = rank.add(numerator.divide(denominator));
            rank = rank.mod(MOD);
        }
        return Integer.parseInt(rank.toString());
    }
}
/*
    // extended gcd returns the gcd of a and b using equation ax+by = gcd(a,b)
// it also returns the value of x and y which we can put in above equation to
// get gcd of a and b
    int extended_gcd(int a,int b,int &x,int &y)
    {
        if(a==0)
        {
            x = 0;
            y = 1;
            return b;
        }
        int x1,y1;

        int gcd = extended_gcd(b%a,a,x1,y1);

        x = y1 - (b/a)*x1;
        y = x1;

        return gcd;
    }
// simple factorial function
// which returns the factorial modulo given number 1000003;

long long int factorial(long long int n)
        {
        long long int ans = 1;
        while(n>=2)
        {
        ans = (ans%1000003)*(n%1000003);
        n--;
        }
        return ans%1000003;
        }

        int Solution::findRank(string A) {
        // map to not the frequency of each character , because later on we need to divide
        // by count of characters which are repeating

        unordered_map<char,int> map;

        int n = A.size();

        if(n==1) return 1;

        for(int i=0;i<n;i++)
        map[A[i]]++;

        long long int count = 0;

        // recusrive solution's small calculation
        // doing self for first character

        // for first character count the total number of characters which are
        // smaller than the first character
        // because all of their permutations will come before the first character

        for(int i=1;i<n;i++)
        if(A[i]<A[0]) count++;

        long long int ans = 0;
        if(count>0)
        {   // for each character smaller than the first character of string
        // we multiply by (n-1)! because these are the count of total permutation
        // each smaller character can make!
        ans = factorial(n-1)%1000003;
        // count of permutation for all characters
        ans = (ans*count)%1000003;

        // this is the key part!!!
        // where we have to divide by factorials of repeating characters

        // suppose we want to do (ans/2!)%1000003
        // this is equal to (ans%1000003 * inverseMod(2!)%1000003)%1000003;

        // inverseMod() can be calculated with the help of extended euclidean gcd algorithm

        for(auto i:map)
        {
        if(i.second>1)
        {
        int temp = (factorial(i.second));
        if(ans%temp==0) ans = (ans/temp)%1000003;
        else
        {   int x,y;
        int g = extended_gcd(temp,1000003,x,y);
        int res = (x%1000003 + 1000003)%1000003;
        ans = (ans%1000003*res%1000003)%1000003;
        }
        }
        }
        }
        // recursive call for rest of string
        return (ans + findRank(A.substr(1)))%1000003;
        }
*/