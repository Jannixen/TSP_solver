package controller;

import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import static controller.CitiesPresenter.cities;

public class PathAnimator {

    private final Pane cityMapPane;

    public PathAnimator(Pane cityMapPane) {
        this.cityMapPane = cityMapPane;
    }

    public void animate(int[] citiesPath) {
        var path = new Path();
        var circle = new Circle(cities.get(0).getX(), cities.get(0).getY(), 5);
        circle.setFill(Color.BLACK);

        var pathTransition = new PathTransition();
        setPathTransition(pathTransition, path, circle);
        setAnimationPaths(citiesPath, path);

        pathTransition.play();
        cityMapPane.getChildren().addAll(path, circle);
    }

    private void setPathTransition(PathTransition pathTransition, Path path, Circle circle) {

        pathTransition.setDuration(Duration.seconds(6));
        pathTransition.setDelay(Duration.seconds(2));
        pathTransition.setPath(path);
        pathTransition.setNode(circle);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

    }

    private void setAnimationPaths(int[] citiesPath, Path path) {
        int n = citiesPath.length;
        animateOneTransition(cities.get(0).getX(), cities.get(0).getY(), cities.get(citiesPath[0]).getX(), cities.get(citiesPath[0]).getY(), path);
        for (int i = 0; i < n - 1; i++) {
            animateOneTransition(cities.get(citiesPath[i]).getX(), cities.get(citiesPath[i]).getY(), cities.get(citiesPath[i + 1]).getX(), cities.get(citiesPath[i + 1]).getY(), path);
        }
        animateOneTransition(cities.get(citiesPath[n - 1]).getX(), cities.get(citiesPath[n - 1]).getY(), cities.get(0).getX(), cities.get(0).getY(), path);

    }

    private void animateOneTransition(double x1, double y1, double x2, double y2, Path path) {

        path.getElements().add(new MoveTo(x1, y1));
        path.getElements().add(new LineTo(x2, y2));

    }


}