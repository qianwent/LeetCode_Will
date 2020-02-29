package com.book.algorithm4thedition.chapter4;

import com.book.algorithm4thedition.chapter2.In;

public class Graph {

    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(int[] ints) {
        this(ints[0]);
        int E = ints[1];
        for (int i = 0; i < 2 * E; i += 2) {
            int v = ints[i + 2];
            int w = ints[i + 3];
            addEdge(v, w);
        }
    }

    /**
     * 从这个方法来理解这个抽象的graph，参考P524
     * 初始化这个graph之后，vertex个数先固定，然后v是从0-12，对应于adj数组的每一个index，这里显然是简化了，以方便理解
     * 0和1 2 5 6相连，所以adj[0]这个Bag object里面就是相连的 6 2 1 5这几个node
     */
    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        /**
         * this way only one input
         * 13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3
         */
        int[] ints = new In().readAllInts();
        for (int i : ints) {
            System.out.println(i);
        }
        Graph graph = new Graph(ints);
        System.out.println(graph.E);
        for (Integer i : graph.adj(0)) {
            System.out.print(i + " "); // 这里如果要能依次输出某个vertex的全部邻边，就必须要这个Bag implements Iterable
        }
        System.out.println(graph.adj(0).iterator().hasNext());
        System.out.println();
        /**
         * this way need to type in each int one by one
         */
//        Graph graph = new Graph(new In());
//        System.out.println(graph.E);
    }
}
