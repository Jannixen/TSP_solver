package controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.City;

import java.util.ArrayList;
import java.util.Random;

import static view.WindowProperties.*;

public class CitiesController {

    private static int citiesCounter = 1;
    protected static ArrayList<City> cities = new ArrayList<>();

    private Pane citiesMapPane;

    protected CitiesController(Pane citiesMapPane) {
        this.citiesMapPane = citiesMapPane;
    }


    protected void checkIfClickInBorder(MouseEvent event) {
        if (event.getX() - CITY_MAP_PANE_POSITION_X < CITY_MAP_PANE_HEIGHT &
                event.getY() - CITY_MAP_PANE_POSITION_Y < CITY_MAP_PANE_WIDTH &
                event.getX() > CITY_MAP_PANE_POSITION_X &
                event.getY() > CITY_MAP_PANE_POSITION_Y) {
            checkIfInCitiesLimit(event);
        }
    }

    protected void clearCitiesCounter() {
        citiesCounter = 1;
    }

    private void checkIfInCitiesLimit(MouseEvent event) {
        if (citiesCounter < CITIES_LIMIT) {
            City cityFromUser = new City(event.getX() - CITY_MAP_PANE_POSITION_X, event.getY() - CITY_MAP_PANE_POSITION_Y, citiesCounter);
            paintCity(cityFromUser, citiesCounter);
            cities.add(cityFromUser);
            citiesCounter++;
        }
    }

    private void paintCity(City city, int id) {
        Circle cityPoint = paintCityMakePoint(city);
        Text textId = paintCityMakeText(city, id);

        pickRandomCityColor(cityPoint, textId);

        citiesMapPane.getChildren().add(cityPoint);
        citiesMapPane.getChildren().add(textId);
    }

    private Circle paintCityMakePoint(City city) {
        double pointX = city.getX();
        double pointY = city.getY();

        return new Circle(pointX, pointY, CITY_POINT_SIZE, Color.BLACK);
    }

    private Text paintCityMakeText(City city, int id) {
        double textX = city.getX();
        double textY = city.getY() - 2 * CITY_POINT_SIZE;

        Text textId = new Text(textX, textY, Integer.toString(id));

        if (id == 1) {
            textId.setText("START - " + id);
        }

        return textId;

    }

    private void pickRandomCityColor(Circle cityPoint, Text cityId) {
        Random random = new Random();

        int red = random.nextInt(255);
        int green = random.nextInt(90);
        int blue = random.nextInt(90);

        cityPoint.setFill(Color.rgb(red, green, blue, 0.6));
        cityId.setFill(Color.rgb(red, green, blue, 0.6));
    }


}
