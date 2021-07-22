package view;

import javafx.scene.control.Label;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static view.WindowProperties.*;

public class DescriptionPane  extends TemplatePane {
    
    
    public DescriptionPane() {
        super(DESCRIPTION_PANE_POSITION_X, DESCRIPTION_PANE_POSITION_Y, DESCRIPTION_PANE_WIDTH, DESCRIPTION_PANE_HEIGHT, DESCRIPTION_BACKGROUND, false);
        getChildren().add(makeDescriptionTextLabel(DESCRIPTION_TEXT));
    }

    private Label makeDescriptionTextLabel(String description) {
        Label descriptionText = new Label(description);
        descriptionText.setFont(Font.font(DESCRIPTION_TEXT_FONT, FontWeight.LIGHT, DESCRIPTION_TEXT_SIZE));
        descriptionText.setTextFill(DESCRIPTION_TEXT_COLOR);
        descriptionText.setWrapText(true);
        descriptionText.setMaxWidth(DESCRIPTION_PANE_WIDTH);
        return descriptionText;
    }
}
