package com.programmergirl.string;

/*
* Given a string of form aaaabbbccd , print a4b3c2d1
 */
public class GenerateFrequencyCountString {
    public static void main(String[] args) {
        System.out.println(getFreqCountStr("aaaabbbbbccd"));
        System.out.println(getFreqCountStr("aaaaa"));
        System.out.println(getFreqCountStr("a"));
    }

    public static String getFreqCountStr(String str) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while(i < str.length()) {
            result.append(str.charAt(i++));
            int count = 1;
            while(i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                i++;
                count++;
            }
            result.append(count);
        }
        return result.toString();
    }
}


