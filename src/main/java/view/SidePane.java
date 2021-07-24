package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static view.WindowProperties.*;

public class SidePane extends TemplatePane {

    Button startButton;
    Button clearButton;
    Label resultLabel;

    public SidePane() {
        super(SIDE_BUTTONS_PANE_POSITION_X, SIDE_BUTTONS_PANE_POSITION_Y, SIDE_BUTTONS_PANE_WIDTH, SIDE_BUTTONS_PANE_HEIGHT, SIDE_BUTTONS_PANE_BACKGROUND, false);
        makeSidePane();
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    private void makeSidePane() {
        startButton = makeStartButton();
        clearButton = makeClearButton();
        resultLabel = makeResultLabel("Result: \n");

        getChildren().add(startButton);
        getChildren().add(clearButton);
        getChildren().add(resultLabel);
    }

    public void showResult(String result){
        resultLabel.setText("Result: \n" + result);
    }

    private Button makeStartButton() {
        Button button = new Button("START");
        button.layoutXProperty().bind(widthProperty().subtract(button.widthProperty()).divide(2));
        button.layoutYProperty().bind(heightProperty().subtract(button.heightProperty()).divide(4));
        button.setPrefSize(80, 50);
        return button;
    }

    private Button makeClearButton() {
        Button button = new Button("CLEAR");
        button.layoutXProperty().bind(widthProperty().subtract(button.widthProperty()).divide(2));
        button.layoutYProperty().bind(heightProperty().subtract(button.heightProperty()).divide(2));
        button.setPrefSize(80, 50);
        return button;
    }


    private Label makeResultLabel(String result) {
        Label resultText = new Label(result);
        resultText.setFont(Font.font(RESULT_TEXT_FONT, FontWeight.BOLD, RESULT_TEXT_SIZE));
        resultText.setTextFill(RESULT_TEXT_COLOR);
        resultText.setBorder(new Border(new BorderStroke(RESULT_BORDER_COLOR,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        resultText.setWrapText(true);
        resultText.layoutXProperty().bind(widthProperty().subtract(resultText.widthProperty()).divide(2));
        resultText.layoutYProperty().bind(heightProperty().subtract(resultText.heightProperty()).divide(1.3));
        resultText.setPrefSize(80, 50);
        return resultText;
    }


}
