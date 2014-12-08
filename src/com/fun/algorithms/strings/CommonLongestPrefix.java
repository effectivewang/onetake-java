package com.fun.algorithms.strings;

import com.fun.algorithms.Assert;

import java.util.ArrayList;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * {@linkplain https://oj.leetcode.com/problems/longest-common-prefix/}
 */
public class CommonLongestPrefix {
    public void run() {
        String[] strs = { "aa", "a"};
        Assert.areEquals("a", longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        if (strs.length == 1) return strs[0];

        String prefix = "";
        for (int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            int equalCount = 0;
            for (int j=0; j<strs.length; j++) {
                if (i > strs[j].length() - 1) break;

                if (strs[j].charAt(i) == c) {
                    equalCount++;
                }
            }

            if (equalCount == strs.length) {
                prefix += c;
            } else {
                break;
            }
        }

        return prefix;
    }
}
