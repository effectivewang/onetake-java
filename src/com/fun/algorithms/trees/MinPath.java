package com.fun.algorithms.trees;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinPath {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return minDepth(root, 0);
    }

    private int minDepth(TreeNode parent, int depth) {
        if (parent == null) return Integer.MAX_VALUE;
        else if (parent.left == null && parent.right == null) return depth;

        return Math.min(minDepth(parent.left, depth + 1), minDepth(parent.right, depth + 1));
    }
}
