package model.genetic;

import java.util.Random;

class RouletteSelection {

    Random randGenerator;

    public RouletteSelection() {
        randGenerator = new Random();
        randGenerator.setSeed(13);

    }

    int[] selectSurvivors(Population population, double[] populationObjectives){
        double[] fitness = calculateFitness(population,populationObjectives);
        int[] survivorsIndexes = new int[population.getPopulationSize()];
        for (int i = 0; i < population.getPopulationSize(); i++) {
            int genotypeToSurviveIndex = makeRouletteSelection(fitness);
            survivorsIndexes[i] = genotypeToSurviveIndex;
        }
        return survivorsIndexes;
    }

    int makeRouletteSelection(double[] fitness) {
        double selectedValue = randGenerator.nextDouble();
        int rouletteSelected = -1;
        int i = 0;
        while (rouletteSelected == -1 || i > fitness.length) {
            if (fitness[i] <= selectedValue & fitness[i + 1] > selectedValue) {
                rouletteSelected = i;
            }
            i++;
        }
        return rouletteSelected;
    }

    double[] calculateFitness(Population population, double[] objectiveResultsPerRow) {

        double[] fitness = new double[population.getPopulationSize()];
        double bestRowValue = population.getBestGenomeObjective(objectiveResultsPerRow);
        double sumFitness = 0;
        for (int popRow = 1; popRow < population.getPopulationSize(); popRow++) {
            fitness[popRow] = bestRowValue / objectiveResultsPerRow[popRow];
            sumFitness += fitness[popRow];
        }
        for (int popRow = 1; popRow <population.getPopulationSize(); popRow++) {
            fitness[popRow] = fitness[popRow] / sumFitness;
        }
        fitness = makeCumulativeSum(fitness);
        return fitness;
    }

    private double[] makeCumulativeSum(double[] vector) {

        double[] out = new double[vector.length];
        double sum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
            out[i] = sum;
        }
        return out;
    }


}
