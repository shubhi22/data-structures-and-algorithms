package com.programmergirl.graph.shortestpath;

import com.programmergirl.graph.common.Edge;
import com.programmergirl.graph.common.Graph;
import com.programmergirl.graph.common.Vertex;

import java.util.*;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        vertexA.addNeighbour(new Edge(vertexB, 1));
        vertexA.addNeighbour(new Edge(vertexC, 5));
        vertexB.addNeighbour(new Edge(vertexC, 1));

        dijkstraAlgorithm(vertexA);

        System.out.println(shortestPathTo(vertexC));

    }

    public static void dijkstraAlgorithm(Vertex sourceVertex) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        sourceVertex.setDistance(0);
        sourceVertex.setVisited(true);
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {

            Vertex minDistanceVertex = queue.poll();

            //Relax all edges of minDistanceVertex
            for (Edge edge : minDistanceVertex.getAdjacencyList()) {
                Vertex adjacentVertex = edge.getTargetVertex();
                double tempDistance = minDistanceVertex.getDistance() + edge.getWeight();

                if (tempDistance < adjacentVertex.getDistance()) {

                    adjacentVertex.setDistance(tempDistance);
                    adjacentVertex.setPredecessor(minDistanceVertex);

                    if (!adjacentVertex.isVisited()) {
                        adjacentVertex.setVisited(true);
                        queue.add(adjacentVertex);
                    }
                }
            }
        }

    }

    public static List<Vertex> shortestPathTo(Vertex vertex) {
        List<Vertex> shortestPath = new ArrayList<>();

        while (vertex != null) {
            shortestPath.add(vertex);
            vertex = vertex.getPredecessor();
        }

        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
