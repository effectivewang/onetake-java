package com.fun.algorithms.strings;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,

 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class WordLadder {

    public void run() {
        HashSet<String> set = new LinkedHashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");

        com.fun.algorithms.Assert.areEquals(5,
                ladderLength("hit", "cog", set));

        set.clear();
        set.add("hot");
        set.add("dog");

        com.fun.algorithms.Assert.areEquals(0,
                ladderLength("hot", "dog", set));

        String[] strings = {"hot","cog","dot","dog","hit","lot","log"};
        set.clear();
        for(String str : strings) {
            set.add(str);
        }
        com.fun.algorithms.Assert.areEquals(5,
                ladderLength("hit", "cog", set));
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() < 1) return 0;
        if (start.length() != end.length()) return 0;

        Queue<String> queue = new LinkedList<String>();
        queue.add(start);

        Set<String> visited = new HashSet<String>();
        int dist = ladderLength(queue, end, dict, visited);
        return dist;
    }

    /** ------------------------------------------------------------------------------ */
    // Recursion Method
    /* Recursion Method, O(n2) */
    private int ladderLength(Queue<String> level, String end, Set<String> dict, Set<String> visited) {
        int curLevel = level.size();
        int nextLevel = 0;
        int depth = 1;

        while (level.size() > 0){
            String cur = level.poll();
            curLevel--;

            if (!visited.contains(cur)) {
                for (int i = 0; i < end.length(); i++) {
                    char[] sample = cur.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        sample[i] = j;
                        String candidate = new String(sample);

                        if (candidate.equals(end)) {
                            return depth + 1;
                        } else if (!visited.contains(candidate) && dict.contains(candidate)) {
                            level.add(candidate);
                            nextLevel++;
                        }
                    }
                }
            }

            visited.add(cur);

            if (curLevel <= 0) {
                curLevel = nextLevel;
                nextLevel = 0;
                depth++;
            }
        }

        return 0;
    }
}