package com.leetcode.tree.datastructure;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree
 * How to create it
 * How to traverse it 遍历
 */
public class BinaryTreeTraverse {

    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private class Node {
        Node leftNode;
        Node rightNode;
        int value;
        Node(int value) {
            this.leftNode = null;
            this.rightNode = null;
            this.value = value;
        }
    }

    List<Node> nodeList = new LinkedList<>();

    public List<Node> createBinaryTree() {
        for (int i=0; i<array.length; i++) {
            nodeList.add(new Node(array[i]));
        }
        //利用二叉树的数学特性，构建父节点---这里要有一个思维的转变，数据已经有了，都在list里面
        //关键是怎样写到定义好的tree里面
        for (int parentIndex=0; parentIndex<array.length/2-1; parentIndex++) {
            nodeList.get(parentIndex).leftNode = nodeList.get(parentIndex*2+1);
            nodeList.get(parentIndex).rightNode = nodeList.get(parentIndex*2+2);
        }
        //last parent
        //这里又涉及二叉树的特性，注意，这目前只适用于二叉树
        //第一个点顶点，奇数，如果有偶数个点的话，那最后一个节点一定是左子树
        //而如果是偶数个点的话，最后一个节点必然是右子树
        //没什么神奇的，既然这么定义了，而且又是二分而来的，这些性质就自然而然存在了
        int lastParentIndex = array.length/2-1;
        nodeList.get(lastParentIndex).leftNode = nodeList.get(lastParentIndex*2+1);
        if (array.length%2 == 1) {
            nodeList.get(lastParentIndex).rightNode = nodeList.get(lastParentIndex*2+2);
        }

        return nodeList;

    }

    //preorder traverse
    //注意这里，一开始的想法是，直接把整个list作为参数传进方法内
    //再仔细想想，传一个node才更符合实际情况，不管是搜索还是插入删除，都是pointer在移动，指到的总是一个节点
    //更普遍的是，传入某个节点，可以对节点之后进行遍历，而不是限定于总是遍历整个list
//    public void preOrderTraverse(List<Node> list) {
    public void preOrderTraverse(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrderTraverse(node.leftNode);//TODO 递归调用的精华，从这个例子可以清楚地看到
        //直到把左边都遍历完，才回到右边---这个写得模糊了点，具体看这个网站的图解，一目了然
        //https://www.cnblogs.com/polly333/p/4740355.html
        //基本思想：先访问根结点，再先序遍历左子树，最后再先序遍历右子树即根—左—右。
        preOrderTraverse(node.rightNode);
    }

    public void inOrderTraverse(Node node) {
        if (node == null) return;
        //依旧看上面的博客的图解，这个就稍微烧点脑子了，但是把图解各个节点走过一遍之后，
        //对递归的理解似乎更深刻了一些
        //大致流程：开始一个root node，先找左节点，如果有继续找左节点
        //如果左节点为null，这个递归的方程结束，同时输出这个节点的value，因为至此，最左边已经找到了
        //如果还有右节点，则继续找下去，对于这个右节点，继续找左节点---有点绕是不是，没办法，规则就是这么定的
        //TODO：图解下写了这么一句：基本思想：先中序遍历左子树，然后再访问根结点，最后再中序遍历右子树即左—根—右。
        //根据这个基本思想，理解进一步加深，当左节点无法找到之后，就回到这个根节点（注意，不是往上一层实为当前一层）
        //把根节点的value输出，再找右节点，所以称为“左—根—右”。
        inOrderTraverse(node.leftNode);
        System.out.print(node.value + " ");
        inOrderTraverse(node.rightNode);
    }

    public void postOrderTraverse(Node node) {
        if (node == null) return;
        postOrderTraverse(node.leftNode);
        postOrderTraverse(node.rightNode);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTraverse binaryTreeTraverse = new BinaryTreeTraverse();
        Node root = binaryTreeTraverse.createBinaryTree().get(0);
        System.out.println("Preorder traversal");
        binaryTreeTraverse.preOrderTraverse(root);
        System.out.println();
        System.out.println("Inorder traversal");
        binaryTreeTraverse.inOrderTraverse(root);
        System.out.println();
        System.out.println("Postorder traversal");
        binaryTreeTraverse.postOrderTraverse(root);
    }

}
