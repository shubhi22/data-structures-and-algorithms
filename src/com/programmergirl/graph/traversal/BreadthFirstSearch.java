package com.programmergirl.graph.traversal;

import com.programmergirl.graph.common.Edge;
import com.programmergirl.graph.common.Graph;
import com.programmergirl.graph.common.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();

        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));
        vertices.add(new Vertex("D"));
        vertices.add(new Vertex("E"));

        vertices.get(0).addNeighbour(new Edge(vertices.get(1)));
        vertices.get(0).addNeighbour(new Edge(vertices.get(2)));
        vertices.get(1).addNeighbour(new Edge(vertices.get(4)));
        vertices.get(2).addNeighbour(new Edge(vertices.get(3)));
        vertices.get(3).addNeighbour(new Edge(vertices.get(4)));

        Graph graph = new Graph(vertices);

        bfs(graph.getVertices().get(0));
    }

    public static void bfs(Vertex sourceVertex) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.poll();
            System.out.print(actualVertex);

            for (Edge edge : actualVertex.getAdjacencyList()) {
                Vertex adjacentVertex = edge.getTargetVertex();
                if (!adjacentVertex.isVisited()) {
                    adjacentVertex.setVisited(true);
                    queue.add(adjacentVertex);
                }
            }
        }
    }
}
