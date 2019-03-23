package com.programmergirl.greedyalgorithms;

import java.util.*;

/*
 *Given Rs. V and available denominations, make the change for V
 * such that we use minimum number of available denominations
 * to make a change, Assumption is that we have an infinite supply
 * of available denominations
 */
public class CoinChangeProblem {

    public static void main(String[] args) {
        List<Integer> denominations = new ArrayList<>();
        denominations.add(1);
        denominations.add(2);
        denominations.add(5);
        denominations.add(10);
        denominations.add(20);
        denominations.add(50);
        denominations.add(100);
        denominations.add(200);
        denominations.add(500);
        denominations.add(2000);

        int minCoinsNeeded = coinChange(3075, denominations);
        System.out.println("Minimum coins needed = " + minCoinsNeeded);
    }

    public static int coinChange(int V, List<Integer> denominations) {

        Map<Integer, Integer> denominationsCount = new TreeMap<>();
        int totalCoins = 0;

        //Sorted in desc order of denominations
        Collections.sort(denominations, Collections.reverseOrder());

        int i = 0;
        //Find first valid denomination to use
        while (denominations.get(i) > V)
            i++;

        while (i < denominations.size() && V > 0) {
            if (V < denominations.get(i))
                i++;
            else {
                if (denominationsCount.containsKey(denominations.get(i))) {
                    denominationsCount.put(denominations.get(i), denominationsCount.get(denominations.get(i)) + 1);
                } else {
                    denominationsCount.put(denominations.get(i), 1);
                }
                totalCoins += 1;
                V = V - denominations.get(i);
            }
        }

        System.out.println("Currency Change : " + denominationsCount);

        return totalCoins;
    }
}
