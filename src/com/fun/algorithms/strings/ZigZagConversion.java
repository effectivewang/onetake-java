package com.fun.algorithms.strings;

import com.fun.algorithms.Assert;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

    public void run() {
        Assert.areEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        Assert.areEquals("AB", convert("AB", 1));
    }

    public String convert(String s, int nRows) {
        if (s == null || s == "") return  s;

        String[] strings = new String[nRows];
        for (int i=0; i<strings.length; i++)
            strings[i] = "";

        int step = 1;
        int row = 0;
        for (int i=0; i<s.length(); i++) {
            strings[row] += s.charAt(i);

            if (row == 0) {
                step = 1;
            } else if (row == nRows -1) {
                step = -1;
            }

            if (nRows == 1) step = 0;
            row += step;
        }

        String buffer = "";
        for (int i=0; i<nRows; i++) {
            buffer += (strings[i]);
        }

        return buffer.toString();
    }
}
