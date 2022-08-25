package interviewbit.strings;

/*
Our company wants to create a data entry verification system.
Given an amount in words and an amount indicated by data entry person in numbers,
you have to detect whether the amounts are same or not.

Note: There are a lot of corner cases to be considered. Interviewer expects you to take care of them.
Input:
String num: Amount written in digits as a string. This string will be an integer number without having any
commas in between the digits.
String words: Amount written in words according to Indian Numbering System.

Output:
An integer
1: Values match
0: Otherwise
Please note :Every word needs to be separated using "-" rather than a space character
 https://en.wikipedia.org/wiki/Indian_numbering_system

Constraints
The number will fall in integer range(10^9)

Example :
Input :
String  num = "1234"
String words  = "one-thousand-two-hundred-and-thirty-four"
Output:
1
“Use Expected Output option” to clear the further doubts.

// This is a copy from comments in interviewbit.
 */
public class ConvertAmountToWords {
    public static void main(String[] args) {
        System.out.println(solve("1234", "one-thousand-two-hundred-and-thirty-four"));
    }

    public static int solve(String A, String B) {
        long amount = Long.parseLong(A);
        String b = f(amount);
        return b.equals(B) ? 1 : 0;
    }


    private static class Place {
        int unit;
        String name;

        public Place(int unit, String name) {
            this.unit = unit;
            this.name = name;
        }
    }

    private static final Place[] places = new Place[]{
            new Place(10000000, "crore"),
            new Place(100000, "lakh"),
            new Place(1000, "thousand"),
            new Place(100, "hundred")
    };

    private static final String[] tens = new String[]{
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] units = new String[]{
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static String f(long amount) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < places.length; i++) {
            Place place = places[i];
            int qty = (int) (amount / place.unit);
            if (qty > 0) {
                String toAdd = "";
                if (qty > 10) {
                    toAdd = f(qty) + "-" + place.name;
                } else {
                    toAdd = units[qty] + "-" + place.name;
                }
                if (sb.length() > 0) {
                    sb.append("-");
                }
                sb.append(toAdd);
            }
            amount -= (long) qty * place.unit;
        }

        if (sb.length() > 0 && amount > 0) {
            sb.append("-and-");
        }

        int ten = (int) (amount / 10);
        boolean shouldAddAnd = false;
        if (ten > 1) {
            sb.append(tens[ten]);
            amount -= 10 * ten;
            shouldAddAnd = true;
        }

        if (amount > 0) {
            if (shouldAddAnd) {
                sb.append("-");
            }
            sb.append(units[(int) amount]);
        }

        return sb.toString();
    }
}