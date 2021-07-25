package controller;

import model.genetic.GeneticAlgorithm;
import model.genetic.GeneticAlgorithmResult;

import static controller.ApplicationProperties.*;
import static controller.CitiesController.cities;

class PathOptimizer {


    GeneticAlgorithmResult optimize() {
        int genomeSize = cities.size() - 1;
        double[][] distanceMatrix = makeDistanceMatrix();
        int populationSize = choosePopulationSize(genomeSize);
        int iterationMax = chooseIterationMax(genomeSize);

        GeneticAlgorithm testGeneticAlgorithm = new GeneticAlgorithm(genomeSize, populationSize, MUTATION_PROBABILITY, iterationMax, distanceMatrix);
        testGeneticAlgorithm.runAlgorithm();

        return testGeneticAlgorithm.getAlgorithmResult();
    }

    private int choosePopulationSize(int genomeSize) {
        int populationSize;
        if (genomeSize <= GENOME_SIZE_BOUNDARY) {
            populationSize = POPULATION_SIZE_LOWER;
        } else {
            populationSize = POPULATION_SIZE_UPPER;
        }
        return populationSize;
    }

    private int chooseIterationMax(int genomeSize) {
        int iterationMax;
        if (genomeSize <= GENOME_SIZE_BOUNDARY) {
            iterationMax = ITERATION_MAX_LOWER;
        } else {
            iterationMax = ITERATION_MAX_UPPER;
        }
        return iterationMax;
    }


    private double[][] makeDistanceMatrix() {
        int nCities = cities.size();
        double[][] distanceMatrix = new double[nCities][nCities];
        for (int i = 0; i < nCities; i++) {
            for (int j = 0; j < nCities; j++) {
                double distanceX = Math.abs(cities.get(i).getX() - cities.get(j).getX());
                double distanceY = Math.abs(cities.get(i).getY() - cities.get(j).getY());
                distanceMatrix[i][j] = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
            }
        }
        return distanceMatrix;
    }

}
