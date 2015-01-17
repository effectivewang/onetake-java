package com.fun.algorithms.strings;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) return 0;
        if (haystack == null || needle == null) return -1;
        if (haystack.equals(needle)) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i=0; i + needle.length()<haystack.length(); i++) {
            boolean eq = true;
            for (int j=0; j<needle.length(); j++) {
                eq &= haystack.charAt(i+j) == needle.charAt(j);
            }
            if (eq) {
                return i;
            }
        }
        return -1;
    }
}
