package view;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class WindowProperties {


    //window
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;

    public static final Color MAIN_WINDOW_BACKGROUND = Color.BLANCHEDALMOND;

    //header
    public static final int HEADER_PANE_POSITION_X = (int) (0.2 * WINDOW_WIDTH);
    public static final int HEADER_PANE_POSITION_Y = (int) (0.05 * WINDOW_HEIGHT);
    public static final int HEADER_PANE_HEIGHT = (int) (0.1 * WINDOW_HEIGHT);
    public static final int HEADER_PANE_WIDTH = (int) (0.6 * WINDOW_WIDTH);

    public static final Color HEADER_BACKGROUND = Color.BLANCHEDALMOND;
    public static final int HEADER_TEXT_SIZE = 20;
    public static final Color HEADER_TEXT_COLOR = Color.BLACK;
    public static final String HEADER_TEXT_FONT = "Verdana" ;

    public static final String TITLE_TEXT = "Travelling salesman problem";
    
    //description
    public static final int DESCRIPTION_PANE_POSITION_X = (int) (0.1 * WINDOW_WIDTH);
    public static final int DESCRIPTION_PANE_POSITION_Y = (int) (0.15 * WINDOW_HEIGHT);
    public static final int DESCRIPTION_PANE_HEIGHT = (int) (0.1 * WINDOW_HEIGHT);
    public static final int DESCRIPTION_PANE_WIDTH = (int) (0.8 * WINDOW_WIDTH);

    public static final Color DESCRIPTION_BACKGROUND = Color.BLANCHEDALMOND;
    public static final int DESCRIPTION_TEXT_SIZE = 10;
    public static final Color DESCRIPTION_TEXT_COLOR = Color.BLACK;
    public static final String DESCRIPTION_TEXT_FONT = "Verdana" ;

    public static final String DESCRIPTION_TEXT = "Traveling Salesman Problem means given a list of cities and the distances between each pair of cities, finding the shortest possible route that visits each city exactly once and returns to the origin city.";

    //CityMap

    public static final int CITY_MAP_PANE_POSITION_X = (int) (0.3 * WINDOW_WIDTH);
    public static final int CITY_MAP_PANE_POSITION_Y = (int) (0.3 * WINDOW_HEIGHT);
    public static final int CITY_MAP_PANE_HEIGHT = (int) (0.65 * WINDOW_HEIGHT);
    public static final int CITY_MAP_PANE_WIDTH = (int) (0.65 * WINDOW_WIDTH);

    public static final int CITY_POINT_SIZE = 7;

    public static final Color CITY_MAP_BACKGROUND = MAIN_WINDOW_BACKGROUND.darker();

    public static final int CITIES_LIMIT = 7;
    
    // Buttons


    public static final int SIDE_BUTTONS_PANE_POSITION_X = (int) (0.05 * WINDOW_WIDTH);
    public static final int SIDE_BUTTONS_PANE_POSITION_Y = (int) (0.3 * WINDOW_HEIGHT);
    public static final int SIDE_BUTTONS_PANE_HEIGHT = (int) (0.65 * WINDOW_HEIGHT);
    public static final int SIDE_BUTTONS_PANE_WIDTH = (int) (0.2 * WINDOW_WIDTH);
    

    public static final Color SIDE_BUTTONS_PANE_BACKGROUND = MAIN_WINDOW_BACKGROUND;

}