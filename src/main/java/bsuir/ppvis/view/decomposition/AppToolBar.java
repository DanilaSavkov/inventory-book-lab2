package bsuir.ppvis.view.decomposition;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class AppToolBar {
    private static final double BUTTON_SIZE = 75;
    private static final ToolBar TOOL_BAR = new ToolBar();
    private static final Button ADD_BUTTON = new Button("ADD");
    private static final Button SEARCH_BUTTON = new Button("SEARCH");
    private static final Button DELETE_BUTTON = new Button("DELETE");

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
        ADD_BUTTON.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
        SEARCH_BUTTON.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
        DELETE_BUTTON.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
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