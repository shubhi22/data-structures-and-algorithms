package com.programmergirl.graph.dfs.applications;

import com.programmergirl.graph.common.Edge;
import com.programmergirl.graph.common.Graph;
import com.programmergirl.graph.common.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        List<Vertex> list = new ArrayList<>();

        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        v2.addNeighbour(new Edge(v3));
        v5.addNeighbour(new Edge(v2));
        v5.addNeighbour(new Edge(v0));
        v4.addNeighbour(new Edge(v0));
        v4.addNeighbour(new Edge(v1));
        v3.addNeighbour(new Edge(v1));

        Graph graph = new Graph(list);

        topologicalSort(graph);
    }
    public static void topologicalSort(Graph graph) {
        Stack<Vertex> stack = new Stack<>();
        for(Vertex v : graph.getVertices()) {
            if(!v.isVisited()) {
                topologicalSort(v, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "->");
        }
        System.out.println();
    }

    private static void topologicalSort(Vertex vertex, Stack<Vertex> stack) {
        vertex.setVisited(true);
        for (Edge edge : vertex.getAdjacencyList()) {
            Vertex v = edge.getTargetVertex();
            if(!v.isVisited()) {
                topologicalSort(v, stack);
            }
        }
        stack.push(vertex);
    }
}
