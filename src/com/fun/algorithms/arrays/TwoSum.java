package com.fun.algorithms.arrays;

import com.fun.algorithms.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {

    public void run() {
        int[] numbers = {2, 7, 11, 15};
        int[] result = twoSum(numbers, 9);

        int[] expected = {1, 2};
        Assert.areEquals(expected, result);

        int[] numbers2 = {0, 4, 3, 0};
        int[] expected2 = {1, 4};
        result = twoSum(numbers2, 0);
        Assert.areEquals(expected2, result);
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 1) return null;

        return spaceONAlgorithm(numbers, target);
    }

    public int[] spaceONAlgorithm(int[] numbers, int target) {
        Map<Integer, ArrayList<Integer>> set = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<numbers.length; i++) {
            if (!set.containsKey(numbers[i])) {
                set.put(numbers[i], new ArrayList<Integer>());
            }

            set.get(numbers[i]).add(i);
        }

        int[] two = new int[2];
        for (int i=0; i<numbers.length; i++) {
            two[0] = i + 1;
            int dist = target - numbers[i];
            if (set.containsKey(dist)) {
                ArrayList<Integer> arrayList = set.get(dist);
                for (int j=0; j<arrayList.size(); j++) {
                    if (i != arrayList.get(j)) {
                        two[1] = arrayList.get(j) + 1;
                        return two;
                    }
                }
            }
        }

        return null;
    }
}
