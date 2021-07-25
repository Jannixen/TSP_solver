package model.genetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouletteSelectionTest {

    @Test
    public void should_returnFitness_cumulativeToOne() {
        Population population = new Population(10, 4);
        double[][] distance_matrix = {{0.0, 3.0, 4.0, 2.0, 7.0},
                {0.0, 3.0, 4.0, 6.0, 3.0},
                {4.0, 4.0, 0.0, 5.0, 8.0},
                {2.0, 6.0, 5.0, 0.0, 6.0},
                {7.0, 3.0, 8.0, 6.0, 0.0}};

        double[] objectives = population.applyObjectiveFunction(new ObjectiveFunctionCalculator(distance_matrix));
        RouletteSelection rouletteSelection = new RouletteSelection();
        double[] fitness = rouletteSelection.calculateFitness(population, objectives);
        assertEquals(1.0, fitness[9], 0.000001);

    }

    @Test
    public void should_properChooseWithRoulette() {
        Population population = new Population(10, 4);
        double[][] distance_matrix = {{0.0, 3.0, 4.0, 2.0, 7.0},
                {0.0, 3.0, 4.0, 6.0, 3.0},
                {4.0, 4.0, 0.0, 5.0, 8.0},
                {2.0, 6.0, 5.0, 0.0, 6.0},
                {7.0, 3.0, 8.0, 6.0, 0.0}};

        double[] objectives = population.applyObjectiveFunction(new ObjectiveFunctionCalculator(distance_matrix));
        RouletteSelection rouletteSelection = new RouletteSelection();
        double[] fitness = rouletteSelection.calculateFitness(population, objectives);
        int rouletteSelected = rouletteSelection.makeRouletteSelection(fitness);

        assertEquals(6, rouletteSelected);
    }
}