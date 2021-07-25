package view;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static view.PanesProperties.*;

public class HeaderPane extends TemplatePane {

    public HeaderPane() {
        super(HEADER_PANE_POSITION_X, HEADER_PANE_POSITION_Y, HEADER_PANE_WIDTH, HEADER_PANE_HEIGHT, HEADER_BACKGROUND, false);
        makeHeaderPane();
    }

    private void makeHeaderPane() {
        getChildren().add(makeTitleTextLabel());
    }


    private Label makeTitleTextLabel() {
        Label titleText = new Label(PanesProperties.TITLE_TEXT);
        titleText.setFont(Font.font(HEADER_TEXT_FONT, FontWeight.BOLD, HEADER_TEXT_SIZE));
        titleText.setTextFill(HEADER_TEXT_COLOR);
        titleText.setWrapText(true);
        return titleText;
    }

}
