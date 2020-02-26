package com.book.algorithm4thedition.chapter3.a3_3;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Note: don't get confused with binary search tree and heap-ordered binary tree，they are for different purposes, hence definitions are bit different
 * heap-ordered binary tree is for sorting topic, hence one implementation for priority queue
 * binary search tree is for searching topic
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void put(Key key, Value value) {
        // search for key. update value if found; grow table if new
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        // think about why this logic is not correct... the definition of floor here is the closest node right side of the current node, if not found, use current node
//        if (cmp < 0) {
//            return floor(x.left, key);
//        } else if (cmp > 0) {
//            return floor(x.right, key);
//        } else {
//            return x;
//        }
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        // Return Node containing key of rank k
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public static void main(String[] args) {
        BST<String, String> bst = new BST();
        bst.put("S", "7");
        bst.put("E", "3");
        bst.put("X", "8");
        bst.put("A", "1");
        bst.put("R", "6");
        bst.put("C", "2");
        bst.put("H", "4");
        bst.put("M", "5");
        System.out.println(bst.size());
        System.out.println(bst.size(bst.root.left));
        System.out.println(bst.root.right.key);
        System.out.println(bst.root.left.right.left.right.key);
        System.out.println(bst.rank("H"));
        System.out.println(bst.select(1));
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        // return number of keys less than x.key in subtree rooted at x.
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * 用   C
     * A /
     *  \B 这个结构来理解，A会被delete，然后C.left = B
     */
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            /**
             * 怎么理解这个delete过程
             * 对比图3.2.13
             * 当找到这个要删除的键时，先用一个临时的t node保存起来
             * 然后这个命中的x就要先被delete，并且改成之前x右边子树的最小节点，这个很好理解
             * 然后x.right运行一个deleteMin，意思是把新的x先从旧的子树上拿走，并且这个x.right的左子树必须再重新连好，
             * 因为刚刚min已经拿走，结构被破坏，deleteMin正好可以满足，删除最左边的节点，同时返回输入进来的节点
             * 这样新的x和右边就链接好了
             * 和左边就非常简单了，因为左边没有动过
             */
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);// 这一步确实是最难的
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 中序遍历的思想出来了 inorder traversal
     */
    private void print(Node x) {
        if (x == null) {
            return;
        }
        /**
         * recursive还是不熟悉，需要多想
         */
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * 以root为起始点开始inorder traversal
     */
    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new PriorityQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        /**
         * 发现没，这个和print结构一致，都是左边scan完之后，再中间，然后右边
         */
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if (cmpLo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmpLo <= 0 && cmpHi >= 0) {
            queue.add(x.key);
        }
        if (cmpHi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }
}
