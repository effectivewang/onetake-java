package com.fun.algorithms.strings;

import com.fun.algorithms.Assert;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    public void run() {
        Assert.areEquals(2, minDistance("abc", "cab"));
        Assert.areEquals(3, minDistance("SUNDAY", "SATURDAY"));
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        int dp[][] = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for(int i=0; i<word1.length(); i++) dp[i+1][0] = i+1;
        for(int j=0; j<word2.length(); j++) dp[0][j+1] = j+1;

        for(int i=0; i<word1.length(); i++) {
            for(int j=0; j<word2.length(); j++) {
                dp[i+1][j+1] = word1.charAt(i) == word2.charAt(j) ?
                        dp[i][j] :
                        Math.min(
                                Math.min(dp[i+1][j], dp[i][j]),
                                dp[i][j+1])
                        + 1;
            }
        }

        for (int i=0; i<=word1.length(); i++) {
            System.out.println();
            for (int j=0; j<=word2.length(); j++) {
                System.out.print(String.format("%s\t", dp[i][j]));
            }
        }
        System.out.println();

        return dp[word1.length()][word2.length()];
    }
}
