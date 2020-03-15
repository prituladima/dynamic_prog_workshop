package com.prituladima.dynamic_programming.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    public static final String BASE = System.getProperty("user.dir") + "/src/test/";

    public static final String FIBONACCI = "sequences/fibonacci";
    public static final String NON_HOMOGENEOUS_RECURRENCE_RELATION = "sequences/recurrence_relation/non_homogeneous";
    public static final String HOMOGENEOUS_RECURRENCE_RELATION = "sequences/recurrence_relation/homogeneous";

    public static final String BIT_SET_UTIL = "bitset/util";
    public static final String HAMILTONIAN_PATH = "bitset/hamiltonian_path";


    private static final Map<String, ParametrizedArgumentSupplier> suppliers = new HashMap<>();

    static {
        suppliers.computeIfAbsent(FIBONACCI, key -> new ParametrizedArgumentSupplier(FIBONACCI));
        suppliers.computeIfAbsent(NON_HOMOGENEOUS_RECURRENCE_RELATION, key -> new ParametrizedArgumentSupplier(NON_HOMOGENEOUS_RECURRENCE_RELATION));
        suppliers.computeIfAbsent(HOMOGENEOUS_RECURRENCE_RELATION, key -> new ParametrizedArgumentSupplier(HOMOGENEOUS_RECURRENCE_RELATION));

        suppliers.computeIfAbsent(BIT_SET_UTIL, key -> new ParametrizedArgumentSupplier(BIT_SET_UTIL));
        suppliers.computeIfAbsent(HAMILTONIAN_PATH, key -> new ParametrizedArgumentSupplier(HAMILTONIAN_PATH));
    }

    public static Stream<Arguments> fromFile(String folder) {
        return suppliers.get(folder).get();
    }

    private final String folderName;

    private ParametrizedArgumentSupplier(String type) {
        this.folderName = BASE + type;
    }

    @Override
    public Stream<Arguments> get() {
        File folder = new File(folderName);
        return Arrays.stream(folder.listFiles())
                .filter(file -> !file.isDirectory())
                .map(Arguments::of);
    }
}