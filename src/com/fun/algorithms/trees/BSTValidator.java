package com.fun.algorithms.trees;

import com.fun.algorithms.Assert;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class BSTValidator {
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        Assert.areEquals(false, isValidBST(root));

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        Assert.areEquals(false, isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        return checkValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean checkValid(TreeNode node, int max, int min) {
        if (node == null) {
            return true;
        }
        if (node.val > max || node.val < min) {
            return false;
        }
        if (node.val == Integer.MIN_VALUE && node.left != null) {
            return false;
        }
        if (node.val == Integer.MAX_VALUE && node.right != null) {
            return false;
        }

        return checkValid(node.left, node.val-1, min) && checkValid(node.right, max, node.val+1);
    }
}
