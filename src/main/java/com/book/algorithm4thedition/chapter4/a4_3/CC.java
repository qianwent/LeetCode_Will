package com.book.algorithm4thedition.chapter4.a4_3;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Bag;
import com.book.algorithm4thedition.chapter4.Graph;

/**
 * Connected Components - 连通分量
 * DFS的应用之一，不断往深入查找vertex，能够一直进入DFS recurrence的，就说明是连通的，这个很好理解
 * 直到跳出DFS，说明某一个连通已经找到。虽然第一个for循环会重复把后续所有marked的点再过一遍，不知道后续是否有其他算法可以改进
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        /**
         * 同一个连通分量里的count是一致的，现在已经很明确了，所以这个额外的数组可以帮助判断两个点是否连通
         * 这也是对算法设计里数学的一种考察，如何把某个值归为一个特殊的用途，值得培养这种思维模式
         */
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    /**
     * 13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3
     */
    public static void main(String[] args) {
        Graph G = new Graph(new In().readAllInts());
        CC cc = new CC(G);

        int M = cc.count;
        System.out.println(M + " components");

        Bag<Integer>[] components;
        components = new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
