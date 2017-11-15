package com.leetcode.tree.easy;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

 The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs
 that don't affect the one-to-one mapping relationship between the string and the original binary tree.

 Example 1:
 Input: Binary tree: [1,2,3,4]
 1
 /   \
 2     3
 /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".
 Example 2:
 Input: Binary tree: [1,2,3,null,4]
 1
 /   \
 2     3
 \
 4

 Output: "1(2()(4))(3)"

 Explanation: Almost the same as the first example,
 except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringfromBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {this.val = value;}
    }
    public String tree2str(TreeNode t) {
        //TODO：这种变种的算法，还是有点绕的，得多思考一下
        if(t == null) return "";
        if(t.left == null && t.right == null) return t.val + "";
        if(t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        //这个是general expression，为什么这么说，对比com.leetcode.tree.datastructure.BinaryTreeTraverse
        //里的preOrderTraverse方法，立刻就发现这是preorder的定式，即 根—左—右
        //只是一开始可能对if(t.right == null)这个有一些疑问
        //实际上这是题目的限制，即总会有左节点，即使是null，也需要输出()，
        //而对于右节点却没有这个限制
        //所以按照这种需求的变化来对算法进行变种，实际上也在考察队逻辑的熟练度
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    //错误的思路，主要是针对括号
    /*private String preOderTraverse(TreeNode t, String s) {
        if (t == null) return "";
        s += t.val + "(";
        preOderTraverse(t.left, s);
        preOderTraverse(t.right, s);
        s += ")";
        return s;
    }*/
}
