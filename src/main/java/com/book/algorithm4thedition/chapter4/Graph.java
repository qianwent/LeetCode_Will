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
     * ����������������������graph���ο�P524
     * ��ʼ�����graph֮��vertex�����ȹ̶���Ȼ��v�Ǵ�0-12����Ӧ��adj�����ÿһ��index��������Ȼ�Ǽ��ˣ��Է������
     * 0��1 2 5 6����������adj[0]���Bag object������������� 6 2 1 5�⼸��node
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
            System.out.print(i + " "); // �������Ҫ���������ĳ��vertex��ȫ���ڱߣ��ͱ���Ҫ���Bag implements Iterable
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
