package controller;

import static controller.CitiesPresenter.cities;

public class PathOptimizer {


    PathOptimizer() {

    }

    private void optimize() {
        if (cities.isEmpty()) {
            System.out.println("Podaj jakieś miasta");
        } else {
            ;
        }
    }


    private double[][] makeDistanceMatrix() {
        int nCities = cities.size();
        double[][] distanceMatrix = new double[nCities][nCities];
        for (int i = 0; i < nCities; i++) {
            for (int j = 0; j < nCities; j++) {
                double distanceX = Math.abs(cities.get(i).getX() - cities.get(j).getX());
                double distanceY = Math.abs(cities.get(i).getY() - cities.get(j).getY());
                distanceMatrix[i][j] = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
            }
        }
        return distanceMatrix;
    }

}
