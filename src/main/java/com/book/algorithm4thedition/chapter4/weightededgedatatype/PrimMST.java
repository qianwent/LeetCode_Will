package com.book.algorithm4thedition.chapter4.weightededgedatatype;

import com.book.algorithm4thedition.chapter1.a1_3.Queue;
import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.IndexMinPQ;

public class PrimMST {

    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Double> pq;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     */
    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        for (int v = 0; v < G.V(); v++)      // run from each vertex to find
            if (!marked[v]) prim(G, v);      // minimum spanning forest

    }

    // run Prim's algorithm in graph G, starting from vertex s
    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    // scan vertex v
    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;         // v-w is obsolete edge
            if (e.getWeight() < distTo[w]) {
                distTo[w] = e.getWeight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     */
    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     */
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.getWeight();
        return weight;
    }

    /**
     * 8 16 4 5 .35 4 7 .37 5 7 .28 0 7 .16 1 5 .32 0 4 .38 2 3 .17 1 7 .19 0 2 .26 1 2 .36 1 3 .29 2 7 .34 6 2 .40 3 6 .52 6 0 .58 6 4 .93
     */
    public static void main(String[] args) {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(new In().readAllDoubles());
        PrimMST primMST = new PrimMST(ewg);
        for (Edge e : primMST.edges()) {
            System.out.println(e);
        }
        System.out.println(primMST.weight());
    }
}
