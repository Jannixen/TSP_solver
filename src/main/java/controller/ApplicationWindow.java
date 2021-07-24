package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.genetic.GeneticAlgorithmResult;
import view.*;

import static controller.CitiesController.cities;
import static view.WindowProperties.WINDOW_HEIGHT;
import static view.WindowProperties.WINDOW_WIDTH;


public final class ApplicationWindow extends Stage {

    public static final ApplicationWindow APPLICATION_WINDOW = new ApplicationWindow();


    private final Scene scene;
    private final Group root = new Group();

    private MainWindowPane mainWindowPane;
    private HeaderPane headerPane;
    private DescriptionPane descriptionPane;
    private CityMapPane cityMapPane;
    private SidePane sidePane;

    CitiesController citiesController;

    private ApplicationWindow() {
        this.scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        buildWindow();
    }

    public static ApplicationWindow getApplicationWindow() {
        return APPLICATION_WINDOW;
    }

    private void buildWindow() {
        addPanes();
        addMouseListener(scene);
        addButtonListeners();

        this.setScene(scene);
        this.show();
    }

    private void addPanes() {
        mainWindowPane = new MainWindowPane();
        headerPane = new HeaderPane();
        cityMapPane = new CityMapPane();
        descriptionPane = new DescriptionPane();
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

    private EventHandler start() {
        EventHandler<ActionEvent> buttonHandler = event -> {
            System.out.println("Start");
            PathOptimizer pathOptimizer = new PathOptimizer();
            GeneticAlgorithmResult results = pathOptimizer.optimize();
            sidePane.showResult(String.format("%.2f", results.getBestGenomeObjective()));
            PathAnimator pathAnimator = new PathAnimator(cityMapPane);
            pathAnimator.animate(pathOptimizer.optimize().getBestGenome());
            event.consume();
        };
        return buttonHandler;
    }

    private EventHandler clear() {
        EventHandler<ActionEvent> buttonHandler = event -> {
            System.out.println("Clear");
            cityMapPane.getChildren().clear();
            cities.clear();
            citiesController.clearCitiesCounter();
            event.consume();
        };
        return buttonHandler;
    }


}
