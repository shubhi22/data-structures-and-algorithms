package com.programmergirl.divideandconquer;

/*
 * Find min number of transformations required to convert a string str2 to str1
 * using insert/delete/replace operations
 * Eg : catch carch o/p = 1
 * table tbres o/p = 3 : insert 'a' at 2nd position, replace 'r' with 'l', delete 's'
 */
public class ConvertOneStringToAnother {

    public static void main(String[] args) {
        System.out.println(minTransformationsRequired("catch", "carch", 0, 0));
        System.out.println(minTransformationsRequired("table", "tbres", 0, 0));
        System.out.println(minTransformationsRequired("table", "tgable", 0, 0));
        System.out.println(minTransformationsRequired("table", "tble", 0, 0));
        System.out.println(minTransformationsRequired("table", "tcble", 0, 0));

    }

    private static int minTransformationsRequired(String str1, String str2, int i, int j) {

        if (i == str1.length()) { //if we have reached end of str1, all characters of str2 ahead needs to be deleted
            return str2.length() - j;
        }
        if(j == str2.length()) { //if we have reached end of str2, all rem characters of str1 to be inserted
            return  str1.length() - i;
        }
        int insertCount = 0, deleteCount = 0, replaceCount = 0;

        if (str1.charAt(i) != str2.charAt(j)) {
            insertCount = 1 + minTransformationsRequired(str1, str2, i + 1, j);
            deleteCount = 1 + minTransformationsRequired(str1, str2, i, j + 1);
            replaceCount = 1 + minTransformationsRequired(str1, str2, i + 1, j + 1);
            return Math.min(insertCount, Math.min(deleteCount, replaceCount));

        } else {
            return minTransformationsRequired(str1, str2, i + 1, j + 1);
        }
    }
}
