package com.book.algorithm4thedition.chapter4.a4_3;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Graph;

public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In().readAllInts());
        TwoColor twoColor = new TwoColor(G);
        System.out.println(twoColor.isTwoColorable);
    }
}
