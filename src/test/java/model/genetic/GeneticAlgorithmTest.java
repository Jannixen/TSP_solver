package model.genetic;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GeneticAlgorithmTest {


    @Test
    public void should_returnGoodResult_when4Cities() {

        int genomeSize = 4;
        int populationSize = 5;
        double mutationProbability = 0.1;
        int iterationMax = 5;
        double[][] distanceMatrix = {{0.0, 3.0, 4.0, 2.0, 7.0},
                {1.0, 0.0, 4.0, 6.0, 3.0},
                {4.0, 4.0, 0.0, 5.0, 8.0},
                {2.0, 6.0, 5.0, 0.0, 6.0},
                {7.0, 3.0, 8.0, 6.0, 0.0}};


        GeneticAlgorithm testGeneticAlgorithm = new GeneticAlgorithm(genomeSize, populationSize, mutationProbability, iterationMax, distanceMatrix);
        testGeneticAlgorithm.runAlgorithm();
        double resultGenomeObjective = testGeneticAlgorithm.getAlgorithmResult().getBestGenomeObjective();
        int[] resultGenome = testGeneticAlgorithm.getAlgorithmResult().getBestGenome();

        System.out.println(resultGenomeObjective);
        for (int i=0; i< genomeSize; i++){
            System.out.println(resultGenome[i]);
        }
        assertEquals(19, resultGenomeObjective, 0.000001);
    }


    @Test
    public void should_returnGoodResult_when17Cities() {

        int genomeSize = 16;
        int populationSize = 500;
        double mutationProbability = 0.2;
        int iterationMax = 100000;
        double[][] distanceMatrix = readTestFile("src/test/resources/test2.txt", 17);

        GeneticAlgorithm testGeneticAlgorithm = new GeneticAlgorithm(genomeSize, populationSize, mutationProbability, iterationMax, distanceMatrix);
        testGeneticAlgorithm.runAlgorithm();
        double resultGenomeObjective = testGeneticAlgorithm.getAlgorithmResult().getBestGenomeObjective();
        int[] resultGenome = testGeneticAlgorithm.getAlgorithmResult().getBestGenome();

        System.out.println(resultGenomeObjective);
        for (int i=0; i< genomeSize; i++){
            System.out.println( resultGenome[i]);
        }
        assertEquals(2085, resultGenomeObjective, 0.00001);
    }


    private double[][] readTestFile(String fileName, int citiesNumber){
        Scanner scan;
        double[][] distance_matrix = new double[citiesNumber][citiesNumber];

        File file = new File(fileName);
        try {
            scan = new Scanner(file);

            for (int i = 0; i < citiesNumber; i++) {
                for (int j = 0; j < citiesNumber; j++) {
                    if (scan.hasNextInt()) {
                        distance_matrix[i][j] = scan.nextInt();
                    }
                }
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return distance_matrix;
    }
}