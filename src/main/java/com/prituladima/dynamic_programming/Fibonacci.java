package com.prituladima.dynamic_programming;

/**
 * F(0) = 0
 * F(1) = 1
 * F(i) = (F(i - 1) + F(i - 2)) % mod
 */
public class Fibonacci {

    long get(int n, long mod) {
        //TODO: 26.02.2020 Find N fibonacci number
        throw new UnsupportedOperationException();
    }


    public static void main(String[] args) {
        int mod = 2000000;
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i <= 20; i++) {
            System.out.printf("i = %d, fib = %d\n", i, fibonacci.get(i, mod));
        }
    }

}