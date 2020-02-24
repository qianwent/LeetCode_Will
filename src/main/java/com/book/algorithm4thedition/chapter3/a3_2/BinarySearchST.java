package com.book.algorithm4thedition.chapter3.a3_2;

/**
 * note, here we use two separate arrays for key and value
 * example:
 * keys: S E A R C H
 * vals: 0 1 2 3 4
 * 虽然这里key是字母，但是不要混淆，这两个数组里index仍然是数字0-N，index的概念是不变的，灵活的是怎么样用这些数组
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }

    }

    private boolean isEmpty() {
        return N == 0;
    }

    /**
     * algorithm 3.2 continued
     * Binary search in an ordered array (iterative)
     */
    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    /**
     * Recursive binary search
     * think about why this is same as the iterative way
     */
    public int rank(Key key, int lo, int hi) {
        if (lo > hi) {
            return lo;// don't forget this step
        }
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }

        int i = rank(key);
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = N; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        N--;
    }
}
