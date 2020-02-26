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
     * ע�Ⱑ����������ʱ��˵�����������ģ��ԸߵĽ��Ϊ��׼��Ҳ���ǲ���h
     * û��ת��֮ǰ��h<x������h����x��Ҫ�ﵽ��Ч����ת��֮�󣬴ﵽ����ƽ�⣬��xҪ����h������return x����ΪxҪ��Ϊ�µĸ����
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
        root.color = BLACK;//�������Ϊû�м�ָ������������Ҫ���BLACK
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, RED, 1);
        }
        /**
         * ���ǻ�����ͼ�ȽϺ������Щ�ݹ��߼�������С�ṹ����
         * �ݹ�Ҳ����һ����С�ṹ���߼�
         * BST���ص���ǣ���ӽ���ʱ����ʵ���Ǹ���ĳ���������ӽ��������ӽ�㣬Ҫ����Ϥ�������
         */
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {// �ⲿ�ֵ��߼���BST��һ�µģ����Ժ���������ϻ���BST��ֻ�����Ǹ��������˸������
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
