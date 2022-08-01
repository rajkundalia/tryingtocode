package interviewbit.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 7, 8, 9}, 2));
        int[] arr = new int[]{1, 2, 3, 4, 7, 8, 9};
        System.out.println(binarySearchRecursion(arr, 0, arr.length, 2));
    }

    public static String binarySearch(int[] arr, int x) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (x == arr[mid]) {
                return "Found " + x + " at " + mid;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return x + "not found";
    }

    public static int binarySearchRecursion(int[] arr, int start, int end, int x) {
        if (end >= start) {
            int mid = (start + (end - 1)) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearchRecursion(arr, start, mid - 1, x);
            }

            return binarySearchRecursion(arr, mid + 1, end, x);
        }
        return -1;
    }
}
