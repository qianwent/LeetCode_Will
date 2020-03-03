package com.book.algorithm4thedition.chapter4.a4_3;

import com.book.algorithm4thedition.chapter2.In;
import com.book.algorithm4thedition.chapter4.Bag;
import com.book.algorithm4thedition.chapter4.Graph;

/**
 * Connected Components - ��ͨ����
 * DFS��Ӧ��֮һ���������������vertex���ܹ�һֱ����DFS recurrence�ģ���˵������ͨ�ģ�����ܺ����
 * ֱ������DFS��˵��ĳһ����ͨ�Ѿ��ҵ�����Ȼ��һ��forѭ�����ظ��Ѻ�������marked�ĵ��ٹ�һ�飬��֪�������Ƿ��������㷨���ԸĽ�
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
         * ͬһ����ͨ�������count��һ�µģ������Ѿ�����ȷ�ˣ�������������������԰����ж��������Ƿ���ͨ
         * ��Ҳ�Ƕ��㷨�������ѧ��һ�ֿ��죬��ΰ�ĳ��ֵ��Ϊһ���������;��ֵ����������˼άģʽ
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
