package model.genetic;

import model.ObjectiveFunctionCalculator;


public class GeneticAlgorithm {

    int iterationMax;

    ObjectiveFunctionCalculator objectiveFunctionCalculator;
    Population population;
    Mutation mutation;
    RouletteSelection rouletteSelection;

    int[] bestGenome;
    double bestGenomeObjective;

    GeneticAlgorithm(int genomeSize, int populationSize, double mutationProbability, int iterationMax, double[][] distance_matrix) {
        this.iterationMax = iterationMax;

        population = new Population(populationSize, genomeSize);
        objectiveFunctionCalculator = new ObjectiveFunctionCalculator(distance_matrix);
        mutation = new Mutation(mutationProbability);
        rouletteSelection = new RouletteSelection();

    }

    public int[] getBestGenome() {
        return bestGenome;
    }

    public double getBestGenomeObjective() {
        return bestGenomeObjective;
    }

    public void runAlgorithm() {

        evaluate();
        for (int k = 2; k < iterationMax; k++) {

            int[] parents = selectParents();
            procreate(parents);
            mutation.mutate(population);
            evaluate();
        }
    }

    private int[] selectParents(){
        double [] objectives = population.applyObjectiveFunction(objectiveFunctionCalculator);
        return rouletteSelection.selectSurvivors(population,objectives);
    }

    private void procreate(int[] parents){
        OffspringPopulationGenerator offspringPopulationGenerator = new OffspringPopulationGenerator();
        population.setGenomes(offspringPopulationGenerator.makeOffsprings(parents, population));
    }

    private void evaluate() {
        double[] objectives = population.applyObjectiveFunction(objectiveFunctionCalculator);
        if (bestGenome == null) {
            bestGenome = population.getBestGenome(objectives);
            bestGenomeObjective = population.getBestGenomeObjective(objectives);
        } else if (population.getBestGenomeObjective(objectives) > bestGenomeObjective) {
            bestGenome = population.getBestGenome(objectives);
            bestGenomeObjective = population.getBestGenomeObjective(objectives);
        }
    }

}


