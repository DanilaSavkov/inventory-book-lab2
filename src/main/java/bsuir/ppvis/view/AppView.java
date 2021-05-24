package bsuir.ppvis.view;

import bsuir.ppvis.controller.AddingController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.exceptions.XMLReadingException;
import bsuir.ppvis.model.exceptions.XMLWritingException;
import bsuir.ppvis.model.file.InventoryBookReader;
import bsuir.ppvis.model.file.InventoryBookWriter;
import bsuir.ppvis.view.dialogs.*;
import bsuir.ppvis.view.menubar.AppMenuBar;
import bsuir.ppvis.view.pagecontrol.PageControl;
import bsuir.ppvis.view.tableview.AppTableView;
import bsuir.ppvis.view.toolbar.AppToolBar;
import bsuir.ppvis.view.menubar.menus.EditMenu;
import bsuir.ppvis.view.menubar.menus.FileMenu;
import javafx.beans.InvalidationListener;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class AppView extends BorderPane {
    private final InventoryBookModel model;
    private final AddingController controller;

    private final FileChooser fileChooser;
    private final MenuBar menuBar;
    private final ToolBar toolBar;
    private BorderPane pageControl;
    private final TableView<Record> tableView;

    public AppView(InventoryBookModel model) {
        this.model = model;

        toolBar = new AppToolBar();
        controller = new AddingController(model);
        fileChooser = new FileChooser();
        pageControl = new PageControl(model);
        tableView = new AppTableView();
        menuBar = new AppMenuBar();
        configure();
    }

    private void configure() {
        setTop(menuBar);
        setLeft(toolBar);
        setBottom(pageControl);
        setCenter(tableView);
        configureMenuBar();
        configureToolBar();
        configureFileChooser();
        configureTableView();
        configureModel();
    }

    private void configureTableView() {
        tableView.setItems(model.getPage());
    }

    private void configureModel() {
        model.pageProperty().addListener((InvalidationListener) listener -> updateTableContent());
    }

    private void configureToolBar() {
        AppToolBar.getAddButton().setOnAction(actionEvent -> addRecordOrNothing());
        AppToolBar.getSearchButton().setOnAction(actionEvent -> searchRecords());
        AppToolBar.getRemoveButton().setOnAction(actionEvent -> removeRecords());
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
        String message = "Запись добавлена!";
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        if (result.isPresent()) {
            controller.add(result.get());
        } else {
            message = "Запись не была добавлена";
            type = Alert.AlertType.WARNING;
        }
        Alert alert = new Alert(type);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void searchRecords() {
        InventoryBookModel modelClone = new InventoryBookModel(model);
        TableRecordsDialog dialog = new SearchTableRecordsDialog(modelClone);
        dialog.showAndWait();
    }

    private void removeRecords() {
        InventoryBookModel modelClone = new InventoryBookModel(model);
        int previousSize = modelClone.getRecords().size();
        int currentSize = previousSize;
        TableRecordsDialog dialog = new RemoveTableRecordsDialog(modelClone);
        Optional<InventoryBookModel> result = dialog.showAndWait();
        if (result.isPresent()) {
            controller.setModel(result.get());
            currentSize = modelClone.getRecords().size();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Было удалено " + (previousSize - currentSize) + " записей");
        alert.showAndWait();
        updateTableContent();
    }

    private void saveTable() {
        InventoryBookWriter writer = new InventoryBookWriter(model);
        File directory = fileChooser.showSaveDialog(new Stage());
        tryToSaveTable(writer, directory);
    }

    private void tryToSaveTable(InventoryBookWriter writer, File directory) {
        try {
            writer.writeXMLTo(directory);
        } catch (XMLWritingException e) {
            Alert alert = new FileAlert(e);
            alert.showAndWait();
        }
    }

    private void openTable() {
        InventoryBookReader reader = new InventoryBookReader();
        File file = fileChooser.showOpenDialog(new Stage());
        tryToOpenTable(reader, file);
    }

    private void tryToOpenTable(InventoryBookReader reader, File file) {
        try {
            InventoryBookModel model = reader.read(file);
            controller.setModel(model);
            updateTableContent();
        } catch (XMLReadingException e) {
            Alert alert = new FileAlert(e);
            alert.showAndWait();
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void updateTableContent() {
        tableView.setItems(model.getPage());
    }
}