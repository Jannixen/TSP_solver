package model.genetic;

public class GeneticAlgorithmResult {

    private int[] bestGenome;
    private double bestGenomeObjective;

    public GeneticAlgorithmResult(int genomeSize) {
        this.bestGenome = new int[genomeSize];
        this.bestGenomeObjective = Integer.MAX_VALUE;
    }

    public int[] getBestGenome() {
        return bestGenome;
    }

    void setBestGenome(int[] bestGenome) {
        this.bestGenome = bestGenome;
    }

    public double getBestGenomeObjective() {
        return bestGenomeObjective;
    }

    void setBestGenomeObjective(double bestGenomeObjective) {
        this.bestGenomeObjective = bestGenomeObjective;
    }
}
