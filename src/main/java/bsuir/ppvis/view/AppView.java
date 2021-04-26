package bsuir.ppvis.view;

import bsuir.ppvis.controller.InventoryBookController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.exceptions.XMLReadingException;
import bsuir.ppvis.model.exceptions.XMLWritingException;
import bsuir.ppvis.model.file.InventoryBookReader;
import bsuir.ppvis.model.file.InventoryBookWriter;
import bsuir.ppvis.view.decomposition.AppMenuBar;
import bsuir.ppvis.view.decomposition.AppPageControl;
import bsuir.ppvis.view.decomposition.AppTableView;
import bsuir.ppvis.view.decomposition.AppToolBar;
import bsuir.ppvis.view.decomposition.menus.EditMenu;
import bsuir.ppvis.view.decomposition.menus.FileMenu;
import bsuir.ppvis.view.dialogs.AddingDialog;
import bsuir.ppvis.view.dialogs.AppChooser;
import bsuir.ppvis.view.styles.ViewStyles;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class AppView implements ViewStyles {
    private final InventoryBookModel model;
    private final InventoryBookController controller;

    private static final BorderPane VIEW = new BorderPane();
    private static final MenuBar MENU_BAR = AppMenuBar.getMenuBar();    // top
    private static final ToolBar TOOL_BAR = AppToolBar.getToolBar();    // left
    private static final BorderPane PAGE_CONTROL = AppPageControl.getPageControl();  // bottom
    private static final TableView<Record> TABLE = AppTableView.getTableView();    // center

    public AppView(InventoryBookModel model, InventoryBookController controller) {
        this.model = model;
        this.controller = controller;
        configureView();
    }

    public Parent asParent() {
        return VIEW;
    }

    private void configureView() {
        VIEW.setTop(MENU_BAR);
        configureMenuBar();
        VIEW.setLeft(TOOL_BAR);
        configureToolBar();
        VIEW.setBottom(PAGE_CONTROL);
        VIEW.setCenter(TABLE);
        TABLE.setItems((ObservableList<Record>) model.getRecords());
        setStyles();
    }

    private void configureToolBar() {
        AppToolBar.getAddButton().setOnAction(actionEvent -> addRecordOrNothing());
    }

    private void configureMenuBar() {
        FileMenu.getOpenItem().setOnAction(actionEvent -> openTable());
        FileMenu.getSaveItem().setOnAction(actionEvent -> saveTable());
        EditMenu.getAddItem().setOnAction(actionEvent -> addRecordOrNothing());
    }

    private void addRecordOrNothing() {
        Dialog<Record> dialog = new AddingDialog();
        Optional<Record> result = dialog.showAndWait();
        result.ifPresent(record -> controller.add(result.orElse(null)));
    }

    private void saveTable() {
        InventoryBookWriter writer = new InventoryBookWriter(model);
        File directory = AppChooser.getFileChooser().showSaveDialog(new Stage());
        try {
            writer.writeXMLTo(directory);
        } catch (XMLWritingException e) {
            e.printStackTrace();
        }
    }

    private void openTable() {
        InventoryBookReader reader = new InventoryBookReader();
        File file = AppChooser.getFileChooser().showOpenDialog(new Stage());
        try {
            InventoryBookModel model = reader.read(file);
            controller.rewrite(model);
        } catch (XMLReadingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setStyles() {
        MENU_BAR.setStyle(MENU_BAR_CSS_STYLE);
        TOOL_BAR.setStyle(TOOL_BAR_CSS_STYLE);
        PAGE_CONTROL.setStyle(PAGE_CONTROL_CSS_STYLE);
    }
}