package com.book.algorithm4thedition.chapter4.directedweightededgedatatype;

import com.book.algorithm4thedition.chapter4.Bag;

public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj; // adjacent lists

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(double[] ds) {
        this((int) ds[0]);
        int E = (int) ds[1];
        for (int i = 0; i < 3 * E; i += 3) {
            int v = (int) ds[i + 2];
            int w = (int) ds[i + 3];
            double weight = ds[i + 4];
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }
}
