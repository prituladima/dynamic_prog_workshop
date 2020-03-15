package com.prituladima.dynamic_programming;

import java.util.Arrays;

import static com.prituladima.dynamic_programming.BitSetsUtil.*;

// TODO: 15.03.2020 TaskC https://codeforces.com/gym/100124/attachments/download/1316/20122013-tryenirovka-spbgu-b-14-dinamichyeskoye-programmirovaniye-ru.pdf
//  https://codeforces.com/gym/100124
public class HamiltonianPath {

    private int vertexes;
    private int[][] costs;

    private long minCost;
    private int[] path;

    public HamiltonianPath(int vertexes, int[][] costs) {
        this.vertexes = vertexes;
        this.costs = costs;
    }

    public void findPath() {
        // TODO: 29.02.2020 Find and set minCost and build Hamiltonian path
        throw new UnsupportedOperationException();
    }

    public long getMinCost() {
        return minCost;
    }

    public int[] getPath() {
        return path;
    }


    public static void main(String[] args) {

        int vertexes = 5;
        int[][] costs = {
                {0, 183, 163, 173, 181},
                {183, 0, 165, 172, 171},
                {163, 165, 0, 189, 302},
                {173, 172, 189, 0, 167},
                {181, 171, 302, 167, 0},
        };


        HamiltonianPath hamiltonianPath = new HamiltonianPath(vertexes, costs);
        hamiltonianPath.findPath();

        System.out.println(hamiltonianPath.getMinCost());
        System.out.println(Arrays.toString(hamiltonianPath.getPath()));


    }
}
