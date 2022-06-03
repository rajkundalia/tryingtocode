package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input Format
First argument is an integer array A containing arrival time of booking.

Second argument is an integer array B containing departure time of booking.

Third argument is an integer C denoting the count of rooms.

Output Format
Return True if there are enough rooms for N bookings else return False.

Example Input
Input 1:

 A = [1, 3, 5]
 B = [2, 6, 8]
 C = 1

Example Output
Output 1:

 0

Example Explanation
Explanation 1:

 At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBookingsPossible {
    public static void main(String[] args) {
        System.out.println(solveHotelBookingsPossible(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<>(List.of(2, 3, 4)), 1));
    }

    public static boolean solveHotelBookingsPossible(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);

        int count = 0;
        int indexArrival = 0;
        int indexDeparture = 0;

        int n = arrive.size();

        while (indexArrival < n && indexDeparture < n) {
            if (arrive.get(indexArrival) <= depart.get(indexDeparture)) {
                indexArrival++;
                count++;

                if (count > K) {
                    return false;
                }
            } else {
                indexDeparture++;
                count--;
            }
        }
        return true;
    }
}
