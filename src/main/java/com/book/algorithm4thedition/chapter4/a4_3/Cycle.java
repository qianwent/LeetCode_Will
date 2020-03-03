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
                 * ��һ��Ϊʲô��v��������u������ͼ��ֻ����������ľ������ˣ������u���൱��һֱ��s
                 * ��������ж��Ƿ�ջ���ʱ����ʵ���ڱȽ�s�����һ�����Ƿ�����
                 * w�����һ��dfs��϶���s���������⣬��uʵ��������һ�㴫������v������һ��������ȷ��v��
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
