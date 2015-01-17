package com.fun.algorithms.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * Sample:
 *   a
 *  / \
 * b   c
 *    /\
 *   d  e
 * preorder:    abcde
 * inorder:     badce
 * postorder:   cdeca
 */
public class TreeBuilder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        if (preorder.length != inorder.length) return null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return doBuildTree(preorder, inorder, 0, 0, inorder.length-1, map);
    }

    private TreeNode doBuildTree(int[] preorder, int[] inorder, int i, int s, int e,
                                 Map<Integer, Integer> map) {
        if (s > e) return null;

        TreeNode root = new TreeNode(preorder[i++]);
        int index = map.get(root.val);

        root.left = doBuildTree(preorder, inorder, i, s, index-1, map);
        root.right = doBuildTree(preorder, inorder, i, index+1, e, map);

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) return null;
        if (postorder.length != inorder.length) return null;

        return null;
    }
}
