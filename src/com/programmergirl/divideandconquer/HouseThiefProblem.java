package com.programmergirl.divideandconquer;

/*
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is willing to maximize his profit but he isn't allowed to steal from
 * two adjacent houses as owner of each house will inform his two (left and right)
 * neighbours
 */
public class HouseThiefProblem {

    public static void main(String[] args) {
        int[] housesWorth = { 5, 3, 4, 11, 2 };

        System.out.println(maxStolenProfit(housesWorth, 0));
    }

    public static int maxStolenProfit(int[] housesWorth, int i) {

        if (i >= housesWorth.length) {
            return 0;
        }

        int profit1 = housesWorth[i] + maxStolenProfit(housesWorth, i + 2);
        int profit2 = maxStolenProfit(housesWorth, i + 1);

        return Math.max(profit1, profit2);
    }
}
