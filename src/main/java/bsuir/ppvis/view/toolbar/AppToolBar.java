package bsuir.ppvis.view.toolbar;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class AppToolBar {
    private static final double BUTTON_HEIGHT = 30;
    private static final double BUTTON_WIDTH = 90;
    private static final ToolBar TOOL_BAR = new ToolBar();
    private static final Button ADD_BUTTON = new Button("Добавить");
    private static final Button SEARCH_BUTTON = new Button("Найти");
    private static final Button DELETE_BUTTON = new Button("Удалить");

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