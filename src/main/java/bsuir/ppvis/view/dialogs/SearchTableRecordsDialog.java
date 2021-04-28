package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.InventoryBookSearchController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.RecordField;
import bsuir.ppvis.model.decomposition.Record;
import javafx.collections.ObservableList;

public class SearchTableRecordsDialog extends TableRecordsDialog {
    private final InventoryBookSearchController controller;

    public SearchTableRecordsDialog(InventoryBookModel model) {
        super("Найти записи", model);
        this.controller = new InventoryBookSearchController(model);
        this.getContent().getButton().setOnAction(action -> {
            RecordField field = getContent().getChoiceBox().getValue();
            String value = getContent().getTextField().getText();
            getContent().getTableView().setItems((ObservableList<Record>) controller.find(field, value));
            getContent().getTextField().clear();
        });
    }


}