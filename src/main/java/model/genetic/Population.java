package model.genetic;

import model.ObjectiveFunctionCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Population {

    int populationSize;
    int[][] genomes;
    int genomeSize;

    public Population(int populationSize, int genomeSize) {
        this.populationSize = populationSize;
        this.genomeSize = genomeSize;

        RandomPopulationGenerator randomPopulationGenerator = new RandomPopulationGenerator();
        genomes = randomPopulationGenerator.makeRandomPopulation(populationSize, genomeSize);

    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getGenomeSize() {
        return genomeSize;
    }

    public int[][] getGenomes() {
        return genomes;
    }

    public void setGenomes(int[][] genomes) {
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

    void printPopulation(){
        for(int i=0; i<populationSize; i++){
            for (int j=0; j<genomeSize; j++){
                System.out.print(genomes[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
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

class OffspringPopulationGenerator {

    Random randGenerator;

    public OffspringPopulationGenerator() {

        randGenerator = new Random();
        randGenerator.setSeed(13);

    }

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