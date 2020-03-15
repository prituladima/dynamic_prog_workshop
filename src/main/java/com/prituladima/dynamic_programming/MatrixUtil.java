package com.prituladima.dynamic_programming;

public class MatrixUtil {

    public static long[][] power(long[][] U, long n, long mod) {
        throw new UnsupportedOperationException();
    }

    public static long[][] multiply(long[][] V, long[][] U, long modulo) {
        final int n = V.length;
        long[][] R = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    R[i][j] += (V[i][k] % modulo) * (U[k][j] % modulo) % modulo;
                    R[i][j] %= modulo;
                }
            }
        }
        return R;
    }


    public static long[][] clone(long[][] P) {
        long[][] result = new long[P.length][];
        for (int i = 0; i < P.length; i++) {
            result[i] = P[i].clone();
        }
        return result;
    }

}
