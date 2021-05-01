package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.SearchController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.RecordField;
import bsuir.ppvis.model.decomposition.Record;
import javafx.collections.ObservableList;

public class SearchTableRecordsDialog extends TableRecordsDialog {
    private final SearchController controller;

    public SearchTableRecordsDialog(InventoryBookModel model) {
        super("Найти записи", model);
        controller = new SearchController(model);
        getContent().getButton().setOnAction(action -> {
            RecordField field = getContent().getChoiceBox().getValue();
            String value = getContent().getTextField().getText();
            getContent().getTableView().setItems((ObservableList<Record>) controller.find(field, value));
            getContent().getTextField().clear();
        });
    }
}