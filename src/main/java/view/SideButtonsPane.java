package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import static view.WindowProperties.*;

public class SideButtonsPane extends TemplatePane {

    Button startButton;
    Button clearButton;

    public SideButtonsPane() {
        super(SIDE_BUTTONS_PANE_POSITION_X, SIDE_BUTTONS_PANE_POSITION_Y, SIDE_BUTTONS_PANE_WIDTH, SIDE_BUTTONS_PANE_HEIGHT, SIDE_BUTTONS_PANE_BACKGROUND, false);
        makeSideButtonsPane();
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    private void makeSideButtonsPane() {
        startButton = makeStartButton();
        clearButton = makeClearButton();

        getChildren().add(startButton);
        getChildren().add(clearButton);
    }

    private Button makeStartButton() {
        Button button = new Button("START");
        button.layoutXProperty().bind(widthProperty().subtract(button.widthProperty()).divide(2));
        button.layoutYProperty().bind(heightProperty().subtract(button.heightProperty()).divide(3));
        button.setPrefSize(80, 50);
        return button;
    }

    private Button makeClearButton() {
        Button button = new Button("CLEAR");
        button.layoutXProperty().bind(widthProperty().subtract(button.widthProperty()).divide(2));
        button.layoutYProperty().bind(heightProperty().subtract(button.heightProperty()).divide(1.5));
        button.setPrefSize(80, 50);
        return button;
    }


}
