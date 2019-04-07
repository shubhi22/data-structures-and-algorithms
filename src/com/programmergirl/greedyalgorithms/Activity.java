package com.programmergirl.greedyalgorithms;

public class Activity implements Comparable<Activity> {

    private String name;
    private Integer startTime;
    private Integer finishTime;

    public Activity(String name, Integer startTime, Integer finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Integer finishTime) {
        this.finishTime = finishTime;
    }

    @Override public int compareTo(Activity other) {
        return Integer.compare(this.finishTime, other.finishTime);
    }

    @Override public String toString() {
        return "Activity{" + "name='" + name + '\'' + ", startTime=" + startTime + ", finishTime=" + finishTime + '}';
    }
}
