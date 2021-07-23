package model.genetic;

public class GeneticAlgorithmResult {

    int[] bestGenome;
    double bestGenomeObjective;

    public GeneticAlgorithmResult(int genomeSize) {
        this.bestGenome = new int[genomeSize];
        this.bestGenomeObjective = Integer.MAX_VALUE;
    }

    public int[] getBestGenome() {
        return bestGenome;
    }

    public void setBestGenome(int[] bestGenome) {
        this.bestGenome = bestGenome;
    }

    public double getBestGenomeObjective() {
        return bestGenomeObjective;
    }

    public void setBestGenomeObjective(double bestGenomeObjective) {
        this.bestGenomeObjective = bestGenomeObjective;
    }
}
