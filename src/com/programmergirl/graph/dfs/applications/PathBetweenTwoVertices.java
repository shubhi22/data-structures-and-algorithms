package com.programmergirl.graph.dfs.applications;

import com.programmergirl.graph.common.Edge;
import com.programmergirl.graph.common.Vertex;

import java.util.ArrayList;
import java.util.List;

public class PathBetweenTwoVertices {

    public static void main(String[] args) {
        List<Vertex> list = new ArrayList<>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.addNeighbour(new Edge(b));
        b.addNeighbour(new Edge(e));
        b.addNeighbour(new Edge(c));
        c.addNeighbour(new Edge(e));
        c.addNeighbour(new Edge(d));

        System.out.println(hasPath(a, d));
    }
    public static boolean hasPath(Vertex source, Vertex target) {
        source.setVisited(true);
        if(source == target) {
            return true;
        }
        for(Edge edge : source.getAdjacencyList()) {
            Vertex v = edge.getTargetVertex();
            if(!v.isVisited() && hasPath(v, target)) {
                return true;
            }
        }
        return false;
    }
}
