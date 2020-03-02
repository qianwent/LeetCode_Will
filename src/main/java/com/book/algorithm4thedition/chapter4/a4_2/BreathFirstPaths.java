package com.book.algorithm4thedition.chapter4.a4_2;

import com.book.algorithm4thedition.chapter1.a1_3.Queue;
import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Graph;
import com.book.algorithm4thedition.chapter4.Stack;

public class BreathFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreathFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     * 从bfs就能看出，这是为最短路径而准备的，但是这还只是开始，真正的最短路径算法还在后续章节
     */
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * same as in DepthFirstPath
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    /**
     * input: 6 8 0 5 2 4 2 3 1 2 0 1 3 4 3 5 0 2
     */
    public static void main(String[] args) {
        int[] ints = new In().readAllInts();
        Graph graph = new Graph(ints);
        BreathFirstPaths bfp = new BreathFirstPaths(graph, 0);
        System.out.println(bfp.pathTo(5));
        System.out.println(bfp.pathTo(4));
    }
}
