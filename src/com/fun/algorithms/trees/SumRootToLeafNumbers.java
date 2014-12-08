package com.fun.algorithms.trees;

import com.fun.algorithms.Assert;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    public void run() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        Assert.areEquals(25, sumNumbers(node));
    }

    public int sumNumbers(TreeNode node) {
        if (node == null) return 0;

        Queue<Integer> queue = new ArrayDeque<Integer>();
        preOrder(node, node.val, queue);

        int sum = 0;
        for (int i : queue) {
            sum += i;
        }
        return sum;
    }

    public void preOrder(TreeNode node, int parent, Queue<Integer> queue) {
        if (node.left == null && node.right == null) {
            queue.add(parent);
        }

        if (node.left != null) {
            preOrder(node.left, parent * 10 + node.left.val, queue);
        }
        if (node.right != null) {
            preOrder(node.right, parent * 10 + node.right.val, queue);
        }
    }
}
