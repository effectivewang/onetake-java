package com.fun.algorithms.arrays;

import com.fun.algorithms.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *  [2],
 *  [3,4],
 *  [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public void run() {
        ArrayList<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>();
        List<Integer> secondRow = new ArrayList<Integer>();
        List<Integer> thirdRow = new ArrayList<Integer>();
        List<Integer> fourthRow = new ArrayList<Integer>();

        firstRow.add(2);
        secondRow.add(3);
        secondRow.add(4);

        thirdRow.add(6);
        thirdRow.add(5);
        thirdRow.add(7);

        fourthRow.add(4);
        fourthRow.add(1);
        fourthRow.add(8);
        fourthRow.add(3);

        Assert.areEquals(11, minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) return 0;

        int total = 0;
        ArrayList<Integer> minLen = new ArrayList<Integer>(triangle.size());

        throw new NotImplementedException();
    }
}
