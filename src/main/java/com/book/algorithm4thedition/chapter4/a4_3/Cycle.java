package com.book.algorithm4thedition.chapter4.a4_3;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Graph;

public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
//                dfs(G, w, u);
                /**
                 * 想一想为什么是v，而不是u，画张图，只包含三个点的就明了了，如果传u，相当于一直是s
                 * 那最后在判断是否闭环的时候，其实是在比较s和最后一个点是否相连
                 * w在最后一层dfs里肯定是s，这个好理解，而u实际上是上一层传进来的v，这样一来就能明确传v了
                 */
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    /**
     * 13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3
     */
    public static void main(String[] args) {
        Graph G = new Graph(new In().readAllInts());
        Cycle c = new Cycle(G);
        System.out.println(c.hasCycle);
    }
}
