package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly
maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a
line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */

//https://youtu.be/GqXlEbFVTXY
public class TextJustification {

    /*
        Break this problem into two parts.

        Separate the words for each line
        Format each line by applying text alignment (Either middle alignment or left alignment)
        Now Lets see how can we separate words from the input per line.
        Suppose our input looks like below
        Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        The output will be like below
        "This is an",
        "example of text",
        "justification. "

        So for each line we may have multiple words(String).
        So let's declare a List which items are also a list to store our word.
        Again the end result will be just a plain string list. Let's define also

        List<List<String>> lines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Now how we are going to pick word for a line? Suppose you have a word and a line.
        You can place this word in that line if after adding the word total size of this line (Total character)
        will not increase the maxWidth. So suppose you picked that word. Now for the next word you need to know
        how many remaining characters you have. So we need to track the remaining characters per line.
        Initially remaining characters will be maxWidth. So inside a map we the key will be line index and
        value will be the remaining characters.

        Lets declare the map as well as insert initial value for the lines and remaining characters for that line like below

        int currentLine = 0;
        lines.add(new ArrayList<String>());
        charMap.put(currentLine, maxWidth);
        Now we have the initial setup. In which line we are adding the next word will be
        determined by currentLine variable. Initially it is 0 as we are filling from the first line (index 0).

        Now we loop through all the words and try to put those words in the line.

        for (String word : words) {
             int remainingChar = charMap.get(currentLine);
             if (word.length() <= remainingChar) {
                 addWordToLine(currentLine, lines, charMap, word, maxWidth);
              } else {
                 currentLine++;
                 lines.add(new ArrayList<String>());
                 charMap.put(currentLine, maxWidth);
                 addWordToLine(currentLine, lines, charMap, word, maxWidth);
              }
        }
        Thats it. So what we did? Initially currentLine = 0 and at first we inserted maxWidth
        for the 0 in the charMap. So remainingChar is 16 here. Now we are checking if current word <= remainingChar .
        If it is we will add this word in the line by calling the function addWordToLine.

        If not that means we need a new line. Right? So we are incrementing the currentLine number adding a
        new ArrayList in the lines as well as remainingCharacter for that line. So we have a new line setup.
        Now we can call addWordToLine() function to add the word in the line.

        Now lets look what is happening inside addWordToLine function.

         public void addWordToLine(
                Integer currentLine,
                List<List<String>> lines,
                Map<Integer, Integer> charMap,
                String word,
                int maxWidth) {

                lines.get(currentLine).add(word);
                // Now change remaining and add space if required
                charMap.put(currentLine, charMap.get(currentLine) - word.length());

                // We have to add a space if at least one position left otherwise we
                // can not add a new word. So subtracting one from remaining character
                if (charMap.get(currentLine) != 0) {
                    charMap.put(currentLine, charMap.get(currentLine) - 1);
                }
            }
        As this function called, we know that we can add the word. So added the word in the first line.
        As we added the word we need to subtract the word length from the remainingChar. So we did that in the second line.

        Now we have a very crucial trick here. After adding a word it may cover the maxLength. Its ok.
        But if we have more space left then a new word can come in this line next.
        So between two words we must seprate them by a space. Right?
        So if for this line if we have space left we will consider a space.
        Hence, we subtracted 1 from the remainingChar.
        (This is important. If you find difficult read this paragraph and rethink multiple times.)

        So we have separated all the words based on lines. Now we need to format those line to generate the output.

        Lets see how can we format the lines?
         public void formatLines(
                List<List<String>> lines,
                List<String> result,
                int maxWidth
            ) {
               for (int currentLine = 0; currentLine < lines.size(); currentLine++) {
                   List<String> line = lines.get(currentLine);

                   if (line.size() == 1 || currentLine == lines.size() - 1) {
                       result.add(makeLeftAligned(line, maxWidth));
                   } else {
                       result.add(makeMiddleAligned(line, maxWidth));
                   }
               }
            }
        Simple function. Right? Now think when you will do left justification and when middle justification?
        If a line contains only one word it will be left justified or left aligned.
        Also if a line is the last line it will be left justified. So we did this here.
        For the alignment we passing the line and maxWidth to two separate function makeLeftAligned and makeMiddleAligned

        Now first see what is happening inside makeLeftAligned function
        Previously in a line list we just added the string but did not added any spaces.
        Now we have to add spaces between word as well as space in the end if required.

         public String makeLeftAligned(List<String> words, int maxWidth) {
                StringBuilder builder = new StringBuilder();
                int remainingPos = maxWidth - getCharacterCount(words);

                for (String word : words) {
                    builder.append(word);
                    if (remainingPos > 0) {
                        builder.append(' ');
                        remainingPos--;
                    }
                }

                while (remainingPos > 0) {
                    builder.append(' ');
                    remainingPos--;
                }

                return builder.toString();
            }
        I think you understand what I did. First we called a function getCharacterCount which just return the total word.
        You can optmize here. You can calculate this while adding word in the line in the first method.
        However, I did like this to keep my code clean. Here is the getCharacterCount function

         private int getCharacterCount(List<String> line) {
                int count = 0;
                for (String word : line) {
                    count += word.length();
                }
                return count;
            }
        So we first get the actual character count. Then we subtracted it from maxWidth to get the remainingCharacter.
        This we need to fill with spacea. So for each character we are adding a space and we decrementing the
        remainingPos variable. So we added one space between words. But we may have remaining position in the end.
        So we fill those position with space inside while loop.

        Now see what we did inside makeMiddleAligned function?

         public String makeMiddleAligned(List<String> line, int maxWidth) {
                StringBuilder builder = new StringBuilder();
                int remainingChar = maxWidth - getCharacterCount(line);

                for (int i = 0; i < line.size(); i++) {
                    builder.append(line.get(i));

                    // Do not add space after last word
                    if (i != line.size() - 1) {
                        int wordsRequiredSpaceCount = line.size() -i - 1;
                        int spaces = (int) Math.ceil((double) remainingChar / (double) wordsRequiredSpaceCount);
                        remainingChar -= spaces;

                        for (int j = 0; j < spaces; j++) {
                            builder.append(' ');
                        }
                    }
                }

                return builder.toString();
            }
        First calculated the remainingChar which we need to fillup. In case of middle alignment it is littlle bit tricky. We need to add spaces between words. So we could not add space after last word. Now how can we know how many space we need to add after each word? Again remainingChar can be odd number. So how we are going to distribute those spaces?

        Don't worry. Space after each word will be
        int spaces = Ceil(remainingChar / (wordCountPerLine - i - 1))
        Why we are doing that? If we have 3 word we are putting the spaces before two words or we can say after two words. So thats why -1. Now why -i? Suppose we have 5 remainingChar and wordCountPerLine = 3.
        So after adding 1 word to stringbuilder it will go inside if and i = 0 so
        spaces = Ceil(5 / ( 3 - 0 - 1) )
        spaces = Ceil (5 / 2)
        spaces = 3

        So after the first word it will put three spaces and we subtract this from remainChar as it has been full filled with spaces.
        remainChar = 5 - 3 = 2
        Now when i = 1 means adding another word what will happen?
        spaces = Ceil (2 / (3 - 1 - 1))
        spaces = Ceil (2 / 1)
        spaces = 2

        So we need to give 2 spaces. After that remainingChar will be 0.

        (wordCounterPerLine - i) -> this means the total amount words in the line left and the -1
        would give us the number of sections where space has to be added.

        Now we can return the result. Lets look the whole code at once

     public List<String> fullJustify(String[] words, int maxWidth) {
            List<List<String>> lines = new ArrayList<>();
            List<String> result = new ArrayList<>();
            Map<Integer, Integer> charMap = new HashMap<>();
            int currentLine = 0;

            lines.add(new ArrayList<String>());
            charMap.put(currentLine, maxWidth);

            for (String word : words) {
                int remainingChar = charMap.get(currentLine);
                if (word.length() <= remainingChar) {
                    addWordToLine(currentLine, lines, charMap, word, maxWidth);
                } else {
                    currentLine++;
                    lines.add(new ArrayList<String>());
                    charMap.put(currentLine, maxWidth);
                    addWordToLine(currentLine, lines, charMap, word, maxWidth);
                }
            }

            formatLines(lines, result, maxWidth);
            return result;
        }

        public void addWordToLine(
            Integer currentLine,
            List<List<String>> lines,
            Map<Integer, Integer> charMap,
            String word,
            int maxWidth) {

            lines.get(currentLine).add(word);
            // Now change remaining and add space if required
            charMap.put(currentLine, charMap.get(currentLine) - word.length());

            // We have to add a space if at least one position left otherwise we
            // can not add a new word. So subtracting one from remaining character
            if (charMap.get(currentLine) != 0) {
                charMap.put(currentLine, charMap.get(currentLine) - 1);
            }
        }

        public void formatLines(
            List<List<String>> lines,
            List<String> result,
            int maxWidth
        ) {
           for (int currentLine = 0; currentLine < lines.size(); currentLine++) {
               List<String> line = lines.get(currentLine);

               if (line.size() == 1 || currentLine == lines.size() - 1) {
                   result.add(makeLeftAligned(line, maxWidth));
               } else {
                   result.add(makeMiddleAligned(line, maxWidth));
               }
           }
        }

        public String makeLeftAligned(List<String> words, int maxWidth) {
            StringBuilder builder = new StringBuilder();
            int remainingPos = maxWidth - getCharacterCount(words);

            for (String word : words) {
                builder.append(word);
                if (remainingPos > 0) {
                    builder.append(' ');
                    remainingPos--;
                }
            }

            while (remainingPos > 0) {
                builder.append(' ');
                remainingPos--;
            }

            return builder.toString();
        }

        public String makeMiddleAligned(List<String> line, int maxWidth) {
            StringBuilder builder = new StringBuilder();
            int remainingChar = maxWidth - getCharacterCount(line);

            for (int i = 0; i < line.size(); i++) {
                builder.append(line.get(i));

                // Do not add space after last word
                if (i != line.size() - 1) {
                    int wordsRequiredSpaceCount = line.size() -i - 1;
                    int spaces = (int) Math.ceil((double) remainingChar / (double) wordsRequiredSpaceCount);
                    remainingChar -= spaces;

                    for (int j = 0; j < spaces; j++) {
                        builder.append(' ');
                    }
                }
            }

            return builder.toString();
        }

        private int getCharacterCount(List<String> line) {
            int count = 0;
            for (String word : line) {
                count += word.length();
            }
            return count;
        }
        It looks large.
        But if you break down the problem multiple steps you can have unit test each and
        every function and can check your logic.
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> charMap = new HashMap<>();
        int currentLine = 0;

        lines.add(new ArrayList<>());
        charMap.put(currentLine, maxWidth);

        for (String word : words) {
            int remainingChar = charMap.get(currentLine);
            if (word.length() <= remainingChar) {
                addWordToLine(currentLine, lines, charMap, word, maxWidth);
            } else {
                currentLine++;
                lines.add(new ArrayList<>());
                charMap.put(currentLine, maxWidth);
                addWordToLine(currentLine, lines, charMap, word, maxWidth);
            }
        }

        formatLines(lines, result, maxWidth);
        return result;
    }

    public void addWordToLine(Integer currentLine, List<List<String>> lines, Map<Integer,
            Integer> charMap, String word, int maxWidth) {
        lines.get(currentLine).add(word);
        charMap.put(currentLine, charMap.get(currentLine) - word.length());

        if (charMap.get(currentLine) != 0) {
            charMap.put(currentLine, charMap.get(currentLine) - 1);
        }
    }

    public void formatLines(List<List<String>> lines, List<String> result, int maxWidth) {
        for (int currentLine = 0; currentLine < lines.size(); currentLine++) {
            List<String> line = lines.get(currentLine);

            if (line.size() == 1 || currentLine == lines.size() - 1) {
                result.add(makeLeftAligned(line, maxWidth));
            } else {
                result.add(makeMiddleAligned(line, maxWidth));
            }
        }
    }

    public String makeLeftAligned(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int remainingPosition = maxWidth - getCharacterCount(words);

        for (String word : words) {
            sb.append(word);
            if (remainingPosition > 0) {
                sb.append(' ');
                remainingPosition--;
            }
        }

        while (remainingPosition > 0) {
            sb.append(' ');
            remainingPosition--;
        }
        return sb.toString();
    }

    public String makeMiddleAligned(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int remainingChar = maxWidth - getCharacterCount(line);

        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));

            if (i != line.size() - 1) {
                int wordsRequiringSpaceCount = line.size() - i - 1;
                int spaces = (int) Math.ceil(((double) remainingChar / (double) wordsRequiringSpaceCount));
                remainingChar -= spaces;

                for (int j = 0; j < spaces; j++) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    private int getCharacterCount(List<String> line) {
        int count = 0;
        for (String word : line) {
            count += word.length();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new TextJustification().fullJustify(new String[]{
                "What", "must", "be", "acknowledgment", "shall", "be"}, 16));
    }
}
