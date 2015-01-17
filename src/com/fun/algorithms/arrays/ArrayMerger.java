package com.fun.algorithms.arrays;

import com.fun.algorithms.Assert;

/**
 * Created by xionwang on 14/12/10.
 */
public class ArrayMerger {
    public int[] mergeSortedArray(int[] a, int[] b) {
        if (a.length < 1 && b.length < 1) return new int[0];
        if (a.length < 1) return b;
        if (b.length < 1) return a;

        int n = a.length + b.length;
        int c[] = new int[n];

        int i = 0; // cursor for a[]
        int j = 0; // cursor for b[]

        for (int k=0; k<n; k++) {
            if (i == a.length) {
                c[k] = a[j++];
                continue;
            }
            if (j == b.length) {
                c[k] = a[i++];
                continue;
            }

            int curA = a[i];
            int curB = b[j];

            if (curA <= curB && i<a.length) {
                c[k] = a[i++];
            } else {
                c[k] = b[j++];
            }
        }
        return c;
    }

// [1], [1]
// [,]
// [1,]
// [1, 1] Y

// [1], [] Y

// [1,2], [1]
// [,,]
// [1,,] i=1,j=0
// [1,1] i=1,j=1
// [1,1,2] i=2,j=1
// Y


    public void run() {
        int[] a = {2, 3};
        int[] b = {1};
        int[] e = {1,2,3};
        int c[] = mergeSortedArray(a, b);
        Assert.areEquals(e, c);
    }
}
