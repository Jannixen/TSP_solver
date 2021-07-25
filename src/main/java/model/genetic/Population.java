package model.genetic;

import java.util.Arrays;
import java.util.Collections;

class Population {

    private final int populationSize;
    private final int genomeSize;
    private int[][] genomes;

    Population(int populationSize, int genomeSize) {
        this.populationSize = populationSize;
        this.genomeSize = genomeSize;

        RandomPopulationGenerator randomPopulationGenerator = new RandomPopulationGenerator();
        genomes = randomPopulationGenerator.makeRandomPopulation(populationSize, genomeSize);

    }

    int getPopulationSize() {
        return populationSize;
    }

    int getGenomeSize() {
        return genomeSize;
    }

    int[][] getGenomes() {
        return genomes;
    }

    void setGenomes(int[][] genomes) {
        this.genomes = genomes;
    }

    double[] applyObjectiveFunction(ObjectiveFunctionCalculator objectiveFunctionCalculator) {

        double[] objectives = new double[populationSize];
        for (int popRow = 0; popRow < populationSize; popRow++) {
            objectives[popRow] = objectiveFunctionCalculator.calculate(genomes[popRow]);
        }
        return objectives;
    }

    double getBestGenomeObjective(double[] objectives) {

        double minValue = objectives[0];
        for (int popRow = 1; popRow < populationSize; popRow++) {
            if (objectives[popRow] < minValue) {
                minValue = objectives[popRow];
            }
        }
        return minValue;
    }


    int[] getBestGenome(double[] objectives) {

        double minValue = objectives[0];
        int minIndex = 0;
        for (int popRow = 1; popRow < populationSize; popRow++) {
            if (objectives[popRow] < minValue) {
                minValue = objectives[popRow];
                minIndex = popRow;
            }
        }
        return genomes[minIndex];
    }

}

class RandomPopulationGenerator {

    int[][] makeRandomPopulation(int populationSize, int genomeSize) {
        int[][] randPopulation = new int[populationSize][genomeSize];
        for (int popRow = 0; popRow < populationSize; popRow++) {
            Integer[] arr = makeSequence(genomeSize);
            Collections.shuffle(Arrays.asList(arr));
            randPopulation[popRow] = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        }
        return randPopulation;
    }

    private Integer[] makeSequence(int range) {

        Integer[] arr = new Integer[range];
        for (int i = 1; i <= range; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }
}

class OffspringPopulationGenerator extends RandomGenerator {


    int[][] makeOffsprings(int[] parentsIndexes, Population population) {
        int[][] offsprings = new int[population.getPopulationSize()][population.getGenomeSize()];
        Crossover crossover;
        for (int i = 0; i < population.getPopulationSize(); i++) {
            int[] firstParent = population.getGenomes()[parentsIndexes[i]];
            int[] secondParent = population.getGenomes()[parentsIndexes[randGenerator.nextInt(population.getPopulationSize())]];
            int cutoff = randGenerator.nextInt(population.getGenomeSize() - 1);
            crossover = new Crossover(firstParent, secondParent, cutoff, population.getGenomeSize());
            int[] offspring = crossover.makeCrossover();
            offsprings[i] = offspring;
        }
        return offsprings;
    }
}