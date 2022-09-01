package interviewbit.strings;

/*
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.2", "1.13"));
    }

    public static int compareVersion(String A, String B) {
        String[] versionsA = A.split("\\.");
        String[] versionsB = B.split("\\.");
        int iA = 0;
        int iB = 0;

        while (iA < versionsA.length && iB < versionsB.length) {
            String versionA = removeZerosAtTheFront(versionsA[iA++]);
            String versionB = removeZerosAtTheFront(versionsB[iB++]);

            int compareCheck = compareCheck(versionA, versionB);
            if (compareCheck > 0) {
                return 1;
            }
            if (compareCheck < 0) {
                return -1;
            }
        }
        while (iA < versionsA.length) {
            if (!removeZerosAtTheFront(versionsA[iA]).equals("")) {
                return 1;
            }
            iA++;
        }

        while (iB < versionsB.length) {
            if (!removeZerosAtTheFront(versionsB[iB]).equals("")) {
                return -1;
            }
            iB++;
        }
        return 0;
    }

    private static int compareCheck(String versionA, String versionB) {
        if (versionA.length() > versionB.length()) {
            return 1;
        }
        if (versionB.length() > versionA.length()) {
            return -1;
        }
        return versionA.compareTo(versionB);
    }

    private static String removeZerosAtTheFront(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        return s.substring(index);
    }
}
