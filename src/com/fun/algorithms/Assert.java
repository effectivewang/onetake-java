package com.fun.algorithms;

public final class Assert {

    public static boolean areEquals(String a, String b) {
        boolean equals = false;
        if (a == null && b == null) equals = true;
        if (a == null) equals = b.equals(a);
        else equals = a.equals(b);

        if (!equals) {
            String msg = String.format("%s and %s are not equal", a, b);
            System.out.println(msg);
        }

        return equals;
    }

    public static boolean areEquals(boolean a, boolean b) { return areEquals(String.valueOf(a), String.valueOf(b)); }
    public static boolean areEquals(int a, int b) {
        return areEquals(String.valueOf(a), String.valueOf(b));
    }

    public static boolean areEquals(int[] a, int[] b) {
        boolean equals = true;
        if (a == null && b == null) equals = true;
        else if (a == null || b == null) equals = false;
        else if (a.length != b.length) equals = false;
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    equals = false;
                    break;
                }
            }
        }

        if (!equals) {
            System.out.println(String.format("%s and %s are not equal", join(a), join(b)));
        }

        return true;
    }

    private static String join(int[] array) {
        if (array == null) return "null";

        StringBuffer buffer = new StringBuffer();
        buffer.append('[');
        for(int i=0; i<array.length; i++){
            buffer.append(array[i]);

            if (i != array.length - 1) {
                buffer.append(',');
            }
        }
        buffer.append(']');
        return buffer.toString();
    }
}
