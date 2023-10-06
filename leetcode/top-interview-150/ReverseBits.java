package leetcode.topinterview150;

/*
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type.
In this case, both input and output will be given as a signed integer type.
They should not affect your implementation, as the integer's internal binary representation is the same,
whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents
the signed integer -1073741825.


Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents
the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned
integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 */

/*
e.g.

32 bit of 11 0000...1011
reverse of it only relevant digits: 00000...1101 which is 13
 */
// https://youtu.be/ZW7st_pN05w?si=Ul3bDa8PkvV8hbyN&t=180
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }

    // 1 << 2 gives 4, multiplication in shot
    /*
        n >> 1 ; //will shift right one bit
        res= ( res << 1 ) | ( n & 1 );
        res << 1 //will shift left resolution one bit
        n&1 //will get latest bit
        '|' //will add this bit to the res
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1);
            res |= (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
