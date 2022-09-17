/*
Square Matrix (100 Marks)
Given is a square matrix of alphabets which contains English letters in an arbitrary manner. While searching a word in it, you can go left to right horizontally, vertically downwards or diagonally towards left (both upwards and downwards).
You have to find the number of matches of a given word in the matrix.

For example, In the given square matrix {A#A#K,A#S#K,A#K#K},

The word "ASK" is matched four times in the input matrix. So the output will be 4.


Input Format
First line contains N, size of array of string.
Next N line contains strings containing N uppercase alphabets separated by #
Second line contains String (Word to be searched)


Constraints
1 <= Size of string <= 10000

Output Format
Print number of occurrences of the word in the matrix {an integer}


Sample TestCase 1
Input
2
A#S
S#T
AS
Output
2
Explanation
The keyword AS is matched two times in the given matrix. The first row and first column makes the keyword AS.
*/

package code4metricstream;

import java.util.Scanner;

public class CandidateCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        String[] matrix = new String[N];
        int j = 0;
        for (int i = 0; i < N && j < N; i++) {
            matrix[i] = sc.nextLine();
        }
        String word = sc.nextLine();
        System.out.print(wordOccurenceCount(N, matrix, word));
    }


    static int wordOccurenceCount(int size, String[] matrix, String word) {
        int count = 0;
        StringBuilder diagonal1 = new StringBuilder("");
        StringBuilder diagonal2 = new StringBuilder("");
        StringBuilder[] input = new StringBuilder[matrix.length];
        StringBuilder[] column = new StringBuilder[matrix.length];


        for (int i = 0; i < matrix.length; i++) {
            input[i] = new StringBuilder();
            matrix[i] = matrix[i].replace("#", "");
            input[i].append(matrix[i]);

            count += getOccurenceCount(matrix[i], word);

            count += getOccurenceCount(input[i].reverse().toString(), word);

            diagonal1.append(matrix[i].charAt(i));
            diagonal2.append(matrix[i].charAt(size - i - 1));

            for (int j = 0; j < size; j++) {
                if (column[j] == null) {
                    column[j] = new StringBuilder();
                }
                column[j].append(matrix[i].charAt(j));
            }
        }

        count += getOccurenceCount(diagonal1.toString(), word);
        count += getOccurenceCount(diagonal1.reverse().toString(), word);
        count += getOccurenceCount(diagonal2.toString(), word);
        count += getOccurenceCount(diagonal2.reverse().toString(), word);

        for (int i = 0; i < size; i++) {

            count += getOccurenceCount(column[i].toString(), word);
            count += getOccurenceCount(column[i].reverse().toString(), word);

        }
        return count;
    }

    private static int getOccurenceCount(String string, String word) {
        return (string.length() - string.replace(word, "").length()) / word.length();
    }
}
