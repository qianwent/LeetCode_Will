package com.book.algorithm4thedition.chapter4.a4_4;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Bag;
import com.book.algorithm4thedition.chapter4.Digraph;

/**
 * Reachability in digraphs
 * 多点可达性的一个重要应用就是Java内存垃圾收集
 * mark-and-sweep garbage collection
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * 1st input: 13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6
     * 2nd input: 1 2 6
     */
    public static void main(String[] args) {
        Digraph G = new Digraph(new In().readAllInts());

        Bag<Integer> sources = new Bag<>();
        int[] sourceInts = new In().readAllInts();
        for (int i : sourceInts) {
            sources.add(i);
        }

        DirectedDFS reachable = new DirectedDFS(G, sources);

        for (int v = 0; v < G.V(); v++) {
            if (reachable.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }
}
