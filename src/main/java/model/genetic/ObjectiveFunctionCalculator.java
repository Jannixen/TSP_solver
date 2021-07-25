package model.genetic;

import java.util.Arrays;

import static model.genetic.GeneticAlgorithmProperties.REPETITION_PENALTY;

class ObjectiveFunctionCalculator {

    double[][] distanceMatrix;

    ObjectiveFunctionCalculator(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    double calculate(int[] citiesPath) {
        int citiesNumber = citiesPath.length;
        double out = distanceMatrix[0][citiesPath[0]];
        for (int i = 0; i < citiesNumber - 1; i++) {
            out = out + distanceMatrix[citiesPath[i]][citiesPath[i + 1]];
        }
        out = out + distanceMatrix[citiesPath[citiesNumber - 1]][0];
        if (checkForRepetitions(citiesPath.clone())) {
            out += REPETITION_PENALTY;
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
