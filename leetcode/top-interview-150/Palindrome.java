package leetcode.topinterview150;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        int originalNumber = x;
        int reverseNumber = 0;

        while(x > 0) {
            reverseNumber = (reverseNumber * 10) + (x % 10);
            x = x / 10;
        }

        return originalNumber == reverseNumber;
    }
}
