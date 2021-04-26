package bsuir.ppvis.view;

import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.view.decomposition.AppMenuBar;
import bsuir.ppvis.view.decomposition.AppPageControl;
import bsuir.ppvis.view.decomposition.AppTableView;
import bsuir.ppvis.view.decomposition.AppToolBar;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class AppView {
    private static final BorderPane VIEW = new BorderPane();
    private static final MenuBar MENU_BAR = AppMenuBar.getMenuBar();    // top
    private static final ToolBar TOOL_BAR = AppToolBar.getToolBar();    // left
    private static final BorderPane PAGE_CONTROL = AppPageControl.getPageControl();  // bottom
    private static final TableView<Record> TABLE = AppTableView.getTableView();    // center

    public AppView() {
        VIEW.setTop(MENU_BAR);
        MENU_BAR.setStyle("-fx-background-color: green;");
        VIEW.setLeft(TOOL_BAR);
        TOOL_BAR.setStyle("-fx-background-color: red;");
        VIEW.setBottom(PAGE_CONTROL);
        PAGE_CONTROL.setStyle("-fx-background-color: yellow;");
        VIEW.setCenter(TABLE);
    }

    public Parent asParent() {
        return VIEW;
    }
}
