package com.programmergirl.divideandconquer;

import java.awt.desktop.ScreenSleepEvent;

/*
 * Given 2d matrix where each cell is associated with a cost
 * We want to move from (0, 0) to (n - 1, n - 1) moving each down or right only
 * Find the min required cost to achieve it
 */
public class MinCostToReachLastCell {

    public static void main(String[] args) {
        int[][] cells = { { 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 }, { 2, 9, 8, 9, 3 } };

        System.out.println(minCostToReachLastCell(cells, 4, 4));

    }

    public static int minCostToReachLastCell(int[][] cellsCost, int i, int j) {

        if (i == -1 || j == -1) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return cellsCost[0][0];
        }
        int costComingFromLeft = minCostToReachLastCell(cellsCost, i, j - 1);
        int costComingFromUp = minCostToReachLastCell(cellsCost, i - 1, j);
        return cellsCost[i][j] + Integer.min(costComingFromUp, costComingFromLeft);
    }
}
