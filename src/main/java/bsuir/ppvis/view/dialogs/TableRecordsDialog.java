package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.view.dialogs.content.TableDialogContent;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public abstract class TableRecordsDialog extends Dialog<InventoryBookModel> {
    private InventoryBookModel model;
    private final TableDialogContent content;
    private static final ButtonType OK_BUTTON = new ButtonType("Ок", ButtonBar.ButtonData.APPLY);
    private static final ButtonType CANCEL_BUTTON = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);

    public TableRecordsDialog(String title, InventoryBookModel model) {
        super();
        this.model = model;
        this.content = new TableDialogContent(title);
        setTitle(title);
        setResizable(true);
        getDialogPane().setContent(content);
        getDialogPane().getButtonTypes().addAll(OK_BUTTON, CANCEL_BUTTON);
        configureContent();
    }

    public void configureContent() {
        getContent().getTableView().setItems((ObservableList<Record>) model.getRecords());
    }

    public InventoryBookModel getModel() {
        return model;
    }

    public TableDialogContent getContent() {
        return content;
    }

    public static ButtonType getOkButton() {
        return OK_BUTTON;
    }

    public static ButtonType getCancelButton() {
        return CANCEL_BUTTON;
    }
}