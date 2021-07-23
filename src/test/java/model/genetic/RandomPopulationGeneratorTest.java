package model.genetic;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomPopulationGeneratorTest {

    @Test
    public void should_returnRandomPopulation() {
        RandomPopulationGenerator randomPopulationGenerator = new RandomPopulationGenerator();
        int[][] randPop = randomPopulationGenerator.makeRandomPopulation(4,4);
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.print(randPop[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}