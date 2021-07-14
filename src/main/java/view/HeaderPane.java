package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.TemplatePane;

import static view.WindowProperties.*;

public class HeaderPane extends TemplatePane {

    public HeaderPane() {
        super(HEADER_PANE_POSITION_X, HEADER_PANE_POSITION_Y, HEADER_PANE_WIDTH, HEADER_PANE_HEIGHT, HEADER_BACKGROUND, false);
        makeHeaderPane();
    }

    private void makeHeaderPane() {
        getChildren().add(makeTitleTextLabel("Comivoyager Problem Solver"));
    }


    private Label makeTitleTextLabel(String titleName) {
        Label titleText = new Label(titleName);
        titleText.setFont(Font.font("Verdana", FontWeight.BOLD, HEADER_TEXT_SIZE));
        titleText.setTextFill(HEADER_TEXT_COLOR);
        titleText.setMaxWidth(Double.MAX_VALUE);
        titleText.setAlignment(Pos.CENTER);
        titleText.setWrapText(true);
        return titleText;
    }
}
