package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.RemoveController;
import bsuir.ppvis.controller.SearchController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.RecordField;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RemoveTableRecordsDialog extends TableRecordsDialog {
    private final RemoveController removeController;
    private final SearchController searchController;

    public RemoveTableRecordsDialog(InventoryBookModel model) {
        super("Удалить записи", model);
        removeController = new RemoveController(model);
        searchController = new SearchController(model);
        setResultConverter(dialogCallback());
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
        removeController.remove(getContent().getTableView().getItems());
        getContent().getTableView().setItems((ObservableList<Record>) getModel().getRecords());
    }

    private Callback<ButtonType, InventoryBookModel> dialogCallback() {
        return new Callback<ButtonType, InventoryBookModel>() {
            @Override
            public InventoryBookModel call(ButtonType param) {
                if (param.equals(getCancelButton())) return null;
                else return getModel();
            }
        };
    }
}