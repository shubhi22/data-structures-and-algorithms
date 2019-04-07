package com.programmergirl.divideandconquer;

/*
 * "ELRMENMET"-> "EMEME" o/p = 5
 * "AMEEWMEA" -> "AMEEMA"o/p = 6
 * "MADAM" - > o/p = 5
 */
public class LongestPallindromicSubsequence {

    public static void main(String[] args) {

        System.out.println(longestPallindromicSubsequence("ELRMENMET", 0, 8));
        System.out.println(longestPallindromicSubsequence("AMEEWMEA", 0, 7));
        System.out.println(longestPallindromicSubsequence("MADAM", 0, 4));
    }

    public static int longestPallindromicSubsequence(String str1, int i, int j) {

        if (i > j) { // full string processed
            return 0;
        }
        if (i == j) {// when both pointers are at the same element - single character is a pallindrome
            return 1;
        }

        int takeCount = 0;
        if (str1.charAt(i) == str1.charAt(j)) {
            takeCount = 2 + longestPallindromicSubsequence(str1, i + 1, j - 1);
        }
        int notTakeCount1 = longestPallindromicSubsequence(str1, i, j - 1);
        int notTakeCount2 = longestPallindromicSubsequence(str1, i + 1, j);
        return Math.max(takeCount, Math.max(notTakeCount1, notTakeCount2));
    }
}

