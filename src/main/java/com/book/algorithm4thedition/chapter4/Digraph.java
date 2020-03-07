package com.book.algorithm4thedition.chapter4;

import com.book.algorithm4thedition.chapter2.In;

public class Digraph {

    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Digraph(int[] ints) {
        this(ints[0]);
        int E = ints[1];
        for (int i = 0; i < 2 * E; i += 2) {
            int v = ints[i + 2];
            int w = ints[i + 3];
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 注意adj数组的最大index要确保能容下最大结点的值
     * 比如只有0 3 4 5这几个点构成的图，V至少得是6
     */
    private void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
