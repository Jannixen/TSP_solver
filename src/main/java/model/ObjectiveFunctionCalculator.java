package model;

import java.util.Arrays;

public class ObjectiveFunctionCalculator {

    double[][] distanceMatrix;
    private static final int PENALTY = 10000;

    public ObjectiveFunctionCalculator(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public double calculate(int[] v) {
        int n = v.length;
        double out = distanceMatrix[0][v[0]];
        for (int i = 0; i < n - 1; i++) {
            out = out + distanceMatrix[v[i]][v[i + 1]];
        }
        out = out + distanceMatrix[v[n - 1]][0];
        if (checkForRepetitions(v.clone())) {
            out += PENALTY;
        }
        return out;
    }

    private boolean checkForRepetitions(int[] ints) {
        Arrays.sort(ints);

        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == ints[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
