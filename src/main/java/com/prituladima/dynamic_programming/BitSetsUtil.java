package com.prituladima.dynamic_programming;

import java.util.Arrays;

public class BitSetsUtil {

    public static int size(int set) {
        // TODO: 29.02.2020 Find set size
        throw new UnsupportedOperationException();
    }

    public static boolean contains(int set, int bit) {
        // TODO: 29.02.2020 Find if set contains bit
        throw new UnsupportedOperationException();
    }

    public static int add(int set, int bit) {
        // TODO: 29.02.2020 Add bit in set
        throw new UnsupportedOperationException();
    }

    public static int remove(int set, int bit) {
        // TODO: 29.02.2020 Remove bit from set
        throw new UnsupportedOperationException();
    }

    public static int toggle(int set, int bit) {
        // TODO: 29.02.2020 Toggle bit in set
        throw new UnsupportedOperationException();
    }

    public static String binaryString(int set, int len) {
        final String binStr = Integer.toBinaryString(set);
        if (len <= binStr.length()) {
            return binStr;
        } else {
            char[] zeroes = new char[len - binStr.length()];
            Arrays.fill(zeroes, '0');
            return String.valueOf(zeroes) + binStr;
        }

    }
}