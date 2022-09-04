package interviewbit.strings;

/*
Given a sentence as a string A.
Return the number of palindromic words in the sentence.

Problem Constraints
1 <= A <= 105
Ai = {Lowercase English letters and whitespaces}

Input Format
The first and only argument is a string A.
Output Format
Return an integer.

Example Input
Input 1:
A = "the fastest racecar"
Input 2:
A = "wow mom"

Example Output
Output 1:
1
Output 2:
2

Example Explanation
Explanation 1:
The words are "hello" and "world".
12 + 34 = 46
Explanation 2:

The words are "how", "are" and "you".
 */
public class PalindromicWords {
    public static void main(String[] args) {
        System.out.println(solve("the fastest racecar"));
    }

    public static int solve(String A) {
        int count = 0;
        String[] words = A.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/*
bool ispalidrome(string A){

    int i=0,j=A.length()-1;

    while(i<j){
        if(A[i]!=A[j]) return false;
        i++;
        j--;
    }
    return true;
}

int Solution::solve(string A) {

    int c=0;
    for(int i=0;i<A.length();i++){
        string f="";
         while(A[i]!=' ' && i<A.length()){
             f+=A[i];
             i++;
         }
         if(ispalidrome(f)==true) c++;
    }
    return c;

}
 */