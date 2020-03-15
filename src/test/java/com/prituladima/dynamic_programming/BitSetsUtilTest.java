package com.prituladima.dynamic_programming;

import com.prituladima.dynamic_programming.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.prituladima.dynamic_programming.BitSetsUtil.binaryString;
import static com.prituladima.dynamic_programming.util.ParametrizedArgumentSupplier.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitSetsUtilTest {

    public static Stream<Arguments> ARGUMENTS = fromFile(BIT_SET_UTIL);

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_bit_sets_util(File testCaseFile) throws FileNotFoundException {
        try (Scanner inScanner = new Scanner(testCaseFile)) {
            int amountOfTests = inScanner.nextInt();
            int set = inScanner.nextInt();
            inScanner.nextInt(2); //ignore

            char[] operations = new char[amountOfTests];
            int[] bits = new int[amountOfTests];
            int[] expectedAns = new int[amountOfTests];
            for (int i = 0; i < amountOfTests; i++) {
                inScanner.nextInt(2);//ignore
                operations[i] = inScanner.next().charAt(0);
                bits[i] = inScanner.nextInt();
                expectedAns[i] = inScanner.nextInt();
                inScanner.nextInt(2);//ignore
            }
            test_bit_sets_util(amountOfTests, set, operations, bits, expectedAns);
        }
    }

    void test_bit_sets_util(int amountOfTests, int set, char[] operations, int[] bits, int[] expectedAns) {
//        int copySet = set;
        for (int i = 0; i < amountOfTests; i++) {
            int operation = operations[i];
            if (operation == 'S') {
                assertEquals(expectedAns[i], BitSetsUtil.size(set));
            } else if (operation == 'R') {
                assertEquals(expectedAns[i], set = BitSetsUtil.remove(set, bits[i]));
            } else if (operation == 'A') {
                assertEquals(expectedAns[i], set = BitSetsUtil.add(set, bits[i]));
            } else if (operation == 'T') {
                assertEquals(expectedAns[i], set = BitSetsUtil.toggle(set, bits[i]));
            } else if(operation == 'C'){
                assertEquals(expectedAns[i], BitSetsUtil.contains(set, bits[i]) ? 1 : 0);
            }
        }
    }


    private static class TestGenerator {

        public static void main(String[] args) throws IOException {
            int[][] testConfigs = {
                    {1, 10, 3},
                    {2, 10, 3},
                    {3, 10, 5},
                    {4, 10, 5},
                    {5, 100, 10},
                    {6, 1000, 10},
                    {7, 10000, 20},
                    {8, 100000, 20},
//                    {9, 1000000, 2000000, 1_000_000},
            };
            for (int[] testConfig : testConfigs) {
                int testNumber = testConfig[0];
                int amountOfTests = testConfig[1];
                final int bitSetLen = testConfig[2];

                try (PrintWriter writer = new PrintWriter(new FileWriter(BASE + BIT_SET_UTIL + "/testcase" + testNumber + ".txt"))) {
                    writer.println(amountOfTests);
                    writer.println();

                    Random random = new Random();

                    int set = random.nextInt(1 << bitSetLen);
                    writer.print(set);
                    writer.print(' ');
                    writer.print(binaryString(set, bitSetLen));
                    writer.print(' ');
                    writer.println();
                    writer.println();

                    for (int i = 0; i < amountOfTests; i++) {
                        final int randVal = random.nextInt(5);
                        final int randomBit = random.nextInt(bitSetLen);
                        if (randVal == 0) {
                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                            writer.print('S');
                            writer.print(' ');
                            writer.print(-1);
                            writer.print(' ');
                            writer.print(BitSetsUtil.size(set));
                            writer.print(' ');

                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                        } else if (randVal == 1) {
                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');


                            writer.print('R');
                            writer.print(' ');
                            writer.print(randomBit);
                            writer.print(' ');
                            writer.print(set = BitSetsUtil.remove(set, randomBit));
                            writer.print(' ');

                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                        } else if (randVal == 2) {
                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                            writer.print('A');
                            writer.print(' ');
                            writer.print(randomBit);
                            writer.print(' ');
                            writer.print(set = BitSetsUtil.add(set, randomBit));
                            writer.print(' ');

                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                        } else if (randVal == 3) {
                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                            writer.print('T');
                            writer.print(' ');
                            writer.print(randomBit);
                            writer.print(' ');
                            writer.print(set = BitSetsUtil.toggle(set, randomBit));
                            writer.print(' ');

                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                        } else if (randVal == 4) {
                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');

                            writer.print('C');
                            writer.print(' ');
                            writer.print(randomBit);
                            writer.print(' ');
                            writer.print(BitSetsUtil.contains(set, randomBit) ? 1 : 0);
                            writer.print(' ');

                            writer.print(binaryString(set, bitSetLen));
                            writer.print(' ');
                        }

                        writer.println();
                    }
                }
            }
        }

    }

}
