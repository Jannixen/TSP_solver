package model.genetic;


public class GeneticAlgorithm {

    private final int iterationMax;
    private final ObjectiveFunctionCalculator objectiveFunctionCalculator;
    private final Population population;
    private final Mutation mutation;
    private final RouletteSelection rouletteSelection;
    private final GeneticAlgorithmResult algorithmResult;

    public GeneticAlgorithm(int genomeSize, int populationSize, double mutationProbability, int iterationMax, double[][] distance_matrix) {
        this.iterationMax = iterationMax;

        population = new Population(populationSize, genomeSize);
        objectiveFunctionCalculator = new ObjectiveFunctionCalculator(distance_matrix);
        mutation = new Mutation(mutationProbability);
        rouletteSelection = new RouletteSelection();
        algorithmResult = new GeneticAlgorithmResult(genomeSize);

    }


    public void runAlgorithm() {
        evaluate();
        for (int k = 0; k < iterationMax; k++) {
            int[] parents = selectParents();
            procreate(parents);
            mutation.mutate(population);
            evaluate();
        }
    }


    public GeneticAlgorithmResult getAlgorithmResult() {
        return algorithmResult;
    }

    private int[] selectParents() {
        double[] objectives = population.applyObjectiveFunction(objectiveFunctionCalculator);
        return rouletteSelection.selectSurvivors(population, objectives);
    }

    private void procreate(int[] parents) {
        OffspringPopulationGenerator offspringPopulationGenerator = new OffspringPopulationGenerator();
        population.setGenomes(offspringPopulationGenerator.makeOffsprings(parents, population));
    }

    private void evaluate() {
        double[] objectives = population.applyObjectiveFunction(objectiveFunctionCalculator);
        if (algorithmResult.getBestGenome() == null ||
                population.getBestGenomeObjective(objectives) < algorithmResult.getBestGenomeObjective()) {
            algorithmResult.setBestGenome(population.getBestGenome(objectives));
            algorithmResult.setBestGenomeObjective(population.getBestGenomeObjective(objectives));
        }

    }

}


