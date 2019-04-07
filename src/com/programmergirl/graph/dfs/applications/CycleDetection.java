package com.programmergirl.graph.dfs.applications;

import com.programmergirl.graph.common.Edge;
import com.programmergirl.graph.common.Vertex;

public class CycleDetection {

    public static void main(String[] args) {

        testUndirectedGraph();
        testDirectedGraph();
    }

    public static void testDirectedGraph() {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");

        v0.addNeighbour(new Edge(v1));
        v1.addNeighbour(new Edge(v2));
        v2.addNeighbour(new Edge(v3));
        v3.addNeighbour(new Edge(v1));

        System.out.println(hasCycleDirected(v0));
    }

    public static void testUndirectedGraph() {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");

        v0.addNeighbour(new Edge(v1));
        v1.addNeighbour(new Edge(v0));

        v1.addNeighbour(new Edge(v2));
        v2.addNeighbour(new Edge(v1));

        v2.addNeighbour(new Edge(v0));
        v0.addNeighbour(new Edge(v2));

        v2.addNeighbour(new Edge(v3));
        v3.addNeighbour(new Edge(v2));

        System.out.println(hasCycleUndirected(v0, null));
    }

    public static boolean hasCycleUndirected(Vertex source, Vertex parent) {
        source.setBeingVisited(true);
        for (Edge edge : source.getAdjacencyList()) {
            Vertex adjVertex = edge.getTargetVertex();
            if (adjVertex != parent) {
                if (adjVertex.isBeingVisited()) {
                    //there's a backward edge
                    return true;
                } else if (!adjVertex.isVisited()) {
                    if (hasCycleUndirected(adjVertex, source)) {
                        return true;
                    }
                }
            }
        }
        source.setBeingVisited(false);
        source.setVisited(true);
        return false;
    }

    public static boolean hasCycleDirected(Vertex source) {
        source.setBeingVisited(true);
        for (Edge edge : source.getAdjacencyList()) {
            Vertex adjVertex = edge.getTargetVertex();
            if (adjVertex.isBeingVisited()) {
                //backward edge
                return true;
            } else if (!adjVertex.isVisited()) {
                if (hasCycleDirected(adjVertex)) {
                    return true;
                }
            }
        }
        source.setBeingVisited(false);
        source.setVisited(true);
        return false;
    }
}
