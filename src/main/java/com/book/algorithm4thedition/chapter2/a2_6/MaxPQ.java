package com.book.algorithm4thedition.chapter2.a2_6;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;// heap ordered complete binary tree
    private int N = 0;// in pq[1..N] with pq[0] unused

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N); // insert at the end of the queue
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {// think about this logic, should be straight forward
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * this sink method could also be used to construct a heap-ordered binary tree
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            /**
             * think about why less(j, j + 1) is used here, we already know each node is larger than both child nodes,
             * so need to make sure the larger child node swims, otherwise ordered will be broke
             * then think about why no such logic used in swim?
             * because if the node need to swim, meaning this node is larger than the upper node,
             * while the upper node already larger than the other child node
             * so the new swim node must be larger than the other child node, hence no need to double check with less method
             */
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * add additional parameter N to the method, as N under this class is 0 if we don't call insert
     * to construct with sink, we don't want to use insert method
     */
    private void sink_v2(int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        /**
         * 运行完之后就发现，构造出来的二叉堆的里面元素的排列是和插入的顺序有关系的，而且和书上的不一样，但依然是一个有序的二叉堆
         * 这样我们就生成了一个有序的二叉堆，需要用到辅助的swim方法
         */
        MaxPQ maxPQ = new MaxPQ(7);
        maxPQ.insert("A");
        maxPQ.insert("O");
        maxPQ.insert("N");
        maxPQ.insert("P");
        maxPQ.insert("R");
        maxPQ.insert("S");
        maxPQ.insert("T");
        System.out.println("after insert...");
        for (int i = 1; i < maxPQ.size() + 1; i++) {
            System.out.print(maxPQ.pq[i]);
        }
        System.out.println();
        String[] strings = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        int N = strings.length;
        MaxPQ maxPQ2 = new MaxPQ(N + 1);
        for (int i = 1; i < N + 1; i++) {
            maxPQ2.pq[i] = strings[i - 1];
            System.out.print(maxPQ2.pq[i] + " ");
        }
        System.out.println();
        System.out.println("after sink...");
        int lt = N / 2;
        while (lt >= 1) {
            maxPQ2.sink_v2(lt--, N);
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.print(maxPQ2.pq[i] + " ");
        }

        System.out.println();
        System.out.println("maxPQ1");
        MaxPQ maxPQ1 = new MaxPQ(N + 1);
        /**
         * X T S P L R A M O E E
         */
        for (int i = 1; i < N + 1; i++) {
            maxPQ1.pq[i] = strings[i - 1];
            System.out.print(maxPQ1.pq[i] + " ");
        }
        /*
        Note: the first while logic is wrong...
        because when using swim to construct the array, we are actually scan from the left
        and N has to be increased...
         */
//        int rt = N;
//        while (rt > 1) {
//            maxPQ1.swim(rt--);
//        }
        int rt = 1;
        while (rt <= N) {
            maxPQ1.swim(rt++);
        }
        System.out.println();
        System.out.println("after swim...");
        /**
         * X S T P L R A M O E E, note the structure of heap-ordered binary tree is not unique
         */
        for (int i = 1; i < N + 1; i++) {
            System.out.print(maxPQ1.pq[i] + " ");
        }
    }
}
