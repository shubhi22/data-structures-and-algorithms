package com.programmergirl.divideandconquer;

public class LongestPallindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPallindromicSubstring("MADAM", 0, 4));
        System.out.println(longestPallindromicSubstring("MAMDRDM", 0, 6)); // "MDRDM"
        System.out.println(longestPallindromicSubstring("MQADASM", 0, 6)); // "ADA"

    }

    public static int longestPallindromicSubstring(String str1, int i, int j) {

        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        int takeCount = 0;
        if (str1.charAt(i) == str1.charAt(j)) {
            int remainingLength = j - i - 1;
            if (remainingLength == longestPallindromicSubstring(str1, i + 1, j - 1)) {
                takeCount = 2 + remainingLength;
            }
        }
        int notTakeCount1 = longestPallindromicSubstring(str1, i + 1, j);
        int notTakeCount2 = longestPallindromicSubstring(str1, i, j - 1);

        return Math.max(takeCount, Math.max(notTakeCount1, notTakeCount2));
    }
}
