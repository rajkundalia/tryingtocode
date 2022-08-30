package interviewbit.strings;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is
fully (left and right) justified. You should pack your words in a greedy approach; that is, pack as many words as
you can in each line.

Pad extra spaces ' ' when necessary so that each line has exactly L characters. Extra spaces between words
should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words,
the empty slots on the left will be assigned more spaces than the slots on the right. For the last line of text,
it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Note: Each word is guaranteed not to exceed L in length.
 */
public class JustifiedText {
    public static void main(String[] args) {
        System.out.println(fullJustify(new ArrayList<>(List.of("This", "is", "an", "example", "of", "text", "justification.")),
                16));
    }

    public static ArrayList<String> fullJustify(ArrayList<String> words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0, n = words.size();
        while (i < n) {
            int j = i + 1; // pointer j will always be in front of i
            int lineLength = words.get(i).length(); // always starts at word length of wherever pointer i is at.

            // move j pointer forward until the point that number of characters we have is greater than max width
            // j - i - 1 is the number of sections that we are going to apply space to
            while (j < n && (lineLength + words.get(j).length() + (j - i - 1) < maxWidth)) {
                lineLength += words.get(j).length();
                j++;
            }
            // diff is the amount of spaces that we are actually going to apply to the line
            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;

            // decision on the type of justification
            // j >= n means if the j pointer is at the last word
            if (numberOfWords == 1 || j >= n) {
                result.add(leftJustify(words, diff, i, j));
            } else {
                result.add(middleJustify(words, diff, i, j));
            }
            i = j;
        }
        return result;
    }

    public static String leftJustify(ArrayList<String> words, int diff, int i, int j) {
        int spacesOnRight = diff - (j - i - 1);
        StringBuilder result = new StringBuilder(words.get(i));
        for (int k = i + 1; k < j; k++) {
            result.append(" ").append(words.get(k));
        }
        while (spacesOnRight > 0) {
            result.append(" ");
            spacesOnRight--;
        }
//        result.append(" ".repeat(spacesOnRight));
        return result.toString();
    }

    public static String middleJustify(ArrayList<String> words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1; // grouping of spaces
        int spaces = diff / spacesNeeded; // This tells the minimum spaces between the words
        int extraSpaces = diff % spacesNeeded;
        StringBuilder result = new StringBuilder(words.get(i));

        for (int k = i + 1; k < j; k++) {
            // we need to apply extra spaces from left to right
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            // Allows us to make sure that if there are extra spaces not evenly distributed, then left most words
            // will get more spaces in between them
            while (spacesToApply > 0) {
                result.append(" ");
                spacesToApply--;
            }
            result.append(words.get(k));
        }

        return result.toString();
    }
}
