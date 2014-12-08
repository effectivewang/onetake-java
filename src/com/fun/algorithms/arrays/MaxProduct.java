package com.fun.algorithms.arrays;

import com.fun.algorithms.Assert;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProduct {
    public void run() {
        int[] array = {2,3,-2,4};
        Assert.areEquals(6, maxProduct(array));

        int[] array2 = {-2,3,-4};
        Assert.areEquals(24, maxProduct(array2));

        int[] array3 = {-2,0,-1};
        Assert.areEquals(0, maxProduct(array3));
    }

    public int maxProduct(int[] A) {
        if (A == null || A.length < 1) return 0;
        if (A.length == 1) return A[0];

        return maxProductDP(A);
    }

    private int maxProductDP(int[] A) {
        int[] maxDP = new int[A.length];
        int[] minDP = new int[A.length];

        int max = A[0];
        maxDP[0] = minDP[0] = A[0];
        for (int i=1; i<A.length; i++) {
            maxDP[i] = Math.max(maxDP[i-1] * A[i], minDP[i-1] * A[i]);
            minDP[i] = Math.min(minDP[i-1] * A[i], maxDP[i-1] * A[i]);

            max = Math.max(maxDP[i], max);
        }

        return max;
    }

    private int maxProductTwo(int[] A) {

        int maxProduct = A[0];
        int minProduct = A[0];

        int max = A[0];

        for(int i=1; i<A.length; i++) {
            if (A[i] < 0) {
                int temp = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }

            maxProduct = Math.max(A[i], maxProduct * A[i]);
            minProduct = Math.min(A[i], minProduct * A[i]);

            max = Math.max(maxProduct, max);
        }

        return max;
    }
}
