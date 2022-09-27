package interviewbit.twopointers;

/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).

'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained
(Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity).

Note: You may not slant the container.
Example :
Input : [1, 5, 4, 3]
Output : 6
Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
So total area = 3 * 2 = 6
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] A) {
        int ans = 0;
        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int currentArea = Math.min(A[l], A[r]) * (r - l);
            ans = Math.max(currentArea, ans);
            if (A[r] > A[l]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}

/*
Consider you are given n non-negative integers say a1, a2, ..., an, where each element in the array represents a
point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and
(i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example
Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2

Solution

Let us try to understand the problem statement first.
In this problem, we are given an array of integers representing the heights.
The distance between these heights is uniform (1 unit). Our job is to write an algorithm to find the
largest container or largest area that can be formed by joining any of these two heights.


We can calculate the area using the formula,

Area = minimum{height 1, height 2} * width.

Note: We take minimum of two heights for area calculation because, any water over the minimum height
cannot be held by the container, as it spills over. For example, if (3,4) are the given pair of heights,
the container formed using these two heights would look as in the below diagram:

As you can see from the above diagram, the maximum possible water level for heights (3,4) is height=3.
Even if you try to pour more water into the container, it gets spilled over from the left side where height is 3.
That is the reason why we take minimum of heights 1 and 2 while calculating the area.

Solution 1: Brute Force

The brute force solution to this problem is to check every possible combination of the given heights.
For example if [4,3,2,6] is the given heights array, we start by comparing the 0th and 1st index elements,
i.e.  heights (4,3). So, Area = minimum{4,3}*1 = 3*1 which is equal to 3 (calculated using the above area formula).
Then we check for heights at 0th and 2nd index i.e. (4,2) for which Area = minimum{4,2}*2 = 2. Similarly, we check all
the possible combinations (4,6), (3,2), (3,6), (2,6) and finally return the maximum area obtained out of all the
combinations as the result.

This algorithms involves the following steps:
Use two loops, fix the the outer loop and move the inner loop to check every possible combination of two
heights in the given array.

Outer loop runs from 0 to n-1 and inner loop runs from outerLoopIndex + 1 to n.

For each iteration of the inner loop you will get a pair of heights.
Check if the area formed using this pair of heights is greater than the max area so far.

If yes update the result, else continue to check the next pair.
Repeat step 1-4 for all possible pair of heights.
Finally return the maximum area obtained as the result.

Since we need to check every possible pair of heights in the given array in order to find the maximum area, the running time complexity of this solution is O(n^2).

Solution 2: Optimized Solution

This problem can be solved efficiently in linear time using two pointer technique.
If you observe the previous solution carefully, you will notice a pattern.

For instance, if [1,8,6,2,5,4,8,3,7] is the given array, if you start with the combination of first and last heights
and move inwards i.e. (1,7), (1,3), (1,8), (1,4) and so on, you can see that you get no benefit by using combinations
(1,3), (1,8), (1,4) so on after (1,7) to calculate area, as the minimum height obtained by using any of these
combinations remains same. This is so because in all cases 2nd height is greater than the 1st height (height1= 1,
which is same for all the pairs), and since we take the minimum of 1st and 2nd heights while calculating the area,
we always end up with 1 as the result(for minimum height) for all the above combinations. This is true for all such
cases where for a set of combinations one of the heights is same and it is smaller than the other height in all pairs.
Also the width keeps decreasing as we move inwards, for (1,7) width is 8, for (1,3) width is 7, for (1,8) width is 6
and so on. Therefore, the area also will decrease.

We can use this to our advantage to solve this problem in linear time. This approach involves the following steps:

We need to start our algorithm with left pointer pointing to the 0th index and right pointer pointing to the last
index of the heights array.

We calculate the area using the left and right heights using the previous formula.

After this we need to retain maximum of left and right pointers (heights) and move the other pointer.
For example if our (left, right) = (1,7), after calculating the area, we check which of (left height, right height)
is larger. In this case, right height i.e. 7 is the larger of the two. So, we keep the right pointer at the same
position and increment the left pointer by 1.

Similarly, if the left element was larger as in (8,3) then we keep the left pointer at the same index
and decrement the right pointer after calculating the area for (8, 3). We can do this because we know,
we do not get any benefit (in terms of area obtained) by retaining the smaller height, and thus this would
have no impact on the output.

We have to repeat the above steps as long as our left pointer is less than right pointer, after which we
return the maximum area obtained thus far as the result.

This algorithm goes through each array element only once to find the result, so the time complexity of this
algorithm is O(n).
 */
