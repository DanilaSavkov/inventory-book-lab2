package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.RemoveController;
import bsuir.ppvis.controller.SearchController;
import bsuir.ppvis.model.InventoryBookModel;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RemoveTableRecordsDialog extends TableRecordsDialog {
    private final RemoveController removeController;
    private final SearchController searchController;

    public RemoveTableRecordsDialog(InventoryBookModel model) {
        super(REMOVE_RECORDS_TITLE, model);
        removeController = new RemoveController(model);
        searchController = new SearchController(model);
        setResultConverter(dialogCallback());
    }

    @Override
    public void configureContent(InventoryBookModel model) {
        super.configureContent(model);
        Button searchButton = new Button(SHOW_TITLE);
        ((BorderPane) getContent().getTop()).setRight(new HBox(searchButton, getContent().getButton()));
        searchButton.setOnAction(action -> searchRecords());
        getContent().getButton().setOnAction(action -> deleteRecords());
    }

    private void deleteRecords() {
        searchRecords();
        getContent().getPageControl().getChoiceBox().setValue(Integer.MAX_VALUE);
        removeController.remove(getContent().getTableView().getItems());
        configureContent(getModel());
        getContent().getTableView().setItems(getModel().getRecords());
        getContent().getTextField1().clear();
        getContent().getTextField2().clear();
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