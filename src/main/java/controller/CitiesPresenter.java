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

public class CitiesPresenter {

    private static int id_counter = 1;
    protected static ArrayList<City> cities = new ArrayList<>();

    private Pane cityMapPane;

    protected CitiesPresenter(Pane cityMapPane) {
        this.cityMapPane = cityMapPane;
    }


    protected void checkIfClickInBorder(MouseEvent event) {
        if (event.getX() - CITY_MAP_PANE_POSITION_X < CITY_MAP_PANE_HEIGHT &
                event.getY() - CITY_MAP_PANE_POSITION_Y < CITY_MAP_PANE_WIDTH &
                event.getX() > CITY_MAP_PANE_POSITION_X &
                event.getY() > CITY_MAP_PANE_POSITION_Y) {
            checkIfInCitiesLimit(event);
        }
    }

    private void checkIfInCitiesLimit(MouseEvent event) {
        if (id_counter < CITIES_LIMIT) {
            City city_from_user = new City(event.getX(), event.getY(), id_counter);
            paintCity(city_from_user, id_counter);
            cities.add(city_from_user);
            id_counter++;
        }
    }

    private void paintCity(City city, int id) {
        Circle city_point = paintCityMakePoint(city);
        Text text_id = paintCityMakeText(city, id);

        pickRandomCityColor(city_point, text_id);

        cityMapPane.getChildren().add(city_point);
        cityMapPane.getChildren().add(text_id);
    }

    private Circle paintCityMakePoint(City city) {
        double point_x = city.getX() - CITY_MAP_PANE_POSITION_X;
        double point_y = city.getY() - CITY_MAP_PANE_POSITION_Y;

        return new Circle(point_x, point_y, CITY_POINT_SIZE, Color.BLACK);
    }

    private Text paintCityMakeText(City city, int id) {
        double text_x = city.getX() + CITY_POINT_SIZE - CITY_MAP_PANE_POSITION_X;
        double text_y = city.getY() - CITY_MAP_PANE_POSITION_Y;

        Text text_id = new Text(text_x, text_y, Integer.toString(id));

        if (id == 1) {
            text_id.setText("START - " + id);
        }

        return text_id;

    }

    private void pickRandomCityColor(Circle city_point, Text city_id) {
        Random random = new Random();

        int red = random.nextInt(255);
        int green = random.nextInt(90);
        int blue = random.nextInt(90);

        city_point.setFill(Color.rgb(red, green, blue, 0.6));
        city_id.setFill(Color.rgb(red, green, blue, 0.6));
    }


}
