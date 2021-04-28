package bsuir.ppvis.view.decomposition;

import bsuir.ppvis.view.styles.ToolBarTitles;
import javafx.css.Styleable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class AppToolBar implements ToolBarTitles {
    private static final double BUTTON_HEIGHT = 25;
    private static final double BUTTON_WIDTH = 75;
    private static final ToolBar TOOL_BAR = new ToolBar();
    private static final Button ADD_BUTTON = new Button(ADDING_TITLE);
    private static final Button SEARCH_BUTTON = new Button(SEARCH_TITLE);
    private static final Button DELETE_BUTTON = new Button(DELETE_TITLE);

    public static ToolBar getToolBar() {
        configureToolBar();
        return TOOL_BAR;
    }

    private static void configureToolBar() {
        TOOL_BAR.getItems().addAll(ADD_BUTTON, SEARCH_BUTTON, DELETE_BUTTON);
        TOOL_BAR.setOrientation(Orientation.VERTICAL);
        configureButtons();
    }

    private static void configureButtons() {
        ADD_BUTTON.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        SEARCH_BUTTON.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        DELETE_BUTTON.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    public static Button getAddButton() {
        return ADD_BUTTON;
    }

    public static Button getSearchButton() {
        return SEARCH_BUTTON;
    }

    public static Button getDeleteButton() {
        return DELETE_BUTTON;
    }
}