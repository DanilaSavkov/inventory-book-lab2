package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.SearchController;
import bsuir.ppvis.model.InventoryBookModel;

public class SearchTableRecordsDialog extends TableRecordsDialog {
    private final SearchController controller;

    public SearchTableRecordsDialog(InventoryBookModel model) {
        super(SEARCH_RECORDS_TITLE, model);
        controller = new SearchController(model);
        getContent().getButton().setOnAction(action -> {
            searchRecords();
            getContent().getTextField1().clear();
            getContent().getTextField2().clear();
        });
    }
}