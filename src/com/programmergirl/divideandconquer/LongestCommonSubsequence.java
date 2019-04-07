package com.programmergirl.divideandconquer;

/*
 * Subsequence is a sequence we derive by deleting a few characters from a given sequence
 * without changing the order of the remaining elements
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        //lcs here is eepat of length 5
        String str1 = "elephant";
        String str2 = "eretpat";

        System.out.println(findLCSLength(str1, str2, 0, 0));
        System.out.println(findLCSLength("passport", "ppsspt", 0, 0));

    }

    public static int findLCSLength(String str1, String str2, int i, int j) {

        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        int count1 = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            //include that character
            count1 = 1 + findLCSLength(str1, str2, i + 1, j + 1);
        }
        //take first and leave 2nd char
        int count2 = findLCSLength(str1, str2, i + 1, j);
        //take 2nd and leave first char
        int count3 = findLCSLength(str1, str2, i, j + 1);
        return Math.max(count1, Math.max(count2, count3));
    }
}
