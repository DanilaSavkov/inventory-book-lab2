package bsuir.ppvis.view;

import bsuir.ppvis.controller.AddingController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.exceptions.XMLReadingException;
import bsuir.ppvis.model.exceptions.XMLWritingException;
import bsuir.ppvis.model.file.InventoryBookReader;
import bsuir.ppvis.model.file.InventoryBookWriter;
import bsuir.ppvis.view.menubar.AppMenuBar;
import bsuir.ppvis.view.pagecontrol.PageControl;
import bsuir.ppvis.view.tableview.AppTableView;
import bsuir.ppvis.view.toolbar.AppToolBar;
import bsuir.ppvis.view.menubar.menus.EditMenu;
import bsuir.ppvis.view.menubar.menus.FileMenu;
import bsuir.ppvis.view.dialogs.AddingDialog;
import bsuir.ppvis.view.dialogs.RemoveTableRecordsDialog;
import bsuir.ppvis.view.dialogs.SearchTableRecordsDialog;
import bsuir.ppvis.view.dialogs.TableRecordsDialog;
import javafx.beans.InvalidationListener;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class AppView {
    private final InventoryBookModel model;
    private final AddingController controller;
    private final FileChooser fileChooser;

    private static final BorderPane VIEW = new BorderPane();
    private static final MenuBar MENU_BAR = AppMenuBar.getMenuBar();    // top
    private static final ToolBar TOOL_BAR = AppToolBar.getToolBar();    // left
    private final BorderPane pageControl;  // bottom
    private static final TableView<Record> TABLE = new AppTableView();    // center

    public AppView(InventoryBookModel model, AddingController controller) {
        this.model = model;
        this.controller = controller;
        fileChooser = new FileChooser();

        pageControl = new PageControl(model);
        model.pageProperty().addListener((InvalidationListener) listener -> updateTableContent());

        configureFileChooser();
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
        VIEW.setBottom(pageControl);
        VIEW.setCenter(TABLE);
        TABLE.setItems(model.getPage());
    }

    private void configureToolBar() {
        AppToolBar.getAddButton().setOnAction(actionEvent -> addRecordOrNothing());
        AppToolBar.getSearchButton().setOnAction(actionEvent -> searchRecords());
        AppToolBar.getDeleteButton().setOnAction(actionEvent -> removeRecords());
    }

    private void configureMenuBar() {
        FileMenu.getOpenItem().setOnAction(actionEvent -> openTable());
        FileMenu.getSaveItem().setOnAction(actionEvent -> saveTable());
        EditMenu.getAddItem().setOnAction(actionEvent -> addRecordOrNothing());
        EditMenu.getDeleteItem().setOnAction(actionEvent -> removeRecords());
    }

    private void configureFileChooser() {
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName("Безымянный");
    }

    private void addRecordOrNothing() {
        Dialog<Record> dialog = new AddingDialog();
        Optional<Record> result = dialog.showAndWait();
        result.ifPresent(record -> controller.add(result.orElse(null)));
    }

    private void searchRecords() {
        TableRecordsDialog dialog = new SearchTableRecordsDialog(model);
        dialog.showAndWait();
    }

    private void removeRecords() {
        InventoryBookModel modelClone = new InventoryBookModel(model);
        TableRecordsDialog dialog = new RemoveTableRecordsDialog(modelClone);
        Optional<InventoryBookModel> result = dialog.showAndWait();
        result.ifPresent(record -> controller.setModel(result.orElse(model)));
        updateTableContent();
    }

    private void saveTable() {
        InventoryBookWriter writer = new InventoryBookWriter(model);
        File directory = fileChooser.showSaveDialog(new Stage());
        try {
            writer.writeXMLTo(directory);
        } catch (XMLWritingException e) {
            e.printStackTrace();
        }
    }

    private void openTable() {
        InventoryBookReader reader = new InventoryBookReader();
        File file = fileChooser.showOpenDialog(new Stage());
        try {
            InventoryBookModel model = reader.read(file);
            controller.setModel(model);
            updateTableContent();
        } catch (XMLReadingException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void updateTableContent() {
        TABLE.setItems((ObservableList<Record>) model.getPage());
    }
}