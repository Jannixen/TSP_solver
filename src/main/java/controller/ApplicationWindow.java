package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.*;

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
    private SideButtonsPane sideButtonsPane;

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
        sideButtonsPane = new SideButtonsPane();

        mainWindowPane.getChildren().add(headerPane);
        mainWindowPane.getChildren().add(descriptionPane);
        mainWindowPane.getChildren().add(cityMapPane);
        mainWindowPane.getChildren().add(sideButtonsPane);

        this.root.getChildren().add(mainWindowPane);
    }

    private void addMouseListener(Scene scene) {
        scene.setOnMousePressed(event -> {
            System.out.println("mouse click detected! " + event.getX() + ", " + event.getY());
            CitiesPresenter citiesPresenter = new CitiesPresenter(cityMapPane);
            citiesPresenter.checkIfClickInBorder(event);
        });
    }

    private void addButtonListeners() {
        sideButtonsPane.getStartButton().setOnAction(start());
        sideButtonsPane.getClearButton().setOnAction(clear());
    }

    private EventHandler start() {
        EventHandler<ActionEvent> buttonHandler = event -> {
            System.out.println("Start");
            PathOptimizer pathOptimizer = new PathOptimizer();
            PathAnimator pathAnimator = new PathAnimator(cityMapPane);
            pathAnimator.animate(new int[]{1, 2, 3, 4});
            event.consume();
        };
        return buttonHandler;
    }

    private EventHandler clear() {
        EventHandler<ActionEvent> buttonHandler = event -> {
            System.out.println("Clear");
            event.consume();
        };
        return buttonHandler;
    }


}
