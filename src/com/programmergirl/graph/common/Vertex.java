package com.programmergirl.graph.common;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    private String data;
    private List<Edge> adjacencyList;
    private boolean beingVisited;
    private boolean visited;
    private double distance = Double.MAX_VALUE;
    private Vertex predecessor;

    public Vertex(String data) {
        this.data = data;
        adjacencyList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Edge> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    @Override public String toString() {
        return data + " ";
    }

    @Override public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.distance);
    }
}
