package com.fun.algorithms.arrays;

import com.fun.algorithms.Assert;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaxSubArray {

    public void run() {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(numbers);

        Assert.areEquals(6, max);
    }

    public int maxSubArray(int[] A) {
        if (A == null || A.length < 1) return 0;

        return ONAlgorithm(A);
    }

    private int ONAlgorithm(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i=0; i<A.length; i++) {
            sum = sum + A[i];
            if (A[i] > sum) {
                sum = A[i];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
