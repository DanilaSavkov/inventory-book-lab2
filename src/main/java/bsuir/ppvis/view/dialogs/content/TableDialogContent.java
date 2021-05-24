package bsuir.ppvis.view.dialogs.content;

import bsuir.ppvis.controller.ChoiceBoxConstants;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.view.pagecontrol.PageControl;
import bsuir.ppvis.view.tableview.AppTableView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class TableDialogContent extends BorderPane {
    private final ChoiceBox<ChoiceBoxConstants> choiceBox;
    private final TextField textField1;
    private final TextField textField2;
    private final Button button;
    private final AppTableView tableView;
    private PageControl pageControl;

    public TableDialogContent(String dialogName, InventoryBookModel model) {
        super();
        this.tableView = new AppTableView();
        this.choiceBox = new ChoiceBox<>();
        this.button = new Button();
        this.textField1 = new TextField();
        this.textField2 = new TextField();
        this.pageControl = new PageControl(model);
        VBox textFields = new VBox(textField1, textField2);
        setCenter(tableView);
        setTop(new BorderPane(textFields, null, button, null, choiceBox));
        setBottom(pageControl);
        configureChoiceBox();
        configureTextFields();
        configureButton(dialogName);
    }

    private void configureChoiceBox() {
        choiceBox.getItems().add(ChoiceBoxConstants.ALL);
        choiceBox.getItems().add(ChoiceBoxConstants.PRODUCT);
        choiceBox.getItems().add(ChoiceBoxConstants.FABRICATOR);
        choiceBox.getItems().add(ChoiceBoxConstants.STORAGE);
        choiceBox.setValue(ChoiceBoxConstants.ALL);
        choiceBox.setConverter(choiceBoxStringConverter());
        choiceBox.getSelectionModel().selectedItemProperty().addListener(choiceBoxChangeListener());
    }

    private void configureTextFields() {
        textField1.setDisable(true);
        textField2.setDisable(true);
    }

    private void configureButton(String text) {
        button.setText(text);
    }

    private StringConverter<ChoiceBoxConstants> choiceBoxStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(ChoiceBoxConstants object) {
                return object.toString();
            }

            @Override
            public ChoiceBoxConstants fromString(String string) {
                return ChoiceBoxConstants.valueOf(string);
            }
        };
    }

    private ChangeListener<ChoiceBoxConstants> choiceBoxChangeListener() {
        return new ChangeListener<ChoiceBoxConstants>() {
            @Override
            public void changed(ObservableValue<? extends ChoiceBoxConstants> observable, ChoiceBoxConstants oldValue, ChoiceBoxConstants newValue) {
                textField1.setDisable(observable.getValue().equals(ChoiceBoxConstants.ALL));
                textField2.setDisable(observable.getValue().equals(ChoiceBoxConstants.ALL) || observable.getValue().equals(ChoiceBoxConstants.STORAGE));
            }
        };
    }

    public ChoiceBox<ChoiceBoxConstants> getChoiceBox() {
        return choiceBox;
    }

    public TextField getTextField1() {
        return textField1;
    }

    public TextField getTextField2() {
        return textField2;
    }

    public Button getButton() {
        return button;
    }

    public AppTableView getTableView() {
        return tableView;
    }

    public PageControl getPageControl() {
        return pageControl;
    }

    public void setPageControl(PageControl pageControl) {
        this.pageControl = pageControl;
    }
}
