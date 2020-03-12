package com.book.algorithm4thedition.chapter4.a4_9;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.IndexMinPQ;
import com.book.algorithm4thedition.chapter4.Stack;
import com.book.algorithm4thedition.chapter4.directedweightededgedatatype.DirectedEdge;
import com.book.algorithm4thedition.chapter4.directedweightededgedatatype.EdgeWeightedDigraph;

/**
 * 之前在BreathFirstPaths里提到过后续会有更深入的算法用于最短路径
 * 就是这个了Dijkstra Shortest Path TODO 这个和bfp里的还是很不一样的
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    /**
     * 1st input: 8 15 4 5 0.35 5 4 0.35 4 7 0.37 5 7 0.28 7 5 0.28 5 1 0.32 0 4 0.38 0 2 0.26 7 3 0.39 1 3 0.29 2 7 0.34 6 2 0.40 3 6 0.52 6 0 0.58 6 4 0.93
     * 2nd input: any vertex from above
     */
    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In().readAllDoubles());
        int s = new In().readInt();
        DijkstraSP dijkstraSP = new DijkstraSP(G, s);
        for (int t = 0; t < G.V(); t++) {
            if (dijkstraSP.hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", s, t, dijkstraSP.distTo(t));
                for (DirectedEdge e : dijkstraSP.pathTo(t)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, t);
            }
        }
    }
}
