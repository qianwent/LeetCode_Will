package com.leetcode.tree.easy;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
     5
   /   \
 2     13

 Output: The root of a Greater Tree like this:
     18
   /   \
 20     13
 */
/**
 * Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
二叉搜索树的特点是，小的值在左边，大的值在右边，即
     X
   /   \
 <X     >X
这样的结构有一个好处是很容易获得最大值（Maximum）、最小值（minimum）、某元素的前驱（Precursor）、某元素的后继（Successor）。

最大值：树的最右节点。

最小值：树的最左节点。

某元素前驱：左子树的最右。

某元素的后继：右子树的最左。
 */
public class ConvertBSTtoGreaterTree {

    int sum = 0;

    //再次明确：程序调用自身的编程技巧称为递归（ recursion）
    //而在树相关的算法中，递归是非常普遍的
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;//TODO：这里注意，现在还是有点懵懂
        sum = cur.val;
        convert(cur.left);
    }

}
