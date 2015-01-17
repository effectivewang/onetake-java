package com.fun.algorithms.strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class PalindromeValidtor {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() < 1) return true;

        int i=0;
        int j = s.length() - 1;

        while (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right)) {
                if (Character.toLowerCase(left) != Character.toLowerCase(right))
                    return false;

                i++;
                j--;
            } else if (!Character.isLetterOrDigit(left)) {
                i++;
            } else {
                j--;
            }
        }
        return true;
    }
}
