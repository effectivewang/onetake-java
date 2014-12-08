package com.fun.algorithms.arrays;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length < 1) return 0;

        int num = 0;
        for (int i=0; i<A.length; i++) {
            num ^= A[i];
        }

        return num;
    }
}
