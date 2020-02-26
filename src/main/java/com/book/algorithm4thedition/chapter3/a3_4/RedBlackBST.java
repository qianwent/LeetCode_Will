package com.book.algorithm4thedition.chapter3.a3_4;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private Node root;

    /**
     * BST node with color bit
     */
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;
        int N;

        public Node(Key key, Value value, boolean color, int n) {
            this.key = key;
            this.value = value;
            this.color = color;
            N = n;
        }

    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 注意啊，在左旋的时候，说明红键是右倾的，以高的结点为基准，也就是参数h
     * 没有转换之前，h<x，但是h高于x，要达到的效果是转换之后，达到树的平衡，即x要高于h，并且return x，因为x要成为新的根结点
     *
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;// the link of h could be left or right, color could be red or black, so just to assign the original color to x
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);// h.left never change, so till this step, h's left and right both confirmed
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;// the link of h could be left or right, color could be red or black, so just to assign the original color to x
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);// h.left never change, so till this step, h's left and right both confirmed
        return x;
    }

    private int size() {
        return size(root);
    }

    /**
     * note: when we construct the BST, the N of each node is already confirmed, don't be confused
     */
    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    private void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;//根结点因为没有键指向它，所以需要设成BLACK
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, RED, 1);
        }
        /**
         * 还是画个简图比较好理解这些递归逻辑，用最小结构来画
         * 递归也就是一个最小结构的逻辑
         * BST的特点就是，添加结点的时候，其实就是更新某个结点的左子结点或者右子结点，要很熟悉这个概念
         */
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {// 这部分的逻辑和BST是一致的，所以红黑树本质上还是BST，只是我们给它赋予了更多规则
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
//            h.key = key;//redundant
            h.value = value;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColor(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public static void main(String[] args) {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("A", "1");
        redBlackBST.put("C", "2");
        redBlackBST.put("E", "3");
        redBlackBST.put("H", "4");
        redBlackBST.put("L", "5");
        redBlackBST.put("M", "6");
        redBlackBST.put("P", "7");
        redBlackBST.put("R", "8");
        redBlackBST.put("S", "9");
        redBlackBST.put("X", "10");
        System.out.println(redBlackBST.root.key);
        System.out.println(redBlackBST.root.left.key);
        System.out.println(redBlackBST.root.right.key);
    }
}
