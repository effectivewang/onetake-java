package com.fun.algorithms.trees;

import java.util.*;

/**
 * Helper for constructing {@link com.fun.algorithms.trees.TreeNode}.
 */
public class BinaryTreeHelper {
    private static final int NULL = '#';
    public int[] save(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        levelTraversal(queue, list);

        int[] array = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            array[i] = list.get(i);

        return array;
    }

    private void levelTraversal(Queue<TreeNode> level, List<Integer> list) {
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        for (TreeNode node : level) {
            if (node.left != null) {
                nextLevel.add(node.left);
                list.add(node.val);
            } else {
                list.add(NULL);
            }

            if (node.right != null) {
                nextLevel.add(node.right);
                list.add(node.val);
            } else {
                list.add(NULL);
            }
        }

        if (nextLevel.size() > 0) {
            levelTraversal(nextLevel, list);
        }
    }
}
