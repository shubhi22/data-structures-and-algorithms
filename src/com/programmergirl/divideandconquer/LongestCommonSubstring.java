package com.programmergirl.divideandconquer;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(findLongestCommonSubstringLength("passport", "ppsspt", 0, 0, 0));
    }

    public static int findLongestCommonSubstringLength(String str1, String str2, int i, int j, int count) {

        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            count = findLongestCommonSubstringLength(str1, str2, i + 1, j + 1, count + 1);
        }

        int count2 = findLongestCommonSubstringLength(str1, str2, i, j + 1, 0);
        int count3 = findLongestCommonSubstringLength(str1, str2, i + 1, j, 0);
        return Math.max(count, Math.max(count2, count3));
    }

}
