package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.genetic.GeneticAlgorithmResult;
import view.*;

import static controller.CitiesController.cities;
import static view.PanesProperties.WINDOW_HEIGHT;
import static view.PanesProperties.WINDOW_WIDTH;


class ApplicationWindow extends Stage {

    private final Scene scene;
    private final Group root = new Group();
    private CitiesController citiesController;
    private CityMapPane cityMapPane;
    private SidePane sidePane;

    ApplicationWindow() {
        this.scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        buildWindow();
    }

    private void buildWindow() {
        addPanes();
        addMouseListener(scene);
        addButtonListeners();

        this.setScene(scene);
        this.show();
    }

    private void addPanes() {
        MainWindowPane mainWindowPane = new MainWindowPane();
        HeaderPane headerPane = new HeaderPane();
        cityMapPane = new CityMapPane();
        DescriptionPane descriptionPane = new DescriptionPane();
        sidePane = new SidePane();

        mainWindowPane.getChildren().add(headerPane);
        mainWindowPane.getChildren().add(descriptionPane);
        mainWindowPane.getChildren().add(cityMapPane);
        mainWindowPane.getChildren().add(sidePane);

        this.root.getChildren().add(mainWindowPane);
    }

    private void addMouseListener(Scene scene) {
        scene.setOnMousePressed(event -> {
            citiesController = new CitiesController(cityMapPane);
            citiesController.checkIfClickInBorder(event);
        });
    }

    private void addButtonListeners() {
        sidePane.getStartButton().setOnAction(start());
        sidePane.getClearButton().setOnAction(clear());
    }

    private EventHandler<ActionEvent> start() {
        return event -> {
            if (cities.size() < 3) {
                new AlertWindow("Cities Number", "There should be at least 3 cities.");
            } else {
                PathOptimizer pathOptimizer = new PathOptimizer();
                GeneticAlgorithmResult results = pathOptimizer.optimize();
                sidePane.showResult(String.format("%.2f", results.getBestGenomeObjective()));
                PathAnimator pathAnimator = new PathAnimator(cityMapPane);
                pathAnimator.animate(pathOptimizer.optimize().getBestGenome());
                event.consume();
            }
        };
    }

    private EventHandler<ActionEvent> clear() {
        return event -> {
            cityMapPane.getChildren().clear();
            cities.clear();
            citiesController.clearCitiesCounter();
            event.consume();
        };
    }


}
