package model.genetic;

import model.genetic.ObjectiveFunctionCalculator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ObjectiveFunctionCalculatorCalculatorTest {


    @Test
    public void should_returnResult_whenFiveCitiesInDistanceMatrix() {


        double[][] distance_matrix = {{0.0, 3.0, 4.0, 2.0, 7.0},
                {0.0, 3.0, 4.0, 6.0, 3.0},
                {4.0, 4.0, 0.0, 5.0, 8.0},
                {2.0, 6.0, 5.0, 0.0, 6.0},
                {7.0, 3.0, 8.0, 6.0, 0.0}};

        int[] cities_queue = {2, 3, 1, 4};


        ObjectiveFunctionCalculator testObjectiveFunctionCalculator = new ObjectiveFunctionCalculator(distance_matrix);


        double result = testObjectiveFunctionCalculator.calculate(cities_queue);
        Assertions.assertEquals(25, result);
    }


}