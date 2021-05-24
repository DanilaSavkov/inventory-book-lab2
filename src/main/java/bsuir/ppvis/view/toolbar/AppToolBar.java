package bsuir.ppvis.view.toolbar;

import bsuir.ppvis.view.style.Styles;
import bsuir.ppvis.view.style.Titles;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class AppToolBar extends ToolBar implements Titles, Styles {
    private static final double BUTTON_HEIGHT = 30;
    private static final double BUTTON_WIDTH = 90;

    private static final Button ADD_BUTTON = new Button(ADD_TITLE);
    private static final Button SEARCH_BUTTON = new Button(SEARCH_TITLE);
    private static final Button REMOVE_BUTTON = new Button(REMOVE_TITLE);

    public AppToolBar() {
        super(ADD_BUTTON, SEARCH_BUTTON, REMOVE_BUTTON);
        configure();
    }

    private void configure() {
        setOrientation(Orientation.VERTICAL);
        setStyle(TOOL_BAR_STYLE);
        configureButtons();
    }

    private static void configureButtons() {
        ADD_BUTTON.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        ADD_BUTTON.setStyle(TOOL_BUTTON_STYLE);
        SEARCH_BUTTON.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        SEARCH_BUTTON.setStyle(TOOL_BUTTON_STYLE);
        REMOVE_BUTTON.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        REMOVE_BUTTON.setStyle(TOOL_BUTTON_STYLE);
    }

    public static Button getAddButton() {
        return ADD_BUTTON;
    }

    public static Button getSearchButton() {
        return SEARCH_BUTTON;
    }

    public static Button getRemoveButton() {
        return REMOVE_BUTTON;
    }
}