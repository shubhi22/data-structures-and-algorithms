package com.programmergirl.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given a knapsack with a certain weight say 'knapsackWeight' and list of items with their worth and weights
 * Fill the knapsack such that we can maximize the profit out of it
 * Assumptions are that every type of item has exactly 1 quantity & items can be broken down into fractions
 */
public class FractionalKnapsackProblem {

    public static void main(String[] args) {
        KnapsackItem itemA = new KnapsackItem("A", 20, 100);
        KnapsackItem itemB = new KnapsackItem("B", 30, 120);
        KnapsackItem itemC = new KnapsackItem("C", 10, 60);

        List<KnapsackItem> items = new ArrayList<>();
        items.add(itemA);
        items.add(itemB);
        items.add(itemC);

        int maxWorth = fractionalKnapsack(items, 50);

        System.out.println("Collected worth of items : " + maxWorth);

        System.out.println("--------------------------------------------------------------");

        KnapsackItem item1 = new KnapsackItem("1", 6, 6);
        KnapsackItem item2 = new KnapsackItem("2", 10, 2);
        KnapsackItem item3 = new KnapsackItem("3", 3, 1);
        KnapsackItem item4 = new KnapsackItem("4", 5, 8);
        KnapsackItem item5 = new KnapsackItem("5", 1, 3);
        KnapsackItem item6 = new KnapsackItem("6", 3, 5);

        List<KnapsackItem> anotherItems = new ArrayList<>();
        anotherItems.add(item1);
        anotherItems.add(item2);
        anotherItems.add(item3);
        anotherItems.add(item4);
        anotherItems.add(item5);
        anotherItems.add(item6);

        System.out.println("Collected worth of items : " + fractionalKnapsack(anotherItems, 10));


    }

    public static int fractionalKnapsack(List<KnapsackItem> items, int knapsackWeight) {
        int collectedWeight = 0;
        int collectedValue = 0;
        updateKnapsackItemsPerKgWeight(items);

        Collections.sort(items);
        int i = 0;
        while (i < items.size() && items.get(i).getWeight() + collectedWeight <= knapsackWeight) {
            KnapsackItem nextItem = items.get(i);
            collectedWeight += nextItem.getWeight();
            collectedValue += nextItem.getValue();
            System.out.println("Picking up : " + nextItem);
            i++;
        }
        if (i < items.size()  & collectedWeight < knapsackWeight) {
            //Select fraction of last item
            KnapsackItem lastItem = items.get(i);
            int lastItemCollectedWeight = (knapsackWeight - collectedWeight);
            collectedWeight += lastItemCollectedWeight;
            collectedValue += lastItemCollectedWeight * lastItem.getPerKgWorth();

            System.out.println("Picking up " + lastItemCollectedWeight/(double)lastItem.getWeight() + "  of : " + lastItem);
        }

        return collectedValue;
    }

    private static void updateKnapsackItemsPerKgWeight(List<KnapsackItem> items) {
        for (KnapsackItem item : items) {
            item.setPerKgWorth((double) item.getValue() / item.getWeight());
        }
    }

}
