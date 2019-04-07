package com.programmergirl.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given n activities with their start and finish time, we want to find the maximum number of activities
 * a person can perform considering he can only perform one activity at a given point in time
 */
public class ActivitySelectionProblem {

    public static void main(String[] args) {
        Activity activity1 = new Activity("A1", 0, 6);
        Activity activity2 = new Activity("A2", 3, 4);
        Activity activity3 = new Activity("A3", 1, 2);
        Activity activity4 = new Activity("A4", 5, 8);
        Activity activity5 = new Activity("A5", 5, 7);
        Activity activity6 = new Activity("A6", 8, 9);

        List<Activity> listOfActivities = new ArrayList<>();
        listOfActivities.add(activity1);
        listOfActivities.add(activity2);
        listOfActivities.add(activity3);
        listOfActivities.add(activity4);
        listOfActivities.add(activity5);
        listOfActivities.add(activity6);

        int maxActivitiesCount = selectActivities(listOfActivities);
        System.out.println("Maximum Activities that can be performed = " + maxActivitiesCount);

    }

    public static int selectActivities(List<Activity> listOfActivities) {
        //Sort by asc order of finish times - Activity implements Comparable
        Collections.sort(listOfActivities);

        //Select first activity in sorted array
        int maxActivitiesCount = 1;
        Activity previousActivity = listOfActivities.get(0);
        System.out.println("Performing :" + listOfActivities.get(0));

        //Select subsequent activities
        for (int i = 1; i < listOfActivities.size(); i++) {
            Activity currentActivity = listOfActivities.get(i);
            if (isNonOverlappingActivity(previousActivity, currentActivity)) {
                System.out.println("Performing :" + currentActivity);
                maxActivitiesCount += 1;
                previousActivity = currentActivity;
            }
        }

        return maxActivitiesCount;
    }

    private static boolean isNonOverlappingActivity(Activity previous, Activity current) {
        return current.getStartTime() >= previous.getFinishTime();
    }
}
