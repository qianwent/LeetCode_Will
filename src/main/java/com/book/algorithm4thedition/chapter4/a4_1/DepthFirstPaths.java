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
     * Ŀǰ���dfs�㷨���ܰ�edgeTo[5]���0����Ϊ������G.adj(5)��ʱ��0������Ѿ���marked��
     * TODO�����Բ���������㷨���Ǻܳ����ģ�ֻ��Ϊ��չʾDFS������Ҳ��û��˵��Ҫ�ҵ���̻����·��
     * ·�����Ǹ�����ʱ���˳����ص�
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
     * ��Ҫ���ص���һ��path��Ҳ����һ�����֣��Ǿ���Ԥ�ȶ���õ�һ��Stack
     * ��Ҳ��������ʲôʱ����FIFO����FILO
     * ����������������ģ�����pathTo(5)��Ӧ����0 2 3 5
     * ����ʼ��v����5����ȻӦ����ջ�ȽϷ���
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
