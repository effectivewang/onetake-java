package com.fun.algorithms.arrays;

import com.fun.algorithms.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public void run() {
        String[] strings = {"a","abc","b","cd"};
        Set<String> dict = new HashSet<String>(Arrays.asList(strings));

        Assert.areEquals(true, wordBreak("abcd", dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() < 1) return false;
        if (dict == null || dict.size() < 1) return false;

        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[len] = true;

        for (int i=len-1; i>=0; i--) {
            for (int j=i; j<len; j++) {
                System.out.println(String.format("i: %s, j: %s", i, j));
                String str = s.substring(i, j+1);
                if (dict.contains(str) && dp[j+1]) {
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[0];
    }
}
