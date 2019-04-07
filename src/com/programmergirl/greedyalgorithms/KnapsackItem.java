package com.programmergirl.greedyalgorithms;

public class KnapsackItem implements Comparable<KnapsackItem> {

    private String name;
    private Integer weight;
    private Integer value;
    private Double perKgWorth;

    public KnapsackItem(String name, Integer weight, Integer value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Double getPerKgWorth() {
        return perKgWorth;
    }

    public void setPerKgWorth(Double perKgWorth) {
        this.perKgWorth = perKgWorth;
    }

    //To sort in desc order
    @Override public int compareTo(KnapsackItem other) {
        return Double.compare(other.perKgWorth, this.perKgWorth);
    }

    @Override public String toString() {
        return "KnapsackItem{" + "name='" + name + '\'' + ", weight='" + weight + '\'' + ", value='" + value + '\'' + '}';
    }
}
