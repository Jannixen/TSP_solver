package controller;

import model.genetic.GeneticAlgorithm;
import model.genetic.GeneticAlgorithmResult;

import static controller.CitiesPresenter.cities;

public class PathOptimizer {


    public GeneticAlgorithmResult optimize() {
        if (cities.size() < 3) {
            System.out.println("You have to give at least 3 cities.");
        } else {
            int genomeSize = cities.size() - 1;
            int populationSize = 50;
            double mutationProbability = 0.2;
            int iterationMax = 1000;
            double[][] distanceMatrix = makeDistanceMatrix();

            GeneticAlgorithm testGeneticAlgorithm = new GeneticAlgorithm(genomeSize, populationSize, mutationProbability, iterationMax, distanceMatrix);
            testGeneticAlgorithm.runAlgorithm();
            System.out.println(testGeneticAlgorithm.getAlgorithmResult().getBestGenomeObjective());

            return testGeneticAlgorithm.getAlgorithmResult();

        }
        return null;
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
