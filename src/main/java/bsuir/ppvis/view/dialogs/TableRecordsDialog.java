package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.controller.ChoiceBoxConstants;
import bsuir.ppvis.controller.SearchController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.view.dialogs.content.TableDialogContent;
import bsuir.ppvis.view.pagecontrol.PageControl;
import bsuir.ppvis.view.style.Titles;
import javafx.beans.InvalidationListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public abstract class TableRecordsDialog extends Dialog<InventoryBookModel> implements Titles {
    private final InventoryBookModel model;
    private final TableDialogContent content;
    private static final ButtonType OK_BUTTON = new ButtonType(OK_TITLE, ButtonBar.ButtonData.APPLY);
    private static final ButtonType CANCEL_BUTTON = new ButtonType(CANCEL_TITLE, ButtonBar.ButtonData.CANCEL_CLOSE);

    public TableRecordsDialog(String title, InventoryBookModel model) {
        super();
        this.model = model;
        content = new TableDialogContent(title, this.model);
        setTitle(title);
        setResizable(true);
        getDialogPane().setContent(content);
        getDialogPane().getButtonTypes().addAll(OK_BUTTON, CANCEL_BUTTON);
        configureContent(this.model);
    }

    public void searchRecords() {
        SearchController controller = new SearchController(model);
        ChoiceBoxConstants field = getContent().getChoiceBox().getValue();
        String[] values = new String[2];
        values[0] = getContent().getTextField1().getText();
        values[1] = getContent().getTextField2().getText();
        for (int i = 0; i < 2; i++) {
            if (values[i].equals("")) values[i] = "\n";
        }
        InventoryBookModel newModel = new InventoryBookModel(controller.find(field, values));
        configureContent(newModel);
    }

    public void configureContent(InventoryBookModel model) {
        model.pageProperty().addListener((InvalidationListener) listener -> getContent().getTableView().setItems(model.getPage()));
        content.getTableView().setItems(model.getRecords());
        content.getPageControl().setModel(model);
    }

    public InventoryBookModel getModel() {
        return model;
    }

    public TableDialogContent getContent() {
        return content;
    }

    public static ButtonType getCancelButton() {
        return CANCEL_BUTTON;
    }
}