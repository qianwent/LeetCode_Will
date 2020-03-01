package com.book.algorithm4thedition.chapter4.a4_1;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Graph;
import com.book.algorithm4thedition.chapter4.Stack;

public class DepthFirstPaths {

    private boolean[] marked; // has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source vertex

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    /**
     * 目前这个dfs算法不能把edgeTo[5]标成0，因为当进入G.adj(5)的时候，0这个点已经被marked了
     * TODO：所以不急，这个算法还是很初级的，只是为了展示DFS，这里也并没有说需要找到最短还是最长路径
     * 路径还是跟构造时候的顺序相关的
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 需要返回的是一个path，也就是一串数字，那就用预先定义好的一个Stack
     * 这也是在培养什么时候用FIFO或者FILO
     * 这里我们期望输出的，比如pathTo(5)，应该是0 2 3 5
     * 而起始的v就是5，显然应该用栈比较符合
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
        DepthFirstPaths dfp = new DepthFirstPaths(graph, 0);
        System.out.println(dfp.pathTo(5));
        System.out.println(dfp.pathTo(4));
    }
}
