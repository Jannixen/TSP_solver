package view;

import javafx.scene.paint.Color;

import static controller.ApplicationProperties.CITIES_LIMIT;

public abstract class PanesProperties {


    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;


    public static final int CITY_MAP_PANE_POSITION_X = (int) (0.3 * WINDOW_WIDTH);
    public static final int CITY_MAP_PANE_POSITION_Y = (int) (0.3 * WINDOW_HEIGHT);
    public static final int CITY_MAP_PANE_HEIGHT = (int) (0.65 * WINDOW_HEIGHT);
    public static final int CITY_MAP_PANE_WIDTH = (int) (0.65 * WINDOW_WIDTH);
    public static final int CITY_POINT_SIZE = 7;


    static final Color MAIN_WINDOW_BACKGROUND = Color.BLANCHEDALMOND;


    static final int HEADER_PANE_POSITION_X = (int) (0.2 * WINDOW_WIDTH);
    static final int HEADER_PANE_POSITION_Y = (int) (0.05 * WINDOW_HEIGHT);
    static final int HEADER_PANE_HEIGHT = (int) (0.1 * WINDOW_HEIGHT);
    static final int HEADER_PANE_WIDTH = (int) (0.6 * WINDOW_WIDTH);

    static final Color HEADER_BACKGROUND = Color.BLANCHEDALMOND;
    static final int HEADER_TEXT_SIZE = 20;
    static final Color HEADER_TEXT_COLOR = Color.BLACK;
    static final String HEADER_TEXT_FONT = "Verdana";

    static final String TITLE_TEXT = "Travelling Salesman Problem";


    static final Color CITY_MAP_BACKGROUND = MAIN_WINDOW_BACKGROUND.darker();


    static final int DESCRIPTION_PANE_POSITION_X = (int) (0.1 * WINDOW_WIDTH);
    static final int DESCRIPTION_PANE_POSITION_Y = (int) (0.15 * WINDOW_HEIGHT);
    static final int DESCRIPTION_PANE_HEIGHT = (int) (0.1 * WINDOW_HEIGHT);
    static final int DESCRIPTION_PANE_WIDTH = (int) (0.8 * WINDOW_WIDTH);

    static final Color DESCRIPTION_BACKGROUND = Color.BLANCHEDALMOND;
    static final int DESCRIPTION_TEXT_SIZE = 10;
    static final Color DESCRIPTION_TEXT_COLOR = Color.BLACK;
    static final String DESCRIPTION_TEXT_FONT = "Verdana";

    static final String DESCRIPTION_TEXT = "Traveling Salesman Problem means given a list of cities and" +
            " the distances between each pair of cities, finding the shortest possible route that visits " +
            "each city exactly once and returns to the origin city. You can provide max. " + CITIES_LIMIT + " cities.";


    static final int SIDE_BUTTONS_PANE_POSITION_X = (int) (0.05 * WINDOW_WIDTH);
    static final int SIDE_BUTTONS_PANE_POSITION_Y = (int) (0.3 * WINDOW_HEIGHT);
    static final int SIDE_BUTTONS_PANE_HEIGHT = (int) (0.65 * WINDOW_HEIGHT);
    static final int SIDE_BUTTONS_PANE_WIDTH = (int) (0.2 * WINDOW_WIDTH);

    static final int RESULT_TEXT_SIZE = 10;
    static final Color RESULT_TEXT_COLOR = Color.BLACK.brighter();
    static final Color RESULT_BORDER_COLOR = Color.BLACK.brighter();
    static final String RESULT_TEXT_FONT = "Verdana";

    static final Color SIDE_BUTTONS_PANE_BACKGROUND = MAIN_WINDOW_BACKGROUND;


}