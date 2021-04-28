package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.InventoryBookController;
import bsuir.ppvis.controller.InventoryBookSearchController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.RecordField;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class RemoveTableRecordsDialog extends TableRecordsDialog {
    private final InventoryBookController controller;
    private final InventoryBookSearchController searchController;

    public RemoveTableRecordsDialog(InventoryBookModel model) {
        super("Удалить записи", new InventoryBookModel(model));
        controller = new InventoryBookController(getModel());
        searchController = new InventoryBookSearchController(getModel());
    }

    @Override
    public void configureContent() {
        super.configureContent();
        Button searchButton = new Button("Показать");
        ((BorderPane) getContent().getTop()).setRight(new HBox(searchButton, getContent().getButton()));
        searchButton.setOnAction(action -> searchRecords());
        getContent().getButton().setOnAction(action ->deleteRecords());
    }

    private void searchRecords() {
        RecordField field = getContent().getChoiceBox().getValue();
        String value = getContent().getTextField().getText();
        getContent().getTableView().setItems((ObservableList<Record>) searchController.find(field, value));
        getContent().getTextField().clear();
    }

    private void deleteRecords() {
        for (Record record : getContent().getTableView().getItems()) {
            controller.remove(record);
        }
        getContent().getTableView().setItems((ObservableList<Record>) getModel().getRecords());
    }
}