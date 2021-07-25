package model.genetic;

import java.util.Random;

import static model.genetic.GeneticAlgorithmProperties.RANDOM_SEED;

abstract class RandomGenerator {

    protected Random randGenerator;

    RandomGenerator() {
        randGenerator = new Random();
        randGenerator.setSeed(RANDOM_SEED);
    }


}
