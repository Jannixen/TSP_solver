package model.genetic;

class Crossover {


    int[] firstParent;
    int[] secondParent;
    int cutoff;
    int genomeSize;

    public Crossover(int[] firstParent, int[] secondParent, int cutoff, int genomeSize) {
        this.firstParent = firstParent;
        this.secondParent = secondParent;
        this.cutoff = cutoff;
        this.genomeSize = genomeSize;
    }


    int[] makeCrossover() {
        Integer[] repetitions = makeSequence(genomeSize);
        int[] offspring = new int[genomeSize];
        int j = 0;

        while (j < genomeSize ) {
            if (j <= cutoff) {
                offspring[j] = firstParent[j];
            } else {
                if (repetitions[secondParent[j] - 1] != -1) {
                    offspring[j] = secondParent[j];
                } else {
                    offspring[j] = findFirstWithoutRepetition(repetitions);
                }
            }
            repetitions[offspring[j] - 1] = -1;
            j++;
        }
        return offspring;
    }

    private Integer[] makeSequence(int range) {

        Integer[] arr = new Integer[range];
        for (int i = 1; i <= range; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }

    private int findFirstWithoutRepetition(Integer[] repetitions) {
        int k = 0;
        while (repetitions[k] == -1) {
            k++;
        }
        return repetitions[k];
    }

}
