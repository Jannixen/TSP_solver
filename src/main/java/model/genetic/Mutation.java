package model.genetic;


class Mutation extends RandomGenerator {

    private final double mutationProbability;

    Mutation(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    void mutate(Population population) {
        for (int popRow = 0; popRow < population.getPopulationSize(); popRow++) {
            for (int popCol = 0; popCol < population.getGenomeSize(); popCol++) {
                if (randGenerator.nextDouble() < mutationProbability) {
                    int randomCol = randGenerator.nextInt(population.getGenomeSize() - 1) + 1;
                    swap(new int[]{popRow, popCol}, new int[]{popRow, randomCol}, population.getGenomes());
                }
            }
        }
    }

    private void swap(int[] elem1, int[] elem2, int[][] matrix) {
        int tempSwap = matrix[elem1[0]][elem1[1]];
        matrix[elem1[0]][elem1[1]] = matrix[elem2[0]][elem2[1]];
        matrix[elem2[0]][elem2[1]] = tempSwap;
    }
}




