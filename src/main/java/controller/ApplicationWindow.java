package controller;


import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.City;
import view.CityMapPane;
import view.HeaderPane;
import view.MainWindowPane;

import java.util.HashMap;

import static view.WindowProperties.WINDOW_HEIGHT;
import static view.WindowProperties.WINDOW_WIDTH;


public final class ApplicationWindow extends Stage {

    public static final ApplicationWindow APPLICATION_WINDOW = new ApplicationWindow();


    private final Scene scene;
    private final Group root = new Group();
    private static int id_counter = 1;
    private static HashMap<Integer, City> cities;

    private ApplicationWindow() {
        this.scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        buildWindow();
    }

    public static ApplicationWindow makeApplicationWindow() {
        return APPLICATION_WINDOW;
    }

    private void buildWindow() {
        Pane mainWindowPane = new MainWindowPane();
        Pane headerPane = new HeaderPane();
        Pane cityMapPane = new CityMapPane();

        mainWindowPane.getChildren().add(headerPane);
        mainWindowPane.getChildren().add(cityMapPane);

        this.root.getChildren().add(mainWindowPane);
        this.setScene(scene);
        this.show();

        addMouseListener(scene);
    }

    private void addMouseListener(Scene scene) {
        scene.setOnMousePressed(event -> {
            System.out.println("mouse click detected! " + event.getX() + ", " + event.getY());
            City city_from_user = new City(event.getX(), event.getY());
            cities.put(id_counter++, city_from_user);
        });
    }

}
