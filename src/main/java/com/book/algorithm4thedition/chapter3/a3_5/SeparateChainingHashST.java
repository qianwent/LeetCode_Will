package com.book.algorithm4thedition.chapter3.a3_5;

import com.book.algorithm4thedition.chapter3.a3_1.SequentialSearchST;

/**
 * Hashing with separate chaining
 */
public class SeparateChainingHashST<Key, Value> {

    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        // create M linked lists
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, String> st = new SeparateChainingHashST();
        st.put("A", "1");
        System.out.println(st.get("A"));
        System.out.println(st.hash("A"));
        st.put("E", "2");
        System.out.println(st.get("E"));
        System.out.println(st.hash("E"));
        st.put("X", "3");
        System.out.println(st.get("X"));
        System.out.println(st.hash("X"));
    }
}
