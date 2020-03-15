package com.prituladima.dynamic_programming;

import static com.prituladima.dynamic_programming.MatrixUtil.power;

public class RecurrenceRelation {

    /**
     * F(0) = 0
     * F(1) = 1
     * F(2) = 2
     * F(i) = aF(i - 1) + bF(i - 2) + cF(i - 3)
     */
    long getHomogeneous(int n, long a, long b, long c, long mod) {
        // TODO: 26.02.2020 Find N number in homogeneous recurrence relation
        throw new UnsupportedOperationException();
    }

    /**
     * F(0) = 0
     * F(1) = 1
     * F(i) = aF(i - 1) + bF(i - 2) + c
     */
    long getNonHomogeneous(int n, long a, long b, long c, long mod) {
        // TODO: 26.02.2020 Find N number in non-homogeneous recurrence relation
        throw new UnsupportedOperationException();
    }

}
