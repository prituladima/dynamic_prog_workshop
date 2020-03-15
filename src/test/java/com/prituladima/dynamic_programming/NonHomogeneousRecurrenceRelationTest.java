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

public class NonHomogeneousRecurrenceRelationTest {

    public static Stream<Arguments> ARGUMENTS = fromFile(NON_HOMOGENEOUS_RECURRENCE_RELATION);

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_non_homogeneous_recurrence_relation(File testCaseFile) throws FileNotFoundException {
        try (Scanner inScanner = new Scanner(testCaseFile)) {
            int amountOfTests = inScanner.nextInt();
            int[] numbers = new int[amountOfTests];

            long[] baseA = new long[amountOfTests];
            long[] baseB = new long[amountOfTests];
            long[] baseC = new long[amountOfTests];

            int[] modules = new int[amountOfTests];
            int[] expectedAns = new int[amountOfTests];
            for (int i = 0; i < amountOfTests; i++) {
                numbers[i] = inScanner.nextInt();

                baseA[i] = inScanner.nextLong();
                baseB[i] = inScanner.nextLong();
                baseC[i] = inScanner.nextLong();

                modules[i] = inScanner.nextInt();
                expectedAns[i] = inScanner.nextInt();
            }
            test_non_homogeneous_recurrence_relation(amountOfTests, numbers, baseA, baseB, baseC, modules, expectedAns);
        }
    }

    void test_non_homogeneous_recurrence_relation(int amountOfTests, int[] numbers, long[] baseA, long[] baseB, long[] baseC, int[] modules, int[] expectedAns) {
        assertTimeout(ofSeconds(10), () -> {
            RecurrenceRelation recurrenceRelation = new RecurrenceRelation();
            for (int i = 0; i < amountOfTests; i++) {
                long actual = recurrenceRelation.getNonHomogeneous(numbers[i], baseA[i], baseB[i], baseC[i], modules[i]);
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
                    {1, 10, 2, 2, 2, 20, 1_000_000},
                    {2, 10, 2, 2, 2, 20, 10},
                    {3, 10, 5, 5, 5, 20, 2},
                    {4, 10, 5, 5, 5, 20, 7},
                    {5, 100, 10, 10, 10, 200, 1_000_000},
                    {6, 1000, 50, 50, 50, 2000, 1_000_000},
                    {7, 10000, 50, 50, 50, 20000, 1_000_000},
                    {8, 100000, 50, 50, 50, 200000, 1_000_000},
//                    {9, 1000000, 50, 50, 50, 2000000, 1_000_000},
            };
            for (int[] testConfig : testConfigs) {
                int testNumber = testConfig[0];
                int amountOfTests = testConfig[1];

                int aRange = testConfig[2];
                int bRange = testConfig[3];
                int cRange = testConfig[4];

                int nRange = testConfig[5];

                int moduloRange = testConfig[6];

                try (PrintWriter writer = new PrintWriter(new FileWriter(BASE + NON_HOMOGENEOUS_RECURRENCE_RELATION + "/testcase" + testNumber + ".txt"))) {
                    writer.println(amountOfTests);
                    writer.println();
                    writer.println();
                    Random random = new Random();
                    RecurrenceRelation recurrenceRelation = new RecurrenceRelation();
                    for (int i = 0; i < amountOfTests; i++) {
                        int n = random.nextInt(nRange);

                        int a = random.nextInt(aRange);
                        int b = random.nextInt(bRange);
                        int c = random.nextInt(cRange);

                        long mod = random.nextInt(moduloRange) + 1;
                        writer.print(n);
                        writer.print(' ');

                        writer.print(a);
                        writer.print(' ');

                        writer.print(b);
                        writer.print(' ');

                        writer.print(c);
                        writer.print(' ');

                        writer.print(mod);
                        writer.print(' ');
                        long expected = recurrenceRelation.getNonHomogeneous(n, a, b, c, mod);
                        if (expected < 0) {
                            throw new IllegalStateException("Result must be > 0");
                        }
                        writer.print(expected);
                        writer.println();
                    }
                }
            }
        }

    }

}
