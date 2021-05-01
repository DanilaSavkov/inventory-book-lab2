package bsuir.ppvis.view.dialogs.content;

import bsuir.ppvis.model.decomposition.RecordField;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.view.tableview.AppTableView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;

public class TableDialogContent extends BorderPane {
    private final ChoiceBox<RecordField> choiceBox;
    private final TextField textField;
    private final Button button;
    private final TableView<Record> tableView;

    public TableDialogContent(String dialogName) {
        super();
        this.tableView = new AppTableView();
        this.choiceBox = new ChoiceBox<>();
        this.button = new Button();
        this.textField = new TextField();
        setCenter(tableView);
        setTop(new BorderPane(textField, null, button, null, choiceBox));
        configureChoiceBox();
        configureTextField();
        configureButton(dialogName);
    }

    private void configureChoiceBox() {
        choiceBox.getItems().add(RecordField.ALL);
        choiceBox.getItems().add(RecordField.PRODUCT_NAME);
        choiceBox.getItems().add(RecordField.FABRICATOR_NAME);
        choiceBox.getItems().add(RecordField.FABRICATOR_NUMBER);
        choiceBox.getItems().add(RecordField.PRODUCT_COUNT);
        choiceBox.getItems().add(RecordField.STORAGE_ADDRESS);
        choiceBox.setValue(RecordField.ALL);
        choiceBox.setConverter(choiceBoxStringConverter());
        choiceBox.getSelectionModel().selectedItemProperty().addListener(choiceBoxChangeListener());
    }

    private void configureTextField() {
        textField.setDisable(true);
    }

    private void configureButton(String text) {
        button.setText(text);
    }

    private StringConverter<RecordField> choiceBoxStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(RecordField object) {
                return object.getName();
            }

            @Override
            public RecordField fromString(String string) {
                return RecordField.valueOf(string);
            }
        };
    }

    private ChangeListener<RecordField> choiceBoxChangeListener() {
        return new ChangeListener<RecordField>() {
            @Override
            public void changed(ObservableValue<? extends RecordField> observable, RecordField oldValue, RecordField newValue) {
                textField.setDisable(observable.getValue().equals(RecordField.ALL));
            }
        };
    }

    public ChoiceBox<RecordField> getChoiceBox() {
        return choiceBox;
    }

    public TextField getTextField() {
        return textField;
    }

    public Button getButton() {
        return button;
    }

    public TableView<Record> getTableView() {
        return tableView;
    }
}
