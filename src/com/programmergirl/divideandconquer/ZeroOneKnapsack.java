package com.programmergirl.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n items with their weight and net worth and a knapsack of capacity 'knapsackCapacity'
 * we want to maximize the profit of items collected in the knapsack
 * Note that the sum of weights of items collected in knapsack should be less than or equal to 'knapsackCapacity'
 */
public class ZeroOneKnapsack {

    public static void main(String[] args) {
        KnapsackItem item1 = new KnapsackItem("A", 10, 60);
        KnapsackItem item2 = new KnapsackItem("B", 20, 100);
        KnapsackItem item3 = new KnapsackItem("C", 30, 120);

        List<KnapsackItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        System.out.println(maxCollectedWorth01Knapsack(items, 0, 50));


        item1 = new KnapsackItem("A", 3, 31);
        item2 = new KnapsackItem("B", 1, 26);
        item3 = new KnapsackItem("C", 5, 72);
        KnapsackItem item4 = new KnapsackItem("D", 2, 17);


        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        System.out.println(maxCollectedWorth01Knapsack(items, 0, 7));
    }

    public static int maxCollectedWorth01Knapsack(List<KnapsackItem> items, int i, int knapsackCapacity) {
        if (i >= items.size()) {
            return 0;
        }
        KnapsackItem item = items.get(i);

        int profit1 = 0;
        if (item.getWeight() <= knapsackCapacity) {
            //collecting item in knapsack
            profit1 = item.getValue() + maxCollectedWorth01Knapsack(items, i + 1, knapsackCapacity - item.getWeight());
        }
        //leaving current item
        int profit2 = maxCollectedWorth01Knapsack(items, i + 1, knapsackCapacity);

        return Math.max(profit1, profit2);
    }
}
