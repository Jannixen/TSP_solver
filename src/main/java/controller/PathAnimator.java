package controller;

import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static controller.ApplicationProperties.*;
import static controller.CitiesController.cities;
import static view.PanesProperties.CITY_POINT_SIZE;

class PathAnimator {

    private final Pane citiesMapPane;

    PathAnimator(Pane citiesMapPane) {
        this.citiesMapPane = citiesMapPane;
    }

    void animate(int[] citiesPath) {
        var path = new Path();
        var voyager = new Rectangle(cities.get(0).getX(), cities.get(0).getY(), VOYAGER_DIAGONAL, VOYAGER_DIAGONAL);
        voyager.setFill(Color.BLACK);

        var pathTransition = new PathTransition();
        setPathTransition(pathTransition, path, voyager);
        setAnimationPaths(citiesPath, path);

        pathTransition.play();
        citiesMapPane.getChildren().addAll(path, voyager);
    }

    private void setPathTransition(PathTransition pathTransition, Path path, Rectangle voyager) {

        pathTransition.setDuration(Duration.seconds(ANIMATION_DURATION));
        pathTransition.setDelay(Duration.seconds(ANIMATION_DELAY));
        pathTransition.setPath(path);
        pathTransition.setNode(voyager);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

    }

    private void setAnimationPaths(int[] citiesPath, Path path) {
        int n = citiesPath.length;
        animateOneTransition(cities.get(0).getX(), cities.get(0).getY(), cities.get(citiesPath[0]).getX(), cities.get(citiesPath[0]).getY(), path, 1);
        for (int i = 0; i < n - 1; i++) {
            animateOneTransition(cities.get(citiesPath[i]).getX(), cities.get(citiesPath[i]).getY(), cities.get(citiesPath[i + 1]).getX(), cities.get(citiesPath[i + 1]).getY(), path, i + 2);
        }
        animateOneTransition(cities.get(citiesPath[n - 1]).getX(), cities.get(citiesPath[n - 1]).getY(), cities.get(0).getX(), cities.get(0).getY(), path, n + 1);

    }

    private void animateOneTransition(double x1, double y1, double x2, double y2, Path path, int nr) {

        path.getElements().add(new MoveTo(x1, y1));
        path.getElements().add(new LineTo(x2, y2));

        double textX = Math.min(x1, x2) + Math.abs(x1 - x2) / 2;
        double textY = Math.min(y1, y2) + Math.abs(y1 - y2) / 2 - CITY_POINT_SIZE;

        Text text = new Text(textX, textY, Integer.toString(nr));
        citiesMapPane.getChildren().add(text);
    }


}