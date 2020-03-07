package com.book.algorithm4thedition.chapter4;

import com.book.algorithm4thedition.chapter2.In;

public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        /**
         * 这种再添加数组记录状态的技巧还是生疏的
         */
        onStack[v] = false;
    }

    private boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    /**
     * 有意思，第一个数字V要确保大于最大点V的值
     * 6 4 0 5 5 4 4 3 3 5
     */
    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In().readAllInts());
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        directedCycle.cycle().forEach((v)-> System.out.print(v + " "));
    }
}
