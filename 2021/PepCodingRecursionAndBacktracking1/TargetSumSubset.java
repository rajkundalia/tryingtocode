package RecursionPepCode;

//https://youtu.be/HGDmj5NrrjM
public class TargetSumSubset {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        printTargetSumSubsets(arr, 0, "", 0, 70);
    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(idx == arr.length) {
            if(sos == tar) {
                System.out.println(set);
            }
            return;
        }
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + " ", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}
