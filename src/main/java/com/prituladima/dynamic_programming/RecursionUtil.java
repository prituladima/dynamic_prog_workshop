package com.prituladima.dynamic_programming;

import java.util.Arrays;

public class RecursionUtil {


    public static String tabs(int level) {
        char[] chars = new char[level];
        Arrays.fill(chars, '\t');
        return String.valueOf(chars);
    }

}
