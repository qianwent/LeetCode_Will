package com.book.algorithm4thedition.chapter4;

import com.book.algorithm4thedition.chapter2.In;

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    /**
     * s means the source of the graph
     */
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
//            dfs(G, w);// need to check if the vertex is already marked
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int[] ints = new In().readAllInts();
        Graph graph = new Graph(ints);
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        System.out.println(dfs.count());
        DepthFirstSearch dfs1 = new DepthFirstSearch(graph, 7);
        System.out.println(dfs1.count());
        DepthFirstSearch dfs2 = new DepthFirstSearch(graph, 9);
        System.out.println(dfs2.count());
    }
}
