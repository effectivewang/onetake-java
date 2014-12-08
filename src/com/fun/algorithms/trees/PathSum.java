package com.fun.algorithms.trees;

import com.fun.algorithms.Assert;

import java.util.*;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *      5
 *     / \
 *    4   8
 *    /  / \
 *   11 13  4
 *  /  \     \
 * 7    2     1
 *
 */
public class PathSum {
    public void run() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Assert.areEquals(true, hasPathSum(root, 22));

        pathSum(root, 22);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return preOrder(root, sum);
    }

    private boolean preOrder(TreeNode parent, int sum) {
        if (parent == null) {
            return false;
        }
        if (parent.left == null && parent.right == null) {
            return parent.val == sum;
        }

        return preOrder(parent.left, sum - parent.val) || preOrder(parent.right, sum - parent.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        if (root == null) return arrayList;

        preOrder(root, sum, new LinkedList<Integer>(), arrayList);

        return arrayList;
    }

    private void preOrder(TreeNode parent, int sum, List<Integer> array, ArrayList<List<Integer>> arrayList) {
        if (parent == null) {
            return;
        }
        if (parent.left == null && parent.right == null) {
            if (sum == parent.val) {
                array.add(parent.val);
                arrayList.add(array);
            }
            return;
        }

        array.add(parent.val);
        List<Integer> leftArray = new ArrayList<Integer>(array);
        List<Integer> rightArray = new ArrayList<Integer>(array);

        preOrder(parent.left, sum - parent.val, leftArray, arrayList);
        preOrder(parent.right, sum - parent.val, rightArray, arrayList);
    }
}
