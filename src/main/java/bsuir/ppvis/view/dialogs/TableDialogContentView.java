package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.view.decomposition.AppTableView;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class TableDialogContentView extends BorderPane {
    private final ChoiceBox<String> choiceBox;
    private final TextField textField;
    private final Button button;
    private final TableView<Record> tableView;

    public TableDialogContentView(String dialogName) {
        super();
        this.tableView = new AppTableView();
        this.choiceBox = new ChoiceBox<>();
        this.button = new Button();
        this.textField = new TextField();
        setCenter(tableView);
        setTop(new BorderPane(textField, null, button, null, choiceBox));
        configureChoiceBox();
        configureButton(dialogName);
    }

    private void configureChoiceBox() {
        for (TableColumn column : tableView.getColumns()) {
            choiceBox.getItems().add(column.getText());
        }
    }

    private void configureButton(String text) {
        button.setText(text);
    }
}
