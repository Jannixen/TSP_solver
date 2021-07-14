package view;

import javafx.scene.paint.Color;

public abstract class WindowProperties {


    //window
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;

    public static final Color MAIN_WINDOW_BACKGROUND = Color.BLANCHEDALMOND;

    //header
    public static final int HEADER_PANE_POSITION_X = (int) (0.2 * WINDOW_WIDTH);
    public static final int HEADER_PANE_POSITION_Y = (int) (0.1 * WINDOW_HEIGHT);
    public static final int HEADER_PANE_HEIGHT = (int) (0.1 * WINDOW_HEIGHT);
    public static final int HEADER_PANE_WIDTH = (int) (0.6 * WINDOW_WIDTH);

    public static final Color HEADER_BACKGROUND = Color.BLANCHEDALMOND;
    public static final int HEADER_TEXT_SIZE = 20;
    public static final Color HEADER_TEXT_COLOR = Color.BLACK;

    //CityMap

    public static final int CITY_MAP_PANE_POSITION_X = (int) (0.2 * WINDOW_WIDTH);
    public static final int CITY_MAP_PANE_POSITION_Y = (int) (0.3 * WINDOW_HEIGHT);
    public static final int CITY_MAP_PANE_HEIGHT = (int) (0.6 * WINDOW_HEIGHT);
    public static final int CITY_MAP_PANE_WIDTH = (int) (0.6 * WINDOW_WIDTH);

    public static final Color CITY_MAP_BACKGROUND = MAIN_WINDOW_BACKGROUND.darker();


}