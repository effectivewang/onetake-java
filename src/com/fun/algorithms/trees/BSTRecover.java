package com.fun.algorithms.trees;

import com.fun.algorithms.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class BSTRecover {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void run() {
        BSTValidator validator = new BSTValidator();

        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left = new TreeNode(10);
        Assert.areEquals(false, validator.isValidBST(root));

        recoverTree(root);
        Assert.areEquals(true, validator.isValidBST(root));
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        inorder(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode parent) {
        if (parent == null) return;

        inorder(parent.left);

        if (first == null && prev.val >= parent.val) {
            first = prev;
        }
        if (first != null && prev.val >= parent.val) {
            second = prev;
        }
        prev = parent;

        inorder(parent.right);
    }
}
