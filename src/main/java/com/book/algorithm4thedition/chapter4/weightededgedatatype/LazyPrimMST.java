package com.book.algorithm4thedition.chapter4.weightededgedatatype;

import com.book.algorithm4thedition.chapter1.a1_3.Queue;
import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.MinPQ;

public class LazyPrimMST {

    private double weight;       // total weight of MST
    private Queue<Edge> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private MinPQ<Edge> pq;      // edges with one endpoint in tree

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     */
    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)     // run Prim from all vertices to
            if (!marked[v]) prim(G, v);     // get a minimum spanning forest
    }

    // run Prim's algorithm
    private void prim(EdgeWeightedGraph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {                        // better to stop when mst has V-1 edges
            Edge e = pq.delMin();                      // smallest edge on pq
            int v = e.either(), w = e.other(v);        // two endpoints
            assert marked[v] || marked[w];
            if (marked[v] && marked[w]) continue;      // lazy, both v and w already scanned
            mst.enqueue(e);                            // add e to MST
            weight += e.getWeight();
            if (!marked[v]) scan(G, v);               // v becomes part of tree
            if (!marked[w]) scan(G, w);               // w becomes part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(EdgeWeightedGraph G, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     */
    public double weight() {
        return weight;
    }

    /**
     * 8 16 4 5 .35 4 7 .37 5 7 .28 0 7 .16 1 5 .32 0 4 .38 2 3 .17 1 7 .19 0 2 .26 1 2 .36 1 3 .29 2 7 .34 6 2 .40 3 6 .52 6 0 .58 6 4 .93
     */
    public static void main(String[] args) {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(new In().readAllDoubles());
        LazyPrimMST lazyPrimMST = new LazyPrimMST(ewg);
        for (Edge e : lazyPrimMST.edges()) {
            System.out.println(e);
        }
        System.out.println(lazyPrimMST.weight());
    }
}
