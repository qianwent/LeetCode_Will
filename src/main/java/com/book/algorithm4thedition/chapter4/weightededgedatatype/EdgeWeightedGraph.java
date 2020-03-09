package com.book.algorithm4thedition.chapter4.weightededgedatatype;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Bag;

public class EdgeWeightedGraph {

    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Edge>[] adj; // adjacency lists

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            addEdge(new Edge(in.readInt(), in.readInt(), in.readDouble()));
        }
    }

    public EdgeWeightedGraph(double[] ds) {
        this((int) ds[0]);
        int E = (int) ds[1];
        for (int i = 0; i < 3 * E; i += 3) {
            int v = (int) ds[i + 2];
            int w = (int) ds[i + 3];
            double weight = ds[i + 4];
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    b.add(e);
                }
            }
        }
        return b;
    }
}
