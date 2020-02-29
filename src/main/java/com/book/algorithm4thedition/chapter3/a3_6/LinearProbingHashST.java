package com.book.algorithm4thedition.chapter3.a3_6;

public class LinearProbingHashST<Key, Value> {

    private int N; // number of key-value pairs in the table
    private int M; // size of linear-probing table
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        this(997);
        M = 997;
    }

    public LinearProbingHashST(int cap) {
        keys = (Key[]) new Object[cap];
        values = (Value[]) new Object[cap];
    }

    private int hash(Key key) {
//        if (key.equals("A") || key.equals("H")) {
//            return 1;
//        }
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public void put(Key key, Value value) {
        if (N >= M / 2) {
            resize(2*M);
        }
        int i;
        /**
         * if hash equals, but key different, then scan next indexes, till the key value is null
         * if the key already exists, then simply update the value
         */
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, String> st = new LinearProbingHashST<>();
        st.put("A", "2");
        st.put("H", "3");
    }
}
