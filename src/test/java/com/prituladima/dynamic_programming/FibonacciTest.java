package com.prituladima.dynamic_programming;

import com.prituladima.dynamic_programming.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.prituladima.dynamic_programming.util.ParametrizedArgumentSupplier.*;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class FibonacciTest {

    public static Stream<Arguments> ARGUMENTS = fromFile(FIBONACCI);

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_fibonacci(File testCaseFile) throws FileNotFoundException {
        try (Scanner inScanner = new Scanner(testCaseFile)) {
            int amountOfTests = inScanner.nextInt();
            int[] numbers = new int[amountOfTests];
            int[] modules = new int[amountOfTests];
            int[] expectedAns = new int[amountOfTests];
            for (int i = 0; i < amountOfTests; i++) {
                numbers[i] = inScanner.nextInt();
                modules[i] = inScanner.nextInt();
                expectedAns[i] = inScanner.nextInt();
            }
            test_fibonacci(amountOfTests, numbers, modules, expectedAns);
        }
    }

    void test_fibonacci(int amountOfTests, int[] numbers, int[] modules, int[] expectedAns) {
        assertTimeout(ofSeconds(3), () -> {
            Fibonacci fibonacci = new Fibonacci();
            for (int i = 0; i < amountOfTests; i++) {
                long actual = fibonacci.get(numbers[i], modules[i]);
                if (actual < 0) {
                    throw new IllegalStateException("Result must be > 0");
                }
                assertEquals(expectedAns[i], actual);
            }
        });
    }


    private static class TestGenerator {

        public static void main(String[] args) throws IOException {
            int[][] testConfigs = {
                    {1, 10, 20, 1_000_000},
                    {2, 10, 20, 10},
                    {3, 10, 20, 2},
                    {4, 10, 20, 7},
                    {5, 100, 200, 1_000_000},
                    {6, 1000, 2000, 1_000_000},
                    {7, 10000, 20000, 1_000_000},
                    {8, 100000, 200000, 1_000_000},
//                    {9, 1000000, 2000000, 1_000_000},
            };
            for(int[] testConfig: testConfigs) {
                int testNumber = testConfig[0];
                int amountOfTests = testConfig[1];
                int nRange = testConfig[2];
                int moduloRange = testConfig[3];

                try (PrintWriter writer = new PrintWriter(new FileWriter(BASE + FIBONACCI + "/testcase" + testNumber + ".txt"))) {
                    writer.println(amountOfTests);
                    writer.println();
                    writer.println();
                    Random random = new Random();
                    Fibonacci fibonacci = new Fibonacci();
                    for (int i = 0; i < amountOfTests; i++) {
                        int n = random.nextInt(nRange);
                        long m = random.nextInt(moduloRange) + 1;
                        writer.print(n);
                        writer.print(' ');
                        writer.print(m);
                        writer.print(' ');
                        long fibonacciExpected = fibonacci.get(n, m);
                        if (fibonacciExpected < 0) throw new IllegalStateException("Result must be > 0");
                        writer.print(fibonacciExpected);
                        writer.println();
                    }
                }
            }
        }

    }
}
